package com.example.administrator.myparkingos.model;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;

import com.example.administrator.myparkingos.model.beans.gson.EntityOperator;
import com.example.administrator.myparkingos.model.beans.gson.EntityOperatorDetail;
import com.example.administrator.myparkingos.model.beans.gson.EntityRights;
import com.example.administrator.myparkingos.model.beans.gson.EntityStationSet;
import com.example.administrator.myparkingos.model.beans.gson.EntitySysSetting;
import com.example.administrator.myparkingos.model.beans.gson.EntitySystemTime;
import com.example.administrator.myparkingos.model.beans.gson.EntityToken;

import java.util.List;

/**
 * Created by Administrator on 2017-03-04.
 */
public class LoginRemoteRequest
{
    /**
     * 在登录界面，按照功能来获取数据
     */

    /**
     * 在用户没有登录时，获取系统操作人员信息
     * 例如：请求：http://192.168.2.158:9000/ParkAPI/GetOperatorsWithoutLogin
     *
     * @return
     */
    public static List<EntityOperator> GetOperatorsWithoutLogin()
    {
        List<EntityOperator> list = RequestByURL.getDataList("GetOperatorsWithoutLogin", EntityOperator.class, null, null);
        RequestByURL.displayListInfo(list, "1, GetOperatorsWithoutLogin");
        return list;
    }

    /**
     * 在没有登录情况下，获取工作站信息
     *
     * @param stationIdText 例如：请求：http://192.168.2.158:9000/ParkAPI/GetStationSetWithoutLogin?token=&OrderField=StationId
     * @return
     */
    public static List<EntityStationSet> GetStationSetWithoutLogin(String stationIdText)
    {
        List<EntityStationSet> list = RequestByURL.getDataList("GetStationSetWithoutLogin", EntityStationSet.class, stationIdText, null);
        RequestByURL.displayListInfo(list, "2, GetStationSetWithoutLogin");
        return list;
    }

    /**
     * 请求服务器获取Token值
     *
     * @param userNo
     * @param password 例如：请求：192.168.2.158:9000/ParkAPI/LoginUser?UserNo=888888&password=d41d8cd98f00b204e9800998ecf8427e
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntityToken LoginUser(String userNo, String password)
    {
        String keyUserNo = "UserNo";
        String keyPassword = "password";
        ArrayMap<String, String> tempMap = new ArrayMap<String, String>();
        tempMap.put(keyUserNo, userNo);
        tempMap.put(keyPassword, password);

        EntityToken mToken = RequestByURL.getData("LoginUser", EntityToken.class, null, RequestByURL.mapConvertString(tempMap));
        RequestByURL.displaySimpleInfo(mToken, "3, LoginUser");
        return mToken;
    }

    /**
     * 请求系统设置   http://192.168.2.158:9000/ParkAPI/GetSysSettingObject?token=af7ba4e7a0164b1582468612a18d9d57&StationID=2
     *
     * @param token
     * @param stationId
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntitySysSetting GetSysSettingObject(String token, String stationId)
    {
        String keyToken = "token";
        String keyStationId = "StationID";

        ArrayMap<String, String> getSysMap = new ArrayMap<>();
        getSysMap.put(keyToken, token);
        getSysMap.put(keyStationId, stationId);
        EntitySysSetting mEntitySysSetting = RequestByURL.getDataWithoutTokenField("GetSysSettingObject", EntitySysSetting.class, null, RequestByURL.mapConvertString(getSysMap));
        RequestByURL.displaySimpleInfo(mEntitySysSetting, "4, GetSysSettingObject");
        return mEntitySysSetting;
    }

    /**
     * 请求服务器时间 http://192.168.2.158:9000/ParkAPI/getServerTime?token=806f13c43e7044c1a268bc6a09e00c81
     *
     * @param token
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntitySystemTime getServerTime(String token)
    {
        String keyToken = "token";

        ArrayMap<String, String> systemTime = new ArrayMap<>();
        systemTime.put(keyToken, token);
        EntitySystemTime getServerTime = RequestByURL.getDataWithoutTokenField("getServerTime", EntitySystemTime.class, null, RequestByURL.mapConvertString(systemTime));
        RequestByURL.displaySimpleInfo(getServerTime, "5, getServerTime");
        return getServerTime;
    }

    /**
     * 请求操作员的详细信息  //    http://192.168.2.158:9000/ParkAPI/GetOperators?token=3b773b3f20f24260bf4d379ff09c3839
     * //      &jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22UserNO%22%2c%22Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a%22888888%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d
     *
     * @param token
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityOperatorDetail> GetOperators(String token, String userNo)
    {
        String keyToken = "token";
        String keyJsonSearchParam = "jsonSearchParam";
        String keyUserNo = "UserNO";

        ArrayMap<String, String> inOperatorMap = new ArrayMap<>();
        inOperatorMap.put(keyUserNo, userNo);
        ArrayMap<String, String> operatorMap = new ArrayMap<>();
        operatorMap.put(keyToken, token);
        operatorMap.put(keyJsonSearchParam, RequestByURL.getJsonSearchParam(inOperatorMap, false, false));
        List<EntityOperatorDetail> entityOperatorDetail = RequestByURL.getDataListWithoutTokenField("GetOperators", EntityOperatorDetail.class, null, RequestByURL.mapConvertString(operatorMap));
        RequestByURL.displayListInfo(entityOperatorDetail, "6, GetOperators");
        return entityOperatorDetail;
    }

    /**
     * 请求权限组详细信息    http://192.168.2.158:9000/ParkAPI/GetRightsByGroupID?token=ca30622e4a2d421483e5e5da95ba6fd1&GroupID=1
     *
     * @param token
     * @param GroupID
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityRights> GetRightsByGroupID(String token, String GroupID)
    {
        String keyToken = "token";
        String keyGroupID = "GroupID";

        ArrayMap<String, String> rightsMap = new ArrayMap<>();
        rightsMap.put(keyGroupID, GroupID);
        rightsMap.put(keyToken, token);
        List<EntityRights> entityRightsList = RequestByURL.getDataListWithoutTokenField("GetRightsByGroupID", EntityRights.class, null, RequestByURL.mapConvertString(rightsMap));
        RequestByURL.displayListInfo(entityRightsList, "7, GetRightsByGroupID");
        return entityRightsList;
    }
}
