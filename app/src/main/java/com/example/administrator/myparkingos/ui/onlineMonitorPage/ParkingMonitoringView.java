package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.util.L;
import com.vz.PlateResult;
import com.vz.monitor.player.MediaPlayer;
import com.vz.tcpsdk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-08.
 */
public class ParkingMonitoringView implements tcpsdk.OnDataReceiver
{
    private ParkingMonitoringActivity monitoringActivity;
    private int mLayoutResourceId;
    private TextView tvChannel0;
    private MediaPlayer svVideo0;
    private Button btnCmdOPen0;
    private Button btnCmdClose0;
    private Button btnManual0;
    private TextView tvChannel2;
    private MediaPlayer svVideo2;
    private Button btnCmdOPen2;
    private Button btnCmdClose2;
    private Button btnManual2;
    private TextView tvChannel1;
    private MediaPlayer svVideo1;
    private Button btnCmdOPen1;
    private Button btnCmdClose1;
    private Button btnManual1;
    private TextView tvChannel3;
    private MediaPlayer svVideo3;
    private Button btnCmdOPen3;
    private Button btnCmdClose3;
    private Button btnManual3;
    private TextView btnChargeInfo;
    private TextView btnParkingSpace;
    private FrameLayout flchargeSpaceContainer;
    private LinearLayout llChargeInfo;
    private TextView tvCarInParkingDetail;
    private TextView tvCarChargeDetail;
    private FrameLayout flDetailList;
    private Button btnCarIn;
    private Button btnCarOut;
    private Button btnNoPlateCarIn;
    private Button btnNoPlateCarOut;
    private Button btnCarRegister;
    private Button btnBlackCarList;
    private Button btnDeadlineQuery;
    private Button btnShiftLogin;
    private TextView tvLoginName;
    private TextView etLoginNo;
    private TextView etWorkTime;
    private TextView etSysTime;
    private TextView etOperHint;

    private int[] handleList = new int[4];
    private tcpsdk.OnDataReceiver m_plateReciver;
    private int m_bEnableImg;
    private Button btnRefresh;
    private Button btnGroundVehicle;
    private Button btnChargeRecord;
    private TextView tvNoVideoText0;
    private TextView tvNoVideoText1;
    private TextView tvNoVideoText2;
    private TextView tvNoVideoText3;

    public ParkingMonitoringView()
    {

    }

    public ParkingMonitoringView(ParkingMonitoringActivity activity, int layoutId)
    {
        monitoringActivity = activity;
        mLayoutResourceId = layoutId;
        monitoringActivity.setContentView(layoutId);
        initView();
    }

    /**
     * 通道List
     */
    private List<TextView> channelList = new ArrayList<TextView>();

    /**
     * 没有视频显示时，打印"NoVideo"提示信息
     */
    private List<TextView> noVideoList = new ArrayList<TextView>();

    /**
     * 视频播放list
     */
    private List<MediaPlayer> videoList = new ArrayList<MediaPlayer>();
    /**
     * 开闸按钮list
     */
    private List<Button> openList = new ArrayList<Button>();
    /**
     * 关闸按钮list
     */
    private List<Button> closeList = new ArrayList<Button>();
    /**
     * 手动开闸列表
     */
    private List<Button> manualList = new ArrayList<Button>();

    public void initView()
    {
        tvChannel0 = (TextView) monitoringActivity.findViewById(R.id.tvChannel0);
        svVideo0 = (MediaPlayer) monitoringActivity.findViewById(R.id.svVideo0);
        btnCmdOPen0 = (Button) monitoringActivity.findViewById(R.id.btnCmdOPen0);
        btnCmdClose0 = (Button) monitoringActivity.findViewById(R.id.btnCmdClose0);
        btnManual0 = (Button) monitoringActivity.findViewById(R.id.btnManual0);
        tvChannel2 = (TextView) monitoringActivity.findViewById(R.id.tvChannel2);
        svVideo2 = (MediaPlayer) monitoringActivity.findViewById(R.id.svVideo2);
        btnCmdOPen2 = (Button) monitoringActivity.findViewById(R.id.btnCmdOPen2);
        btnCmdClose2 = (Button) monitoringActivity.findViewById(R.id.btnCmdClose2);
        btnManual2 = (Button) monitoringActivity.findViewById(R.id.btnManual2);
        tvChannel1 = (TextView) monitoringActivity.findViewById(R.id.tvChannel1);
        svVideo1 = (MediaPlayer) monitoringActivity.findViewById(R.id.svVideo1);
        btnCmdOPen1 = (Button) monitoringActivity.findViewById(R.id.btnCmdOPen1);
        btnCmdClose1 = (Button) monitoringActivity.findViewById(R.id.btnCmdClose1);
        btnManual1 = (Button) monitoringActivity.findViewById(R.id.btnManual1);
        tvChannel3 = (TextView) monitoringActivity.findViewById(R.id.tvChannel3);
        svVideo3 = (MediaPlayer) monitoringActivity.findViewById(R.id.svVideo3);
        btnCmdOPen3 = (Button) monitoringActivity.findViewById(R.id.btnCmdOPen3);
        btnCmdClose3 = (Button) monitoringActivity.findViewById(R.id.btnCmdClose3);
        btnManual3 = (Button) monitoringActivity.findViewById(R.id.btnManual3);
        btnChargeInfo = (TextView) monitoringActivity.findViewById(R.id.btnChargeInfo);

        tvNoVideoText0 = (TextView) monitoringActivity.findViewById(R.id.tvNoVideoHint0);
        tvNoVideoText1 = (TextView) monitoringActivity.findViewById(R.id.tvNoVideoHint1);
        tvNoVideoText2 = (TextView) monitoringActivity.findViewById(R.id.tvNoVideoHint2);
        tvNoVideoText3 = (TextView) monitoringActivity.findViewById(R.id.tvNoVideoHint3);

        btnChargeInfo.setOnClickListener(myClickListener);

        btnGroundVehicle = (Button) monitoringActivity.findViewById(R.id.btnGroundVehicle);
        btnGroundVehicle.setOnClickListener(myClickListener);

        btnChargeRecord = (Button) monitoringActivity.findViewById(R.id.btnChargeRecord);
        btnChargeRecord.setOnClickListener(myClickListener);

        btnParkingSpace = (TextView) monitoringActivity.findViewById(R.id.btnParkingSpace);
        btnParkingSpace.setOnClickListener(myClickListener);

        flchargeSpaceContainer = (FrameLayout) monitoringActivity.findViewById(R.id.flchargeSpaceContainer);
        llChargeInfo = (LinearLayout) monitoringActivity.findViewById(R.id.llChargeInfo);

        tvCarInParkingDetail = (TextView) monitoringActivity.findViewById(R.id.tvCarInParkingDetail);
        tvCarInParkingDetail.setOnClickListener(myClickListener);
        tvCarChargeDetail = (TextView) monitoringActivity.findViewById(R.id.tvCarChargeDetail);
        tvCarChargeDetail.setOnClickListener(myClickListener);

        flDetailList = (FrameLayout) monitoringActivity.findViewById(R.id.flDetailList);
        btnCarIn = (Button) monitoringActivity.findViewById(R.id.btnCarIn);
        btnCarOut = (Button) monitoringActivity.findViewById(R.id.btnCarOut);
        btnRefresh = (Button) monitoringActivity.findViewById(R.id.btnRefresh);

        btnNoPlateCarIn = (Button) monitoringActivity.findViewById(R.id.btnNoPlateCarIn);
        btnNoPlateCarOut = (Button) monitoringActivity.findViewById(R.id.btnNoPlateCarOut);
        btnCarRegister = (Button) monitoringActivity.findViewById(R.id.btnCarRegister);
        btnBlackCarList = (Button) monitoringActivity.findViewById(R.id.btnBlackCarList);
        btnDeadlineQuery = (Button) monitoringActivity.findViewById(R.id.btnDeadlineQuery);
        btnShiftLogin = (Button) monitoringActivity.findViewById(R.id.btnShiftLogin);
        tvLoginName = (TextView) monitoringActivity.findViewById(R.id.tvLoginName);
        etLoginNo = (TextView) monitoringActivity.findViewById(R.id.etLoginNo);
        etWorkTime = (TextView) monitoringActivity.findViewById(R.id.etWorkTime);
        etSysTime = (TextView) monitoringActivity.findViewById(R.id.etSysTime);
        etOperHint = (TextView) monitoringActivity.findViewById(R.id.etOperHint);

        btnCmdOPen0.setOnClickListener(myClickListener);
        btnCmdClose0.setOnClickListener(myClickListener);
        btnManual0.setOnClickListener(myClickListener);
        btnCmdOPen2.setOnClickListener(myClickListener);
        btnCmdClose2.setOnClickListener(myClickListener);
        btnManual2.setOnClickListener(myClickListener);
        btnCmdOPen1.setOnClickListener(myClickListener);
        btnCmdClose1.setOnClickListener(myClickListener);
        btnManual1.setOnClickListener(myClickListener);
        btnCmdOPen3.setOnClickListener(myClickListener);
        btnCmdClose3.setOnClickListener(myClickListener);
        btnManual3.setOnClickListener(myClickListener);
        btnCarIn.setOnClickListener(myClickListener);
        btnCarOut.setOnClickListener(myClickListener);
        btnNoPlateCarIn.setOnClickListener(myClickListener);
        btnNoPlateCarOut.setOnClickListener(myClickListener);
        btnCarRegister.setOnClickListener(myClickListener);
        btnBlackCarList.setOnClickListener(myClickListener);
        btnDeadlineQuery.setOnClickListener(myClickListener);
        btnShiftLogin.setOnClickListener(myClickListener);
        btnRefresh.setOnClickListener(myClickListener);

        channelList.add(tvChannel0);
        channelList.add(tvChannel1);
        channelList.add(tvChannel2);
        channelList.add(tvChannel3);

        videoList.add(svVideo0);
        videoList.add(svVideo1);
        videoList.add(svVideo2);
        videoList.add(svVideo3);

        openList.add(btnCmdOPen0);
        openList.add(btnCmdOPen1);
        openList.add(btnCmdOPen2);
        openList.add(btnCmdOPen3);

        closeList.add(btnCmdClose0);
        closeList.add(btnCmdClose1);
        closeList.add(btnCmdClose2);
        closeList.add(btnCmdClose3);

        manualList.add(btnManual0);
        manualList.add(btnManual1);
        manualList.add(btnManual2);
        manualList.add(btnManual3);

        noVideoList.add(tvNoVideoText0);
        noVideoList.add(tvNoVideoText1);
        noVideoList.add(tvNoVideoText2);
        noVideoList.add(tvNoVideoText3);
    }

    private View.OnClickListener myClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            checkView(v);
        }
    };

    public void checkView(View v)
    {
        L.i("public void checkView(View v) ###################3");
        switch (v.getId())
        {
            case R.id.btnCmdOPen0:

                break;
            case R.id.btnCmdClose0:

                break;
            case R.id.btnManual0:

                break;
            case R.id.btnCmdOPen2:

                break;
            case R.id.btnCmdClose2:

                break;
            case R.id.btnManual2:

                break;
            case R.id.btnCmdOPen1:

                break;
            case R.id.btnCmdClose1:

                break;
            case R.id.btnManual1:

                break;
            case R.id.btnCmdOPen3:

                break;
            case R.id.btnCmdClose3:

                break;
            case R.id.btnManual3:

                break;
            case R.id.btnCarIn:
                // 弹出对话框，然后进行相应的输入
                onClickCarInBtn();
                break;
            case R.id.btnCarOut:
                onClickCarOutBtn();
                break;
            case R.id.btnNoPlateCarIn:
                onClickNoPlateCarInBtn();
                break;
            case R.id.btnNoPlateCarOut:
                onClickNoPlateCarOutBtn();
                break;
            case R.id.btnCarRegister:
                onClickCarRegisterBtn();
                break;
            case R.id.btnBlackCarList:
                onClickBlackListBtn();
                break;
            case R.id.btnDeadlineQuery:
                onClickDealLineQueryBtn();
                break;
            case R.id.btnChargeRecord:
                onClickChargeRecordBtn();
                break;
            case R.id.btnGroundVehicle:
                onClickGroundVehicleBtn();
                break;
            case R.id.btnShiftLogin:
                onClickShiftLoginBtn();
                break;
            case R.id.btnChargeInfo: //
                onClickInCarChargeInfo();
                chargeInfoToFragmentChange();
                break;
            case R.id.btnParkingSpace:
                onClickInParkingSpace();
                carSpaceInfoToFragmentChange();
                break;
            case R.id.tvCarInParkingDetail:
            {
                onClickInCarInParkingDetail();
                carInParkingDetailToFragmentChange();
                break;
            }
            case R.id.tvCarChargeDetail:
            {
                onClickInCarChargeDetail();
                chargeDetailToFragmentChange();
                break;
            }
            case R.id.btnRefresh:
            {
                onClickRefreshDetail();
            }
            default:
            {
                break;
            }
        }
    }

    public void onClickGroundVehicleBtn()
    {

    }

    public void onClickChargeRecordBtn()
    {

    }

    public void onClickShiftLoginBtn()
    {
    }

    public void onClickDealLineQueryBtn()
    {

    }

    public void onClickBlackListBtn()
    {

    }

    public void onClickRefreshDetail()
    {

    }

    public void onClickCarRegisterBtn()
    {
    }

    public void onClickNoPlateCarOutBtn()
    {

    }

    public void onClickNoPlateCarInBtn()
    {

    }

    public void onClickCarOutBtn()
    {

    }

    public void onClickCarInBtn()
    {

    }

    /**
     * 点击车辆收费信息
     */
    public void onClickInCarChargeInfo()
    {
        btnParkingSpace.setBackgroundResource(R.color.colorClick);
        btnChargeInfo.setBackgroundResource(R.color.colorNoClick);
    }

    /**
     * 点击车位信息
     */
    public void onClickInParkingSpace()
    {
        btnChargeInfo.setBackgroundResource(R.color.colorClick);
        btnParkingSpace.setBackgroundResource(R.color.colorNoClick);
    }

    /**
     * 点击在场车辆信息
     */
    public void onClickInCarInParkingDetail()
    {
        tvCarChargeDetail.setBackgroundResource(R.color.colorClick);
        tvCarInParkingDetail.setBackgroundResource(R.color.colorNoClick);
    }

    /**
     * 点击车场收费
     */
    public void onClickInCarChargeDetail()
    {
        tvCarInParkingDetail.setBackgroundResource(R.color.colorClick);
        tvCarChargeDetail.setBackgroundResource(R.color.colorNoClick);
    }

    public void chargeInfoToFragmentChange()
    {

    }

    public void carSpaceInfoToFragmentChange()
    {

    }

    public void carInParkingDetailToFragmentChange()
    {

    }

    public void chargeDetailToFragmentChange()
    {

    }

    /**
     * 播放视频
     */
    private void startPlayVideo(MediaPlayer mediaPlayer, String cameraIp, Handler inHandler)
    {
        mediaPlayer.setUrlip(cameraIp);
        mediaPlayer.setHandler(inHandler);
        mediaPlayer.startPlay();
    }

    private void stopPlayVideo(MediaPlayer mediaPlayer)
    {
        mediaPlayer.stopPlay();
    }

    /**
     * 显示状态栏数据
     */
    public void showStatusBar(String userName, String loginNo, String workTime, String sysTime)
    {
        tvLoginName.setText(userName);
        etLoginNo.setText(loginNo);
        etWorkTime.setText(workTime);
        etSysTime.setText(sysTime);
    }

    public void playVideoByIndex(int index, String ip, Handler handler)
    {
        startPlayVideo(videoList.get(index), ip, handler);
        //        device_info.DeviceName:设备1
//        03-09 10:54:00.475 19437-19437/com.example.vzvision I/OPEN: device_info.ip:192.168.2.248
//        03-09 10:54:00.475 19437-19437/com.example.vzvision I/OPEN: device_info.port:8131
//        03-09 10:54:00.475 19437-19437/com.example.vzvision I/OPEN: device_info.username:admin
//        03-09 10:54:00.475 19437-19437/com.example.vzvision I/OPEN: device_info.userpassword:admin

        // 对于tcpsdk进行初始化
        String userName = "admin";
        String userPassword = "admin";
        handleList[index] = tcpsdk.getInstance().open(ip.getBytes(), ip.length(), 8131, userName.getBytes(),
                userName.length(), userPassword.getBytes(), userPassword.length());

        if (handleList[index] != 0)
        {
            tcpsdk.getInstance().setPlateInfoCallBack(handleList[index], this, 1);
        }
    }

    public void stopVideoByIndex(int index)
    {
        stopPlayVideo(videoList.get(index));
        tcpsdk.getInstance().close(handleList[index]);
    }

    @Override
    public void onDataReceive(int handle, PlateResult plateResult, int uNumPlates, int eResultType, byte[] pImgFull, int nFullSize, byte[] pImgPlateClip, int nClipSize)
    {
        // 这里可以用来接收车牌数据
        try
        {
            String plateText = new String(plateResult.license, "GBK");
            Looper.prepare();
            Toast.makeText(monitoringActivity, "接收车牌:" + plateText, Toast.LENGTH_SHORT).show();
            L.i("onDataReceive ======================================" + Thread.currentThread().getName() + "," + plateText);
            Looper.loop();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            Toast.makeText(monitoringActivity, "不支持的解码异常", Toast.LENGTH_SHORT).show();
        }
    }
}

