package com.example.administrator.myparkingos;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.constant.ConstantConfig;
import com.example.administrator.myparkingos.constant.ConstantSharedPrefs;
import com.example.administrator.myparkingos.model.LoginRemoteRequest;
import com.example.administrator.myparkingos.model.RequestByURL;
import com.example.administrator.myparkingos.model.beans.Model;
import com.example.administrator.myparkingos.model.beans.gson.EntityOperator;
import com.example.administrator.myparkingos.model.beans.gson.EntityOperatorDetail;
import com.example.administrator.myparkingos.model.beans.gson.EntityRights;
import com.example.administrator.myparkingos.model.beans.gson.EntityStationSet;
import com.example.administrator.myparkingos.model.beans.gson.EntitySysSetting;
import com.example.administrator.myparkingos.model.beans.gson.EntitySystemTime;
import com.example.administrator.myparkingos.model.beans.gson.EntityToken;
import com.example.administrator.myparkingos.myUserControlLibrary.spinnerList.AbstractSpinerAdapter;
import com.example.administrator.myparkingos.myUserControlLibrary.spinnerList.SpinerPopWindow;
import com.example.administrator.myparkingos.ui.FormServerSetActivity;
import com.example.administrator.myparkingos.ui.onlineMonitorPage.ParkingMonitoringActivity;
import com.example.administrator.myparkingos.util.L;
import com.example.administrator.myparkingos.util.MD5Utils;
import com.example.administrator.myparkingos.util.RegexUtil;
import com.example.administrator.myparkingos.util.SPUtils;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, AbstractSpinerAdapter.IOnItemSelectListener
{
    private final String TAG = "LoginActivity";

    private EditText et_password;
    private Button btnLogin;
    private Button btnParkSet;
    private Button btnServerParamSet;
    private int indexUserName = 0;

    private String curStationID = "";

    private boolean bGetOperation = false;
    private boolean bGetStation = false;

    /**
     * 从服务器请求数据的数据的返回列表
     */
    List<EntityOperator> mEntityOperator = null;
    List<EntityStationSet> mEntityStationSet = null;
    EntityToken mToken;
    private String md5Password;
    EntitySysSetting mEntitySysSetting = null;
    EntitySystemTime getServerTime = null;

    /**
     * 显示用户姓名
     */
    private TextView tv_Uservalue;
    private SpinerPopWindow mUserSpinerPopWindow;
    private CustemSpinerAdapter mAdapter;
    private List<String> nameList = new ArrayList<String>();
    private ImageButton bt_Userdropdown;

    /**
     * 显示工作站点
     */
    private ImageButton bt_Stationdropdown;
    private TextView tv_Stationvalue;
    private CustemSpinerAdapter StationSpinerAdapter;
    private List<String> stationList = new ArrayList<String>();
    private SpinerPopWindow stationPopWindow;
    private int indexStationName = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
//        createConfigSettings();
//        ScreenUtils.setWindowPositionAndSize(this, 3, 2);

        getWindow().setTitleColor(Color.BLUE);
        initView();
        login_Loaded();
    }

    @Override
    protected void onRestart()
    {
        login_Loaded();
        super.onRestart();
    }

    /**
     * 创建配置文件，在程序执行时，即配置信息(可以将其放在Application进行初始化)
     */
    private void createConfigSettings()
    {
        SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext(), ConstantSharedPrefs.ServiceIP, ConstantConfig.ServerIP);
        SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext(), ConstantSharedPrefs.ServicePort, ConstantConfig.ServerPort);
    }


    private void initView()
    {
        et_password = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnParkSet = (Button) findViewById(R.id.btnParkSet);
        btnServerParamSet = (Button) findViewById(R.id.btnServerParamSet);

        btnLogin.setOnClickListener(this);
        btnParkSet.setOnClickListener(this);
        btnServerParamSet.setOnClickListener(this);

        tv_Uservalue = (TextView) findViewById(R.id.tv_Uservalue);
        tv_Uservalue.setOnClickListener(this);
        bt_Userdropdown = (ImageButton) findViewById(R.id.bt_Userdropdown);
        bt_Userdropdown.setOnClickListener(this);
        mAdapter = new CustemSpinerAdapter(this);
        mAdapter.refreshData(nameList, 0);
        mUserSpinerPopWindow = new SpinerPopWindow(this);
        mUserSpinerPopWindow.setAdatper(mAdapter);
        mUserSpinerPopWindow.setItemListener(this);

        tv_Stationvalue = (TextView) findViewById(R.id.tv_Stationvalue);
        tv_Stationvalue.setOnClickListener(this);
        bt_Stationdropdown = (ImageButton) findViewById(R.id.bt_Stationdropdown);
        bt_Stationdropdown.setOnClickListener(this);
        StationSpinerAdapter = new CustemSpinerAdapter(this);
        StationSpinerAdapter.refreshData(stationList, 0);
        stationPopWindow = new SpinerPopWindow(this);
        stationPopWindow.setAdatper(StationSpinerAdapter);
        stationPopWindow.setItemListener(new AbstractSpinerAdapter.IOnItemSelectListener()
        {
            @Override
            public void onItemClick(int pos)
            {
                setStationValue(pos);
                indexStationName = pos;
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLogin:
                btnLogin_Click();
                break;
            case R.id.btnParkSet:
                btnParkSet_Click();
                break;
            case R.id.btnServerParamSet:
                btnSet_Click(); //服务器设置
                break;
            case R.id.bt_Userdropdown:
                showUserSpinWindow();
                break;
            case R.id.bt_Stationdropdown:
                showStationSpinWindow();
                break;
        }
    }

    private void showStationSpinWindow()
    {
        stationPopWindow.setWidth(tv_Stationvalue.getWidth());
        stationPopWindow.showAsDropDown(tv_Stationvalue);
    }

    private void showUserSpinWindow()
    {
        mUserSpinerPopWindow.setWidth(tv_Uservalue.getWidth());
        mUserSpinerPopWindow.showAsDropDown(tv_Uservalue);
    }

    /**
     * 点击车场设置
     */
    private void btnParkSet_Click()
    {

    }

    /**
     * 点击服务器设置按钮
     */
    private void btnSet_Click()
    {
        Intent intent = new Intent(LoginActivity.this, FormServerSetActivity.class);
        startActivity(intent);
    }

    /**
     * 点击登录按钮
     */
    private void btnLogin_Click()
    {
        L.i("tv_Uservalue.getText().toString():" + tv_Uservalue.getText().toString());
        if (tv_Uservalue.getText().toString().equals(""))
        {
            Toast.makeText(LoginActivity.this, "请选择操作员", Toast.LENGTH_SHORT).show();
            return;
        }

        if (tv_Stationvalue.getText().toString().equals(""))
        {
            Toast.makeText(LoginActivity.this, "请选择工作站", Toast.LENGTH_SHORT).show();
            return;
        }

        final String password = et_password.getEditableText().toString();

//        "http://192.168.2.158:9000/ParkAPI/LoginUser?UserNo=888888&password=d41d8cd98f00b204e9800998ecf8427e"
        new Thread(new Runnable()
        {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void run()
            {
                ArrayMap<String, String> tempMap = new ArrayMap<String, String>();
                try
                {
                    md5Password = MD5Utils.MD5(password);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                Model.sUserPwd = md5Password;

                mToken = LoginRemoteRequest.LoginUser(mEntityOperator.get(indexUserName).getUserNO(), md5Password);
                Model.token = mToken.getToken();
                sendMessageByHandler(mToken, MSG_GetResponseToken, MSG_GETResponseTokenFailed);
            }
        }).start();
    }


    /**
     * 设置用户姓名 spinner下拉列表数据的数据显示
     *
     * @param list 列表数据
     */
    public void setUserNameSpainner(List<String> list, int index)
    {
        nameList.clear();
        nameList.addAll(list);
        mAdapter.refreshData(nameList, index);
        setUserValue(index);
    }

    /**
     * 设置工作站 spinner下拉列表数据的数据显示
     *
     * @param list 列表数据
     */
    public void setWorkStationSpinner(List<String> list, int index)
    {
        stationList.clear();
        stationList.addAll(list);
        StationSpinerAdapter.refreshData(stationList, index);
        setStationValue(index);
    }

    public void updConfig(List<EntityOperator> lstOper, List<EntityStationSet> lstSt)
    {
        if (lstOper != null && lstOper.size() > 0)
        {
            List<String> userList = new ArrayList<String>();
            for (int i = 0; i < lstOper.size(); i++)
            {
                userList.add(lstOper.get(i).getUserName());
            }
            setUserNameSpainner(userList, 0);
        }

        if (lstSt != null && lstSt.size() > 0)
        {
            List<String> stationList = new ArrayList<String>();
            for (int i = 0; i < lstOper.size(); i++)
            {
                stationList.add(String.valueOf(lstSt.get(i).getStationName()));// 把站点名放到列表中
            }
            int selectIndex = 0;
            if (stationList.size() > 0)
            {
                if (curStationID != null && curStationID != "")
                {
                    for (int i = 0; i < lstSt.size(); i++)
                    {
                        if (Short.parseShort(curStationID) == lstSt.get(i).getStationId())
                        {
                            selectIndex = i;
                            break;
                        }
                        if (i == lstSt.size() - 1)
                        {
                            selectIndex = 0;
                        }
                    }
                }
                else
                {
                    selectIndex = 0;
                }
            }
            setWorkStationSpinner(stationList, selectIndex);
        }
    }

    private void login_Loaded()
    {
        if (SPUtils.checkPathExist(getApplicationContext(), ConstantSharedPrefs.FileAppSetting))
        {
            String serviceIP = (String) SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                    , ConstantSharedPrefs.ServiceIP, "");
            String servicePort = (String) SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                    , ConstantSharedPrefs.ServicePort, "");
            String tempStationID = (String) SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                    , ConstantSharedPrefs.StationID, "");

            Model.serverIP = serviceIP;
            Model.serverPort = servicePort; // 重新读取服务器的配置文件
            RequestByURL.setAddress(serviceIP, Integer.parseInt(servicePort));

            L.i("serviceIP:" + serviceIP + ",servicePort:" + servicePort + ", tempStationID:" +
                    tempStationID + ",RequestByURL.address:" + RequestByURL.address);

            curStationID = (RegexUtil.checkDigit(tempStationID) == true) ? tempStationID : "";// 已经读取了工作数据
            if (!RegexUtil.checkIpAddress(serviceIP) || !RegexUtil.checkDecimals(servicePort))
            {
                Log.i(TAG, "RegexUtil serviceIP:" + serviceIP + ",servicePort:" + servicePort);
                Toast.makeText(LoginActivity.this, "服务IP或端口格式不正确,请重新配置", Toast.LENGTH_SHORT).show();
            }
            else
            {
                // 在主线程中不能网络获取数据，需要开启线程
                new Thread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        mEntityOperator = LoginRemoteRequest.GetOperatorsWithoutLogin();
                        sendMessageByHandler(mEntityOperator, MSG_GetOperator, MSG_GetOperatorFailed);

                        mEntityStationSet = LoginRemoteRequest.GetStationSetWithoutLogin("StationId");
                        sendMessageByHandler(mEntityStationSet, MSG_GetStationSet, MSG_GetStationSetFailed);
                    }
                }).start();

                // 然后3s异步投递消息
                mLoginHandler.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (bGetOperation == true && bGetStation == true)
                        {
                            // 更新界面数据
                            updConfig(mEntityOperator, mEntityStationSet);//投递到handler执行，肯定是主线程
                        }
                        else
                        {
                            // 从服务器获取数据失败，进入服务器参数设置界面
                            Intent intent = new Intent(LoginActivity.this, FormServerSetActivity.class);
                            startActivity(intent);
                        }
                    }
                }, 3000);
            }
        }
        else
        {
            showDialog("配置文件丢失，请联系管理员");
        }
    }

    private <T> void sendMessageByHandler(T t, int successMsg, int failedMsg)
    {
        Message msg = mLoginHandler.obtainMessage();
        if (t == null)
        {
            msg.what = failedMsg;
        }
        else
        {
            msg.what = successMsg;
//            msg.obj = t;
        }
        mLoginHandler.sendMessage(msg);
    }

    /**
     * handler 的消息
     */
    private final int MSG_GetOperator = 0x10;
    private final int MSG_GetStationSet = 0x11;
    private final int MSG_GetOperatorFailed = 0x12;
    private final int MSG_GetStationSetFailed = 0x13;
    private final int MSG_GetResponseToken = 0x14;
    private final int MSG_GETResponseTokenFailed = 0x15;

    private final int MSG_GetRight = 0x16;
    private final int MSG_GetRightFailed = 0x17;

    private Handler mLoginHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case MSG_GetOperator:
                {
                    Log.i(TAG, "MSG_GetOperator......");
                    bGetOperation = true;
                    updConfig(mEntityOperator, mEntityStationSet);
                    break;
                }
                case MSG_GetStationSet:
                {
                    Log.i(TAG, "MSG_GetStationSet......");
                    bGetStation = true;
                    updConfig(mEntityOperator, mEntityStationSet);
                    break;
                }
                case MSG_GetOperatorFailed:
                {
                    Log.i(TAG, "MSG_GetOperatorFailed......");
                    bGetOperation = false;
                    break;
                }
                case MSG_GetStationSetFailed:
                {
                    Log.i(TAG, "MSG_GetStationSetFailed......");
                    bGetStation = false;
                    break;
                }
                case MSG_GETResponseTokenFailed:
                {
                    Log.i(TAG, "获取RequestToken数据失败");
                    break;
                }
                case MSG_GetResponseToken:
                {
                    handlerLoginRequest(msg);
                    break;
                }
                case MSG_GetRight:
                {
                    if (Model.lstRights == null || Model.lstRights.size() <= 0)
                    {
                        Toast.makeText(LoginActivity.this, "无进入在线监控权限", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        // 获取是否有在线监控的权限
                        if (isHaveRightsByName("在线监控", "CmdView"))
                        {
                            Intent intent = new Intent(LoginActivity.this, ParkingMonitoringActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "无进入在线监控权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                }
                case MSG_GetRightFailed:
                {
                    Toast.makeText(LoginActivity.this, "无进入在线监控权限", Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
    };

    /**
     * 判断是否有指定的权限
     *
     * @param fromName
     * @param itemName
     * @return
     */
    private boolean isHaveRightsByName(String fromName, String itemName)
    {
        boolean result = false;
        // 从right获取出相应的权限
        for (int i = 0; i < Model.lstRights.size(); i++)
        {
            EntityRights tmpRights = Model.lstRights.get(i);
            if (tmpRights.getFormName().equals(fromName)
                    && tmpRights.getItemName().equals(itemName))
            {
                if (tmpRights.isCanOperate())
                {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void handlerLoginRequest(Message msg)
    {
        Model.stationID = mEntityStationSet.get(indexStationName).getStationId();
        Model.iParkingNo = mEntityStationSet.get(indexStationName).getCarparkNO();

        if (SPUtils.checkPathExist(getApplicationContext(), ConstantSharedPrefs.FileAppSetting)) // 配置文件存在
        {
            if (curStationID != null && curStationID != "")// curStationID在onCreate中已经获取到了
            {
                if (Model.stationID == Integer.parseInt(curStationID))
                {

                }
                else
                {
                    // 界面判断是否需要切换工作站点
                    showWorkStationSwitchDialog("是否切换工作站，请谨慎操作?", indexStationName);
                }
            }
            else
            {
                //保存站点即可
                SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext(),
                        ConstantSharedPrefs.StationID, String.valueOf(Model.stationID));
                curStationID = String.valueOf(Model.stationID);
            }
        }

        new Thread(new Runnable()//        DataSourceToPubVar() 获取车场设置，主要是对Model的数据的填充
        {
            @Override
            public void run()
            {
                mEntitySysSetting = LoginRemoteRequest.GetSysSettingObject(mToken.getToken(), String.valueOf(mEntityStationSet.get(indexStationName).getStationId()));
            }
        }).start();

        // 设置本地日期格式，从服务器获取时间 http://192.168.2.158:9000/ParkAPI/getServerTime?token=806f13c43e7044c1a268bc6a09e00c81
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                getServerTime = LoginRemoteRequest.getServerTime(mToken.getToken());
            }
        }).start();

        // 数据定义

        // 准备工作
        //判断用户卡号是否相等的，即同一个用户登录
        if (Model.sUserCard.equals(SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext(),
                ConstantSharedPrefs.UserCode, "0")))
        {
            // LoginDate 可以存放毫秒数
            String result = (String) SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                    , ConstantSharedPrefs.LoginDate, "");
            if (!result.equals(""))
                Model.dLoginTime = Long.parseLong(result);
        }
        else
        {
            SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext(),
                    ConstantSharedPrefs.UserCode, Model.sUserCard);
            long l = System.currentTimeMillis();
            SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext(),
                    ConstantSharedPrefs.LoginDate, "0");
            Model.dLoginTime = l;
        }
        // 设置本地日期格式

        // 获取操作员信息
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                List<EntityOperatorDetail> entityOperatorDetail =
                        LoginRemoteRequest.GetOperators(mToken.getToken(), mEntityOperator.get(indexUserName).getUserNO());

                if (entityOperatorDetail != null && entityOperatorDetail.size() > 0)
                {
                    Model.sUserName = entityOperatorDetail.get(0).getUserName();
                    Model.sUserCard = entityOperatorDetail.get(0).getCardNO();
                    Model.sGroupNo = entityOperatorDetail.get(0).getUserLevel();

                    Model.lstRights = LoginRemoteRequest.GetRightsByGroupID(mToken.getToken(), String.valueOf(Model.sGroupNo));
                    sendMessageByHandler(Model.lstRights, MSG_GetRight, MSG_GetRightFailed);
                }
            }
        }).start();

        // 加载权限调到在线监控界面

    }


    private void showDialog(String str)
    {
        new AlertDialog.Builder(this).setTitle("提示信息")
                .setMessage(str).setPositiveButton("确认", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent = new Intent(LoginActivity.this, FormServerSetActivity.class);
                startActivity(intent);//开始设置
            }
        }).show();
    }

    private void showWorkStationSwitchDialog(String str, final int index)
    {
        new AlertDialog.Builder(this).setTitle("提示信息")
                .setMessage(str).setPositiveButton("确认", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)// 对比StationId是否相等
            {
                int Id = mEntityStationSet.get(index).getStationId();// 直接通过下标找到stationId
                //保存站点即可
                SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                        , ConstantSharedPrefs.StationID, String.valueOf(Id));
                curStationID = String.valueOf(Id);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                String stationName = tv_Stationvalue.getText().toString();
                int selectIndex = 0;
                for (int i = 0; i < mEntityStationSet.size(); i++)
                {
                    if (mEntityStationSet.get(i).getStationName().equals(stationName))
                    {
                        selectIndex = i;
                        break;
                    }
                }
                tv_Stationvalue.setText(mEntityStationSet.get(selectIndex).getStationName());
                Model.stationID = mEntityStationSet.get(selectIndex).getStationId();
                Model.iParkingNo = mEntityStationSet.get(selectIndex).getCarparkNO();
            }
        }).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onItemClick(int pos)
    {
        setUserValue(pos);
        indexUserName = pos;
    }

    private void setUserValue(int pos)
    {
        if (pos >= 0 && pos <= nameList.size())
        {
            String s = nameList.get(pos);
            tv_Uservalue.setText(s);
        }
    }

    private void setStationValue(int pos)
    {
        if (pos >= 0 && pos <= stationList.size())
        {
            String s = stationList.get(pos);
            tv_Stationvalue.setText(s);
        }
    }


    class CustemSpinerAdapter extends AbstractSpinerAdapter<String>
    {
        public CustemSpinerAdapter(Context context)
        {
            super(context);
        }
    }
}