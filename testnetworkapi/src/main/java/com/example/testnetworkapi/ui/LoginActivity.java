package com.example.testnetworkapi.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.testnetworkapi.EntityAliveReponse;
import com.example.testnetworkapi.Model;
import com.example.testnetworkapi.R;
import com.example.testnetworkapi.Request;

import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Administrator on 2017-02-24.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener
{
    private static final String TAG = "LoginActivity";
    private Button button2;
    public List<EntityOperator> getOperatorsWithoutLogin = null;
    public List<EntityStationSet> getStationSetWithoutLogin = null;

    public EntityToken loginUser = null;
    public EntitySysSetting getSysSettingObject = null;

    public List<EntityOperatorDetail> entityOperatorDetail = null;
    public List<EntityRights> rights = null;
    public List<EntityRoadWaySet> getCheDaoSet = null;
    private int indexUserNo = 0; // 表示获取到的下标
    private int indexStationID = 1;

    public List<EntityCarTypeInfo> entityCarTypeInfoList = null;
    public List<EntityRoadWaySet> readRoadWaysetList = null;

    public EntityDeviceParam deviceParamA = null;

    public List<EntityCarTypeInfo> chargeCarTypeList = null;

    public List<EntityChargeRules> getChargeRules = null;
    public List<EntityCarOut> entityCarOutList = null;
    public List<EntityCarIn> entityCarInList = null;

    public EntityParkingInfo entityParkingInfo = null;
    public List<EntityNetCameraSet> entityNetCameraSet = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView()
    {
        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button2:

                new Thread(new Runnable()
                {
                    @TargetApi(Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run()
                    {
                        loginUI_URLRequest();
                        readCardRecordUI_URLRequest();
                        parkingMonitoringUI_URLRequest();

                    }
                }).start();
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void parkingMonitoringUI_URLRequest()
    {
        /**
         * 1, http://192.168.2.158:9000/ParkAPI/GetCardTypeDef?token=f7dc3eb130184505b82aa72fcd169296&jsonSearchParam=
         */
        ArrayMap<String, String> tmpContainer = new ArrayMap<String, String>();
        ArrayMap<String, String> dic0 = new ArrayMap<String, String>();

        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("jsonSearchParam", "");
        String result = mapConvertString(tmpContainer);

        entityCarTypeInfoList = RequestByURL.getDataListWithoutTokenField("GetCardTypeDef", EntityCarTypeInfo.class, null, result);
        displayListInfo(entityCarTypeInfoList, "1, GetCardTypeDef", 2);

        /**
         * 2, http://192.168.2.158:9000/ParkAPI/GetCheDaoSet?token=296718d72111434c94ddbe068e7f343b&
         * jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22StationID%22%2c%22
         * Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a2%2c%22Combinator%22%3a%22and%22%7d%5d%2c%
         * 22Combinator%22%3a%22and%22%7d%5d&OrderField=OnLine%20desc,CtrlNumber%20asc,InOut%20asc
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());

        dic0.put("StationID", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getStationId()));
        tmpContainer.put("jsonSearchParam", RequestByURL.toJsonSearchParam(dic0, false, false));

        dic0.clear();
        dic0.put("OnLine", "desc");
        dic0.put("CtrlNumber", "asc");
        dic0.put("InOut", "asc");
        String where = RequestByURL.getWhere(dic0);
        tmpContainer.put("OrderField", where);

        String param = mapConvertString(tmpContainer);

        readRoadWaysetList = RequestByURL.getDataListWithoutTokenField("GetCheDaoSet", EntityRoadWaySet.class, null, param);
        displayListInfo(readRoadWaysetList, "2, GetCheDaoSet", 2);

        /**
         * 3, http://192.168.2.158:9000/ParkAPI/GetDeviceParameter?token=55b10f562a27406d921fccab85001ec9&StationId=2&CtrlNumber=3&IP=192.168.2.182
         * 获取控制板的信息
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("StationId", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getStationId()));
        tmpContainer.put("CtrlNumber", readRoadWaysetList.get(0).getCtrlNumber() + "");
        tmpContainer.put("IP", readRoadWaysetList.get(0).getIP());

        String deviceParam = mapConvertString(tmpContainer);
        deviceParamA = RequestByURL.getDataWithoutTokenField("GetDeviceParameter", EntityDeviceParam.class, null, deviceParam);
        displaySimpleInfo(deviceParamA, "3, GetDeviceParameter", 2);

        /**
         * 4,http://192.168.2.158:9000/ParkAPI/GetCardTypeDef?token=55b10f562a27406d921fccab85001ec9&jsonSearchParam=
         * %5b%0d%0a++%7b%0d%0a++++%22Conditions%22%3a+%5b%0d%0a++++++%7b%0d%0a++++++++%22FieldName
         * %22%3a+%22Identifying%22%2c%0d%0a++++++++%22Operator%22%3a+%22like%22%2c%0d%0a++++++++%22
         * FieldValue%22%3a+%22Tmp%25%22%2c%0d%0a++++++++%22Combinator%22%3a+%22or%22%0d%0a++++++%7d%2c%0d%0a++++++%
         * 7b%0d%0a++++++++%22FieldName%22%3a+%22Identifying%22%2c%0d%0a++++++++%22Operator%22%3a+%22like%22%2c%0d%0a
         * ++++++++%22FieldValue%22%3a+%22Str%25%22%2c%0d%0a++++++++%22Combinator%22%3a+%22or%22%0d%0a++++++%7d%0d%0a++++
         * %5d%2c%0d%0a++++%22Combinator%22%3a+%22and%22%0d%0a++%7d%2c%0d%0a++%7b%0d%0a++++%22Conditions%22%3a+%5b%0d%0a
         * ++++++%7b%0d%0a++++++++%22FieldName%22%3a+%22Enabled%22%2c%0d%0a++++++++%22Operator%22%3a+%22%3d%22%2c%0d%0a++++++++
         * %22FieldValue%22%3a+%221%22%2c%0d%0a++++++++%22Combinator%22%3a+%22and%22%0d%0a++++++%7d%0d%0a++++%5d%2c%0d%0a++++%22
         * Combinator%22%3a+%22and%22%0d%0a++%7d%0d%0a%5d
         * 获取收费标准
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        String chargeCarTypeToJsonSearchParam = RequestByURL.getChargeCarTypeToJsonSearchParam();
        tmpContainer.put("jsonSearchParam", chargeCarTypeToJsonSearchParam);
        String s = mapConvertString(tmpContainer);

        chargeCarTypeList = RequestByURL.getDataListWithoutTokenField("GetCardTypeDef", EntityCarTypeInfo.class, null, s);
        displayListInfo(chargeCarTypeList, "4, GetCardTypeDef", 2);

        /**
         * 5，http://192.168.2.158:9000/ParkAPI/GetChargeRules?token=55b10f562a27406d921fccab85001ec9&jsonSearchParam
         * =%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22ParkID%22%2c%22Operator%22%3a%22like%22%2c%22
         * FieldValue%22%3a0%2c%22Combinator%22%3a%22and%22%7d%2c%7b%22FieldName%22%3a%22CardType%22%2c%22
         * Operator%22%3a%22like%22%2c%22FieldValue%22%3a%22TmpA%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=CardType asc
         */
        tmpContainer.clear();
        tmpContainer.put("ParkID", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getCarparkNO()));
        tmpContainer.put("CardType", chargeCarTypeList.get(0).getIdentifying());
        String s1 = RequestByURL.toJsonSearchParam(tmpContainer, false, true);

        dic0.clear();
        dic0.put("CardType", "asc");
        String where1 = RequestByURL.getWhere(dic0);

        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("jsonSearchParam", s1);
        tmpContainer.put("OrderField", where1);

        getChargeRules = RequestByURL.getDataListWithoutTokenField("GetChargeRules", EntityChargeRules.class, null, mapConvertString(tmpContainer));
        displayListInfo(getChargeRules, "5, GetChargeRules", 2);

        /**
         * 6, http://192.168.2.158:9000/ParkAPI/GetCarOut?token=55b10f562a27406d921fccab85001ec9&
         * jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22CarparkNO%22%2c%22Operator
         * %22%3a%22like%22%2c%22FieldValue%22%3a0%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=InTime desc
         * 查询出厂记录
         */
        tmpContainer.clear();
        tmpContainer.put("CarparkNO", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getCarparkNO()));
        String s2 = RequestByURL.toJsonSearchParam(tmpContainer, false, true);
        dic0.clear();
        dic0.put("InTime", "desc");
        String where2 = RequestByURL.getWhere(dic0);
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("OrderField", where2);
        if (s2 != null)
        {
            tmpContainer.put("jsonSearchParam", s2);
        }

        entityCarOutList = RequestByURL.getDataListWithoutTokenField("GetCarOut", EntityCarOut.class, null, mapConvertString(tmpContainer));
        displayListInfo(entityCarOutList, "6, GetCarOut", 2);

        /**
         * 7,http://192.168.2.158:9000/ParkAPI/GetCarIn?token=55b10f562a27406d921fccab85001ec9&jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22CarparkNO%22%2c%22Operator%22%3a%22like%22%2c%22FieldValue%22%3a0%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=ID%20desc
         */
        tmpContainer.clear();
        tmpContainer.put("CarparkNO", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getCarparkNO()));
        String s3 = RequestByURL.toJsonSearchParam(tmpContainer, false, true);
        dic0.clear();
        dic0.put("ID", "desc");
        String where3 = RequestByURL.getWhere(dic0);
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("OrderField", where3);
        if (s2 != null)
        {
            tmpContainer.put("jsonSearchParam", s3);
        }
        entityCarInList = RequestByURL.getDataListWithoutTokenField("GetCarIn", EntityCarIn.class, null, mapConvertString(tmpContainer));
        displayListInfo(entityCarInList, "7, GetCarIn", 2);

        /**
         * 8, http://192.168.2.158:9000/ParkAPI/GetParkingInfo?token=296718d72111434c94ddbe068e7f343b&StartTime=20170222000000&CarParkNo=0
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("CarParkNo", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getCarparkNO()));
        String yyyyMMdd000000 = TimeConvertUtils.longToString("yyyyMMdd000000", System.currentTimeMillis());
        Log.i(TAG, yyyyMMdd000000);
        tmpContainer.put("StartTime", yyyyMMdd000000); // 获取当前的时间 20170222000000
        entityParkingInfo = RequestByURL.getDataWithoutTokenField("GetParkingInfo", EntityParkingInfo.class, null, mapConvertString(tmpContainer));
        displaySimpleInfo(entityParkingInfo, "8, GetParkingInfo", 2);

        /**
         * 9, http://192.168.2.158:9000/ParkAPI/GetNetCameraSet?token=55b10f562a27406d921fccab85001ec9&jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22VideoIP%22%2c%22Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a%22192.168.6.211%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d
         * //通过camra IP来获取相机信息
         */

        tmpContainer.clear();
        tmpContainer.put("VideoIP", readRoadWaysetList.get(0).getCameraIP());
        String s4 = RequestByURL.toJsonSearchParam(tmpContainer, false, false);
        tmpContainer.clear();

        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("jsonSearchParam", s4);
        entityNetCameraSet = RequestByURL.getDataListWithoutTokenField("GetNetCameraSet", EntityNetCameraSet.class, null, mapConvertString(tmpContainer));
        displayListInfo(entityNetCameraSet, "9, GetNetCameraSet", 2);

        /**
         * 10, http://192.168.2.158:9000/ParkAPI/AddOptLog?token=74da59f541244f17876b89550ed583f7&jsonModel=%7b%0d%0a++%22ID%22%3a+0%2c%0d%0a++%22StationID%22%3a+2%2c%0d%0a++%22OptNO%22%3a+%22888888%22%2c%0d%0a++%22UserName%22%3a+%22%e7%ae%a1%e7%90%86%e5%91%98%22%2c%0d%0a++%22OptMenu%22%3a+%22%e5%88%86%e5%b8%83%e5%bc%8f%e5%81%9c%e8%bd%a6%e5%9c%ba%e7%ae%a1%e7%90%86%e7%b3%bb%e7%bb%9f%22%2c%0d%0a++%22OptContent%22%3a+%22%e7%99%bb%e9%99%86%22%2c%0d%0a++%22OptTime%22%3a+%222017-02-23+14%3a46%3a23%22%2c%0d%0a++%22PCName%22%3a+null%2c%0d%0a++%22CarparkNO%22%3a+0%0d%0a%7d
         * //向服务器发送log日记信息
         */
        addLog("分布式停车场管理系统", "登陆"); // yyyy-MM-dd HH:mm:ss

        /**
         * 11, 心跳包 http://192.168.2.158:9000/ParkAPI/KeepAlive?token=5ab812323bff48359d3226fa2717e381
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        int aliveReponse = RequestByURL.getDataWithoutTokenField("KeepAlive", Integer.class, null, mapConvertString(tmpContainer));
        displaySimpleInfo(aliveReponse, "10, KeepAlive", 2);

        /**
         * http://192.168.2.158:9000/ParkAPI/GetCarInByCarPlateNumberLike 查询当前车牌的数据信息
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("CarPlateNumber", "粤A54321");
        RequestByURL.getDataListWithoutTokenField("GetCarInByCarPlateNumberLike", Object.class, null, mapConvertString(tmpContainer));

        /**
         * http://192.168.2.158:9000/ParkAPI/SetCarIn?token=5338443d63c14b15affc278ae40cd57d&CPH=粤A12345&CtrlNumber=3&StationId=1
         */
        tmpContainer.clear();
        tmpContainer.put("token", loginUser.getToken());
        tmpContainer.put("CPH", "粤A54321");
        tmpContainer.put("CtrlNumber", "9");
        tmpContainer.put("StationId", "1");
        RequestByURL.getDataListWithoutTokenField("SetCarIn", Object.class, null, mapConvertString(tmpContainer));
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void readCardRecordUI_URLRequest()
    {
        /**
         * http://192.168.2.158:9000/ParkAPI/GetCheDaoSet?token=2b56d183e03846c98fb6e64a3748912f&jsonSearchParam=%5b%7b%22
         * Conditions%22%3a%5b%7b%22FieldName%22%3a%22StationID%22%2c%22Operator%22%3a%22%3d%22%2c%22
         * FieldValue%22%3a2%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=InOut%20asc
         */

        ArrayMap<String, String> tmpContainer = new ArrayMap<String, String>();
        tmpContainer.put("StationID", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getStationId()));
        String toJsonString = RequestByURL.toJsonSearchParam(tmpContainer, false, false);

        // 构建where语句
        ArrayMap<String, String> dic = new ArrayMap<String, String>();
        dic.put("InOut", "asc");
        String where = RequestByURL.getWhere(dic);

        ArrayMap<String, String> mapContainer = new ArrayMap<String, String>();
        mapContainer.put("token", loginUser.getToken());
        mapContainer.put("jsonSearchParam", toJsonString);
        mapContainer.put("OrderField", where);

        getCheDaoSet = RequestByURL.getDataListWithoutTokenField("GetCheDaoSet", EntityRoadWaySet.class, null, mapConvertString(mapContainer));
        displayListInfo(getCheDaoSet, "1, GetCheDaoSet", 1);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void loginUI_URLRequest()
    {
        /**
         * 1, GetOperatorsWithoutLogin 请求数据 http://192.168.2.158:9000/ParkAPI/GetOperatorsWithoutLogin
         * 数据是一个列表，且数据返回的数据也是列表
         */
        getOperatorsWithoutLogin = RequestByURL.getDataList("GetOperatorsWithoutLogin", EntityOperator.class, null, null);
        displayListInfo(getOperatorsWithoutLogin, "1, GetOperatorsWithoutLogin", 0);

        /**
         * 2, GetStationSetWithoutLogin 请求数据 http://192.168.2.158:9000/ParkAPI/GetStationSetWithoutLogin?token=&OrderField=StationId
         * 数据也是一个列表
         */
        getStationSetWithoutLogin = RequestByURL.getDataList("GetStationSetWithoutLogin", EntityStationSet.class, "StationId", null);
        displayListInfo(getStationSetWithoutLogin, "2, GetStationSetWithoutLogin", 0);

        /**
         * 3, 192.168.2.158:9000/ParkAPI/LoginUser?UserNo=888888&password=d41d8cd98f00b204e9800998ecf8427e
         * 数据即为一个 token
         */
        String md5Password = null;
        try
        {
            md5Password = MD5Utils.MD5("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ArrayMap<String, String> stringStringArrayMap = new ArrayMap<String, String>();
        stringStringArrayMap.put("UserNo", getOperatorsWithoutLogin.get(indexUserNo).getUserNO());
        stringStringArrayMap.put("password", md5Password);
        String param = mapConvertString(stringStringArrayMap);
//                        Log.i(TAG, param + ">>>>>>>>");
        loginUser = RequestByURL.getData("LoginUser", EntityToken.class, null, param);
        displaySimpleInfo(loginUser, "3, LoginUser", 0);

        /**
         * 4,http://192.168.2.158:9000/ParkAPI/GetSysSettingObject?token=af7ba4e7a0164b1582468612a18d9d57&StationID=2
         */
        ArrayMap<String, String> getSysMap = new ArrayMap<>();
        getSysMap.put("token", loginUser.getToken());
        getSysMap.put("StationID", String.valueOf(getStationSetWithoutLogin.get(indexStationID).getStationId()));
        String paramSysSetting = mapConvertString(getSysMap);
//                        Log.i(TAG, paramSysSetting + ">>>>>>>>");
        getSysSettingObject = RequestByURL.getDataWithoutTokenField("GetSysSettingObject", EntitySysSetting.class, null, paramSysSetting);
        displaySimpleInfo(getSysSettingObject, "4, GetSysSettingObject", 0);

        /**
         * 5,http://192.168.2.158:9000/ParkAPI/getServerTime?token=806f13c43e7044c1a268bc6a09e00c81
         */
        ArrayMap<String, String> systemTime = new ArrayMap<>();
        systemTime.put("token", loginUser.getToken());
        String paramSysTime = mapConvertString(systemTime);
        EntitySystemTime getServerTime = RequestByURL.getDataWithoutTokenField("getServerTime", EntitySystemTime.class, null, paramSysTime);
        displaySimpleInfo(getServerTime, "5, getServerTime", 0);

        /**
         * 6，需要传输的String Gson字符串
         * http://192.168.2.158:9000/ParkAPI/GetOperators?token=3b773b3f20f24260bf4d379ff09c3839&jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22
         * FieldName%22%3a%22UserNO%22%2c%22Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a%22888888%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d
         * [
         {"Conditions":
         [
         {
         "FieldName":"UserNO",
         "Operator":"=",
         "FieldValue":"888888",
         "Combinator":"and"
         }
         ],
         "Combinator":"and"
         }
         ]
         */
        // 将结构体变成String的Gson字符串
        ArrayMap<String, String> inOperatorMap = new ArrayMap<>();
        inOperatorMap.put("UserNO", getOperatorsWithoutLogin.get(indexUserNo).getUserNO());
        String s = RequestByURL.toJsonSearchParam(inOperatorMap, false, false);
//                        String s = RequestByURL.objectToGson(entityGsonOperators);// 这里可以转换，可以考虑泛型来作思考；
//                        String s = "[{\\\"Conditions\\\":[{\\\"FieldName\\\":\\\"UserNO\\\",\\\"Operator\\\":\n" +
//                                "\\\"=\\\",\\\"FieldValue\\\":\\\"888888\\\",\\\"Combinator\\\":\\\"and\\\"}],\\\"Combinator\\\":\\\"and\\\"}]";
        Log.i(TAG, "objectToGson:" + s);
        ArrayMap<String, String> operatorMap = new ArrayMap<>();
        operatorMap.put("token", loginUser.getToken());
        operatorMap.put("jsonSearchParam", s);
        String paramOpeator = mapConvertString(operatorMap);
        Log.i(TAG, "paramOpeator:" + paramOpeator);
        entityOperatorDetail = RequestByURL.getDataListWithoutTokenField("GetOperators", EntityOperatorDetail.class, null, paramOpeator);
        displayListInfo(entityOperatorDetail, "6, GetOperators", 0);

        /**
         * 7, GetRightsByGroupID
         * http://192.168.2.158:9000/ParkAPI/GetRightsByGroupID?token=ca30622e4a2d421483e5e5da95ba6fd1&GroupID=1
         */

        ArrayMap<String, String> rightsMap = new ArrayMap<>();
        rightsMap.put("GroupID", String.valueOf(entityOperatorDetail.get(0).getUserLevel()));
        rightsMap.put("token", loginUser.getToken());
        rights = RequestByURL.getDataListWithoutTokenField("GetRightsByGroupID", EntityRights.class, null, mapConvertString(rightsMap));
        displayListInfo(rights, "7, GetRightsByGroupID", 0);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private String mapConvertString(ArrayMap<String, String> stringStringArrayMap)
    {
        StringBuffer stringBuffer = new StringBuffer();
        if (stringStringArrayMap == null || stringStringArrayMap.size() <= 0)
        {
            return null;
        }

        Set<String> strings = stringStringArrayMap.keySet();

        int i = 0;
        for (String str : strings)
        {
            stringBuffer.append(str).append("=").append(stringStringArrayMap.get(str));
            if (i != strings.size() - 1)
            {
                stringBuffer.append("&");
            }
            i++;
        }

        return stringBuffer.toString();

    }

    private <T> void displayListInfo(List<T> inList, String text, int type)
    {
        if (inList == null)
        {
            return;
        }

        String prefix = "";
        if (type == 0)
        {
            prefix = "### (1)loginUI_URLRequest ####";
        }
        else if (type == 1)
        {
            prefix = "### (2)readCardRecordUI_URLRequest ####";
        }
        else if (type == 2)
        {
            prefix = "### (3)parkingMonitoringUI_URLRequest ####";
        }

        Log.i(TAG, prefix + text + ">>>>>>>>");
        for (T o : inList)
        {
            Log.i(TAG, o.toString());
        }
    }

    private <T> void displaySimpleInfo(T t, String text, int type)
    {
        if (t == null)
        {
            return;
        }
        String prefix = "";
        if (type == 0)
        {
            prefix = "loginUI_URLRequest ####";
        }
        else if (type == 1)
        {
            prefix = "readCardRecordUI_URLRequest ####";
        }
        else if (type == 2)
        {
            prefix = "parkingMonitoringUI_URLRequest ####";
        }

        Log.i(TAG, prefix + text + ">>>>>>>>");
        Log.i(TAG, t.toString());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void addLog(String OptMenu, String OptContent)
    {
        EntityAddLog opt = new EntityAddLog();
        opt.setOptNO(getOperatorsWithoutLogin.get(indexUserNo).getUserNO());
        opt.setUserName(getOperatorsWithoutLogin.get(indexUserNo).getUserName());
        opt.setOptMenu(OptMenu);
        opt.setOptContent(OptContent);
        opt.setOptTime(TimeConvertUtils.longToString(System.currentTimeMillis()));
        opt.setStationID(getStationSetWithoutLogin.get(indexStationID).getStationId());
//
        String s = RequestByURL.objectToGson(opt);
        String encode = URLEncoder.encode(s);

        ArrayMap<String, String> map = new ArrayMap<String, String>();
        map.put("token", loginUser.getToken());
        map.put("jsonModel", encode);
        int logReponse = RequestByURL.getDataWithoutTokenField("AddOptLog", Integer.class, null, mapConvertString(map));
//        RequestByURL.getDataWithoutTokenField()
        displaySimpleInfo(logReponse, "AddOptLog", 2);
    }
}
