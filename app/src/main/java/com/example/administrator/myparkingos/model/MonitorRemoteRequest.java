package com.example.administrator.myparkingos.model;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.example.administrator.myparkingos.model.beans.BlackListOpt;
import com.example.administrator.myparkingos.model.beans.SelectModel;
import com.example.administrator.myparkingos.model.beans.gson.EntityAddLog;
import com.example.administrator.myparkingos.model.beans.gson.EntityBlackList;
import com.example.administrator.myparkingos.model.beans.gson.EntityCarIn;
import com.example.administrator.myparkingos.model.beans.gson.EntityCarOut;
import com.example.administrator.myparkingos.model.beans.gson.EntityCarTypeInfo;
import com.example.administrator.myparkingos.model.beans.gson.EntityCardIssue;
import com.example.administrator.myparkingos.model.beans.gson.EntityChargeRules;
import com.example.administrator.myparkingos.model.beans.gson.EntityDeviceParam;
import com.example.administrator.myparkingos.model.beans.gson.EntityMoney;
import com.example.administrator.myparkingos.model.beans.gson.EntityNetCameraSet;
import com.example.administrator.myparkingos.model.beans.gson.EntityNoPlateCarIn;
import com.example.administrator.myparkingos.model.beans.gson.EntityOperatorDetail;
import com.example.administrator.myparkingos.model.beans.gson.EntityParkJHSet;
import com.example.administrator.myparkingos.model.beans.gson.EntityParkingInfo;
import com.example.administrator.myparkingos.model.beans.gson.EntityPersonnelInfo;
import com.example.administrator.myparkingos.model.beans.gson.EntityRoadWaySet;
import com.example.administrator.myparkingos.model.beans.gson.EntitySetCarIn;
import com.example.administrator.myparkingos.model.beans.gson.EntitySetCarOut;
import com.example.administrator.myparkingos.model.beans.gson.EntitySetCarOutNoCPH;
import com.example.administrator.myparkingos.model.beans.gson.EntitySummaryInfo;
import com.example.administrator.myparkingos.model.beans.gson.EntityUserInfo;
import com.example.administrator.myparkingos.util.L;
import com.example.administrator.myparkingos.util.TimeConvertUtils;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017-03-04.
 */
public class MonitorRemoteRequest
{
    /**
     * 1 获取车辆类型的信息 //    http://192.168.2.158:9000/ParkAPI/GetCardTypeDef?token=f7dc3eb130184505b82aa72fcd169296&jsonSearchParam=
     *
     * @param token
     * @param param
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityCarTypeInfo> GetCardTypeDef(String token, String param)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", param);

        List<EntityCarTypeInfo> entityCarTypeInfoList =
                RequestByURL.getDataListWithoutTokenField("GetCardTypeDef", EntityCarTypeInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(entityCarTypeInfoList, "GetCardTypeDef(String token, String param");
        return entityCarTypeInfoList;
    }

    /**
     * 2, http://192.168.2.158:9000/ParkAPI/GetCheDaoSet?token=296718d72111434c94ddbe068e7f343b&
     * jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22StationID%22%2c%22
     * Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a2%2c%22Combinator%22%3a%22and%22%7d%5d%2c%
     * 22Combinator%22%3a%22and%22%7d%5d&OrderField=OnLine%20desc,CtrlNumber%20asc,InOut%20asc
     * @return
     */

    /**
     * 获取车道信息
     *
     * @param token
     * @param stationId
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityRoadWaySet> GetCheDaoSet(String token, String stationId)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);

        LinkedHashMap<String, String> dic = new LinkedHashMap<String, String>();
        dic.put("StationID", stationId);
        tmpContainer.put("jsonSearchParam", RequestByURL.getJsonSearchParam(dic, false, false));

        dic.clear();
        dic.put("OnLine", "desc");
        dic.put("CtrlNumber", "asc");
        dic.put("InOut", "asc");
        tmpContainer.put("OrderField", RequestByURL.getOrderField(dic));

        List<EntityRoadWaySet> list = RequestByURL.getDataListWithoutTokenField("GetCheDaoSet", EntityRoadWaySet.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(list, "GetCheDaoSet(String token, String stationId)");
        return list;
    }

    /**
     * 3 获取设备参数 http://192.168.2.158:9000/ParkAPI/GetDeviceParameter?token=55b10f562a27406d921fccab85001ec9&StationId=2&CtrlNumber=3&IP=192.168.2.182
     *
     * @param token
     * @param stationId
     * @param ctrlNumber
     * @param ip
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntityDeviceParam GetDeviceParameter(String token, String stationId, String ctrlNumber, String ip)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("StationId", stationId);
        tmpContainer.put("CtrlNumber", ctrlNumber);
        tmpContainer.put("IP", ip);
        EntityDeviceParam entityDeviceParam = RequestByURL.getDataWithoutTokenField("GetDeviceParameter", EntityDeviceParam.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(entityDeviceParam, "GetDeviceParameter(String token, String stationId, String ctrlNumber, String ip)");
        return entityDeviceParam;
    }

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
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityCarTypeInfo> GetCardTypeDef(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        String chargeCarTypeToJsonSearchParam = RequestByURL.getChargeCarTypeToJsonSearchParam();
        tmpContainer.put("jsonSearchParam", chargeCarTypeToJsonSearchParam);

        List<EntityCarTypeInfo> chargeCarTypeList = RequestByURL.getDataListWithoutTokenField("GetCardTypeDef", EntityCarTypeInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(chargeCarTypeList, "GetCardTypeDef(String token)");
        return chargeCarTypeList;
    }

    /**
     * 5，http://192.168.2.158:9000/ParkAPI/GetChargeRules?token=55b10f562a27406d921fccab85001ec9&jsonSearchParam
     * =%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22ParkID%22%2c%22Operator%22%3a%22like%22%2c%22
     * FieldValue%22%3a0%2c%22Combinator%22%3a%22and%22%7d%2c%7b%22FieldName%22%3a%22CardType%22%2c%22
     * Operator%22%3a%22like%22%2c%22FieldValue%22%3a%22TmpA%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=CardType asc
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityChargeRules> GetChargeRules(String token, String parkId, String cardType)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> dic = new LinkedHashMap<String, String>();

        dic.put("CardType", cardType);
        dic.put("ParkID", parkId);

        tmpContainer.put("jsonSearchParam", RequestByURL.getJsonSearchParam(dic, false, true));
        tmpContainer.put("token", token);

        dic.clear();
        dic.put("CardType", "asc");
        tmpContainer.put("OrderField", RequestByURL.getOrderField(dic));

        List<EntityChargeRules> list = RequestByURL.getDataListWithoutTokenField("GetChargeRules", EntityChargeRules.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(list, "GetChargeRules(String token, String parkId, String cardType)");
        return list;
    }

    /**
     * 6, http://192.168.2.158:9000/ParkAPI/GetCarOut?token=55b10f562a27406d921fccab85001ec9&
     * jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22CarparkNO%22%2c%22Operator
     * %22%3a%22like%22%2c%22FieldValue%22%3a0%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=InTime desc
     * 查询车辆出厂记录
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityCarOut> GetCarOut(String token, String carParkNo)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> dic = new LinkedHashMap<String, String>();

        tmpContainer.put("token", token);

        dic.put("InTime", "desc");
        tmpContainer.put("OrderField", RequestByURL.getOrderField(dic));

        dic.clear();
        dic.put("CarparkNO", String.valueOf(carParkNo));
        String jsonSearchParam = RequestByURL.getJsonSearchParam(dic, false, true);
        if (jsonSearchParam != null)
        {
            tmpContainer.put("jsonSearchParam", jsonSearchParam);
        }
        List<EntityCarOut> entityCarOutList = RequestByURL.getDataListWithoutTokenField("GetCarOut", EntityCarOut.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(entityCarOutList, "GetCarOut(String token, String carParkNo)");
        return entityCarOutList;
    }

    /**
     * 7,http://192.168.2.158:9000/ParkAPI/GetCarIn?token=55b10f562a27406d921fccab85001ec9&
     * jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22CarparkNO%22%2c%22
     * Operator%22%3a%22like%22%2c%22FieldValue%22%3a0%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d&OrderField=ID%20desc
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityCarIn> GetCarIn(String token, String carParkNo)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> dic = new LinkedHashMap<String, String>();

        tmpContainer.put("token", token);

        dic.put("CarparkNO", carParkNo);
        String jsonSearchParam = RequestByURL.getJsonSearchParam(dic, false, true);
        if (jsonSearchParam != null)
        {
            tmpContainer.put("jsonSearchParam", jsonSearchParam);
        }
        dic.clear();
        dic.put("ID", "desc");
        tmpContainer.put("OrderField", RequestByURL.getOrderField(dic));
        List<EntityCarIn> entityCarInList = RequestByURL.getDataListWithoutTokenField("GetCarIn", EntityCarIn.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(entityCarInList, "GetCarIn(String token, String carParkNo)");
        return entityCarInList;
    }

    /**
     * 8, http://192.168.2.158:9000/ParkAPI/GetParkingInfo?token=296718d72111434c94ddbe068e7f343b&StartTime=20170222000000&CarParkNo=0
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntityParkingInfo GetParkingInfo(String token, String stationId)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> dic = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("StationId", stationId);
        tmpContainer.put("StartTime", TimeConvertUtils.longToString("yyyyMMdd000000", System.currentTimeMillis()));
        EntityParkingInfo entityParkingInfo = RequestByURL.getDataWithoutTokenField("GetParkingInfo", EntityParkingInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(entityParkingInfo, "GetParkingInfo(String token, String stationId)");
        return entityParkingInfo;
    }

    /**
     * 9, http://192.168.2.158:9000/ParkAPI/GetNetCameraSet?token=55b10f562a27406d921fccab85001ec9&jsonSearchParam=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22VideoIP%22%2c%22Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a%22192.168.6.211%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d
     * //通过camra IP来获取相机信息
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntityNetCameraSet> GetNetCameraSet(String token, String videoIP)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> dic = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);

        dic.put("VideoIP", videoIP);
        tmpContainer.put("jsonSearchParam", RequestByURL.getJsonSearchParam(dic, false, false));
        List<EntityNetCameraSet> list = RequestByURL.getDataListWithoutTokenField("GetNetCameraSet", EntityNetCameraSet.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(list, "GetNetCameraSet(String token, String videoIP)");
        return list;
    }

    /**
     * 10, http://192.168.2.158:9000/ParkAPI/AddOptLog?token=74da59f541244f17876b89550ed583f7&jsonModel=%7b%0d%0a++%22ID%22%3a+0%2c%0d%0a++%22StationID%22%3a+2%2c%0d%0a++%22OptNO%22%3a+%22888888%22%2c%0d%0a++%22UserName%22%3a+%22%e7%ae%a1%e7%90%86%e5%91%98%22%2c%0d%0a++%22OptMenu%22%3a+%22%e5%88%86%e5%b8%83%e5%bc%8f%e5%81%9c%e8%bd%a6%e5%9c%ba%e7%ae%a1%e7%90%86%e7%b3%bb%e7%bb%9f%22%2c%0d%0a++%22OptContent%22%3a+%22%e7%99%bb%e9%99%86%22%2c%0d%0a++%22OptTime%22%3a+%222017-02-23+14%3a46%3a23%22%2c%0d%0a++%22PCName%22%3a+null%2c%0d%0a++%22CarparkNO%22%3a+0%0d%0a%7d
     * //向服务器发送log日记信息
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static int AddOptLog(String token, String OptMenu, String OptContent, String userNo, String userName, String stationId)
    {
        EntityAddLog opt = new EntityAddLog();
        opt.setOptNO(userNo);
        opt.setUserName(userName);
        opt.setOptMenu(OptMenu);
        opt.setOptContent(OptContent);
        opt.setOptTime(TimeConvertUtils.longToString(System.currentTimeMillis()));
        opt.setStationID(Integer.parseInt(stationId));

        String s = RequestByURL.objectToGson(opt);
        String encode = URLEncoder.encode(s);

        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("token", token);
        map.put("jsonModel", encode);
        int logReponse = RequestByURL.getDataWithoutTokenField("AddOptLog", Integer.class, null, RequestByURL.mapConvertString(map));
        RequestByURL.displaySimpleInfo(logReponse, "AddOptLog(String token, String OptMenu, String OptContent, String userNo, String userName, String stationId)");
        return logReponse;
    }

    /**
     * 11, 心跳包 http://192.168.2.158:9000/ParkAPI/KeepAlive?token=5ab812323bff48359d3226fa2717e381
     */

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static int KeepAlive(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        int aliveReponse = RequestByURL.getDataWithoutTokenField("KeepAlive", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));// 注意可能keeplive失败，这里出现nullPointer的问题；
//        RequestByURL.displaySimpleInfo(aliveReponse, "KeepAlive(String token)");
        return aliveReponse;
    }


    /************************************************** 进场url开始 ****************************************************************************************/
    /**
     * 车辆进场
     * 数据源：车牌号 机号 工作站编号
     * 12 http://192.168.2.158:9000/ParkAPI/SetCarIn?token=5338443d63c14b15affc278ae40cd57d&CPH=粤A12345&CtrlNumber=3&StationId=1
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntitySetCarIn SetCarIn(String token, String CPH, String ctrlNo, String stationId)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("CPH", CPH);
        tmpContainer.put("CtrlNumber", ctrlNo);
        tmpContainer.put("StationId", stationId);
        EntitySetCarIn setCarIn = RequestByURL.getDataWithoutTokenField("SetCarIn", EntitySetCarIn.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(setCarIn, "SetCarIn(String token, String CPH, String ctrlNo, String stationId):");
        return setCarIn;
    }

    /**
     * 无牌车进场
     * 13, http://192.168.2.158:9000/ParkAPI/SetCarInWithoutCPH?&StationId=1&token=26ef42100f684dd5a909b0177164bc50&CtrlNumber=9
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntityNoPlateCarIn SetCarInWithoutCPH(String token, String ctrlNo, String stationId)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("CtrlNumber", ctrlNo);
        tmpContainer.put("StationId", stationId);
        EntityNoPlateCarIn noPlateCarIn = RequestByURL.getDataWithoutTokenField("SetCarInWithoutCPH", EntityNoPlateCarIn.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(noPlateCarIn, "SetCarInWithoutCPH(String token, String ctrlNo, String stationId)");
        return noPlateCarIn;
    }


    /**
     * 14, GetCarInByCarPlateNumberLike 根据车牌模糊对比
     * 可以用来模糊查询 （http://192.168.2.158:9000/ParkAPI/GetCarInByCarPlateNumberLike?CarPlateNumber=%E7%B2%A4a54321&token=ae4da4ed8bad49d7b5514447e61885fc&Precision=4 查询失败）
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static List<EntitySetCarIn> GetCarInByCarPlateNumberLike(String token, String CPH, String precision)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("CarPlateNumber", CPH); /// 注意不是CPH
        tmpContainer.put("Precision", precision);
        List<EntitySetCarIn> getCarInByCarPlateNumberLike = RequestByURL.getDataListWithoutTokenField("GetCarInByCarPlateNumberLike", EntitySetCarIn.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(getCarInByCarPlateNumberLike, "SetCarInWithoutCPH(String token, String ctrlNo, String stationId)");
        return getCarInByCarPlateNumberLike;
    }

    /**
     * 15,GetCarInSummaryInfo 获取场内车辆报表接口
     * http://192.168.2.158:9000/ParkAPI/GetCarInSummaryInfo?&token=26ef42100f684dd5a909b0177164bc50
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntitySummaryInfo GetCarInSummaryInfo(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        EntitySummaryInfo entitySummaryInfo = RequestByURL.getDataWithoutTokenField("GetCarInSummaryInfo", EntitySummaryInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(entitySummaryInfo, "GetCarInSummaryInfo(String token)");
        return entitySummaryInfo;
    }

    /************************************************** 进场url结束 ****************************************************************************************/


    /************************************************** 出场url结束 ****************************************************************************************/
    /**
     * 车辆出场 http://192.168.2.158:9000/ParkAPI/SetCarOut?&StationId=1&CPH=粤b55555&token=520d2e8492d1405baa2e25314a39541e&CtrlNumber=10
     *
     * @param token
     * @param CPH
     * @param ctrlNo    机号一定是出口车道
     * @param stationId
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntitySetCarOut SetCarOut(String token, String CPH, String ctrlNo, String stationId)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("CPH", CPH);
        tmpContainer.put("CtrlNumber", ctrlNo);
        tmpContainer.put("StationId", stationId);
        EntitySetCarOut setCarOut = RequestByURL.getDataWithoutTokenField("SetCarOut", EntitySetCarOut.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(setCarOut, "SetCarOut(String token, String CPH, String ctrlNo, String stationId)");
        return setCarOut;
    }

    /**
     * 无牌车出口
     * http://192.168.2.158:9000/ParkAPI/SetCarOutWithoutCPH?token=b6018e51fe16417fb959f3a3383fccc7&CtrlNumber=4&StationId=2&CardNO=31A80703&CardType=TmpA&InTime=20170303100028
     * 这里有疑问；文档说明有七个字段，但是在实例中只有6个，按照一定的方式拼接之后，发现还是服务器没有请求
     *
     * @param token
     * @param CPH
     * @param ctrlNo
     * @param stationId
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static EntitySetCarOutNoCPH SetCarOutWithoutCPH(String token, String CPH, String ctrlNo, String stationId, String cardNo, String carType, String inTime)
    {
//        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("token", token);
//        tmpContainer.put("CPH", CPH);
        tmpContainer.put("CtrlNumber", ctrlNo);
        tmpContainer.put("StationId", stationId);
        tmpContainer.put("CardNO", cardNo);
        tmpContainer.put("CardType", carType);
//        tmpContainer.put("InTime", inTime); // 2017-03-14 09:05:51需要相应的转换
        String yyyyMMddHHmmss = TimeConvertUtils.dateToString("yyyyMMddHHmmss", TimeConvertUtils.stringToDate(inTime));
        tmpContainer.put("InTime", yyyyMMddHHmmss);

        EntitySetCarOutNoCPH setCarOutWithoutCPH = RequestByURL.getDataWithoutTokenField("SetCarOutWithoutCPH", EntitySetCarOutNoCPH.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(setCarOutWithoutCPH, "SetCarOutWithoutCPH(String token, String CPH, String ctrlNo, String stationId, String cardNo, String carType, String inTime)");

        return setCarOutWithoutCPH;
    }
    /************************************************** 出场url结束 ****************************************************************************************/

    /**
     * 车牌登记 GetCardIssue 获取登记所有的车辆信息
     */

    /**
     * 获取当前所有的黑名单数据
     * http://192.168.2.158:9000/ParkAPI/GetBlacklist?token=d103c988a1f948d4aa9fce79763cad7e&jsonSearchParam=
     *
     * @param token
     * @return
     */
    public static List<EntityBlackList> GetBlacklist(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", "");
        List<EntityBlackList> getBlacklist = RequestByURL.getDataListWithoutTokenField("GetBlacklist", EntityBlackList.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getBlacklist, "GetBlacklist(String token)");
        return getBlacklist;
    }

    /**
     * 添加黑名单
     * Url	"http://192.168.2.158:9000/ParkAPI/DeleteBlacklistBy?token=d89f8c93d54e4599b605acd7686afb58&jsonConditions=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22CPH%22%2c%22Operator%22%3a%22%3d%22%2c%22FieldValue%22%3a%22%e9%84%82A12345%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d"	string
     * {"rcode":"200","msg":"OK","data":0}
     * <p>
     * Url	"http://192.168.2.158:9000/ParkAPI/AddBlacklist?token=e42b5ee3dcc54154834787879e068e91&jsonModel=%7b%0d%0a++%22ID%22%3a+0%2c%0d%0a++%22CPH%22%3a+%22%e9%84%82A12345%22%2c%0d%0a++%22StartTime%22%3a+%222017-03-14+00%3a00%3a00%22%2c%0d%0a++%22EndTime%22%3a+%222017-03-15+23%3a59%3a59%22%2c%0d%0a++%22Reason%22%3a+%22aa%22%2c%0d%0a++%22DownloadSignal%22%3a+%22000000000000000%22%2c%0d%0a++%22AddDelete%22%3a+0%0d%0a%7d"	string
     * retString	"{\"rcode\":\"40000\",\"msg\":\"获取Token失败或Token已失效.\"}"	string
     */
    public static int DeleteBlacklist(String token, String CPH)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("CPH", CPH);
        String where = JsonJoin.ToJson(tmpContainer, false, false);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonConditions", URLEncoder.encode(where));

        int result = RequestByURL.getDataWithoutTokenField("DeleteBlacklistBy", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(result, "DeleteBlacklist(String token, String CPH)");
        return result;
    }

    /**
     * 注意添加之前先需要删除信息
     * {"rcode":"200","msg":"OK","data":19}
     */
    public static int AddBlacklist(String token, BlackListOpt blackListOpt)
    {
        if (blackListOpt == null)
        {
            return -1;
        }

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonModel", URLEncoder.encode(RequestByURL.objectToGson(blackListOpt)));
        int result = RequestByURL.getDataWithoutTokenField("AddBlacklist", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(result, "AddBlacklist(String token, BlackListOpt blackListOpt)");
        return result;
    }

    /**
     * 根据车牌号码查询
     */
    public static List<EntityBlackList> GetBlacklistWhenSelect(String token, String CPH)
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();
        SelectModel sm = new SelectModel();

        sm.getConditions().add(sm.new conditions("CPH", "=", CPH, "and"));
        sm.getConditions().add(sm.new conditions("StartTime", "<", TimeConvertUtils.longToString(System.currentTimeMillis()), "and"));
        sm.getConditions().add(sm.new conditions("EndTime", ">", TimeConvertUtils.longToString(System.currentTimeMillis()), "and"));
        sm.getConditions().add(sm.new conditions("AddDelete", "=", "0", "and"));

        lstSM.add(sm);
        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);

        List<EntityBlackList> getBlacklist = RequestByURL.getDataListWithoutTokenField("GetBlacklist", EntityBlackList.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getBlacklist, "List<EntityBlackList> GetBlacklistWhenSelect(String token, String CPH)");
        return getBlacklist;
    }

    /**
     * 删除黑名单
     */
    public static int DeleteBlacklistBy(String token, String id)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("ID", id);
        String where = JsonJoin.ToJson(tmpContainer, false, false);

        tmpContainer.put("token", token);
        tmpContainer.put("jsonConditions", URLEncoder.encode(where));

        int result = RequestByURL.getDataWithoutTokenField("DeleteBlacklistBy", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(result, "DeleteBlacklistBy(String token, String id)");

        return result;
    }

    public static int UpdateBlacklist(String token, String id)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<>();
        tmpContainer.put("ID", id);
        String where = JsonJoin.ToJson(tmpContainer, false, false);

        LinkedHashMap<String, String> container = new LinkedHashMap<>();
        container.put("AddDelete", "1");
        String upDstr = URLEncoder.encode(RequestByURL.objectToGson(container));

        tmpContainer.clear();
        tmpContainer.put("token", token);

        String tableName = "";
        if (where == null)
        {
            tmpContainer.put("jsonModel", upDstr);
            tableName = "UpdateBlacklist";
        }
        else
        {
            tableName = "UpdateBlacklist" + "Fields";
            tmpContainer.put("jsonFieldValues", upDstr);
            tmpContainer.put("jsonConditions", where);
        }


        int result = RequestByURL.getDataWithoutTokenField(tableName, Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(result, "UpdateBlacklist(String token, String id)");
        return result;
    }

    /**
     * 全部删除 即一个个的删除 DeleteBlacklist，循环进行即可
     */


    /**
     * 期限查询
     */

    /**
     * 场内车辆查询 查询的条件有7个
     */

    /**
     * 收费记录 可以根据13个条件查询收费的结果 和 已归档出场记录接口 有关 使用jsonModel和jsonSearchParam的查询关系???
     *
     * 报表查询条件设置接口
     */


    /**
     * 换班登录 (即使用不同的用户名和账号登录)  - 相关联有换班登录表;
     * <p>
     * http://192.168.2.158:9000/ParkAPI/SetHandover?token=f1231fac139245af9bfa018a08abec2d&StationId=1
     * &OffDutyOperatorNo=666666&TakeOverOperatorNo=888888&LastTakeOverTime=20160101000000&ThisTakeOverTime=20160921000000
     * 生成换班报表记录接口
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static int SetHandover(
            String token, String stationId, String OffDutyOperatorNo
            , String TakeOverOperatorNo, String LastTakeOverTime, String ThisTakeOverTime
    ) // 生成换班报表记录接口
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("StationId", stationId);
        tmpContainer.put("OffDutyOperatorNo", OffDutyOperatorNo);
        tmpContainer.put("TakeOverOperatorNo", TakeOverOperatorNo);
        tmpContainer.put("LastTakeOverTime", LastTakeOverTime);
//        tmpContainer.put("InTime", inTime); // 2017-03-14 09:05:51需要相应的转换
//        String yyyyMMddHHmmss = TimeConvertUtils.dateToString("yyyyMMddHHmmss", TimeConvertUtils.stringToDate(inTime));
        tmpContainer.put("ThisTakeOverTime", ThisTakeOverTime);

        int setHandover = RequestByURL.getDataWithoutTokenField("SetHandover", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(setHandover, "SetHandover");
        return setHandover;
    }

    /**
     * http://192.168.2.158:9000/ParkAPI/GetHandoverPrint?token=f1231fac139245af9bfa018a08abec2d&StationId=1
     * &OffDutyOperatorNo=666666&LastTakeOverTime=20160101000000&ThisTakeOverTime=20160921000000
     * <p>
     * 这个消息返回的总是失败
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void GetHandoverPrint(
            String token, String stationId, String OffDutyOperatorNo
            , String LastTakeOverTime, String ThisTakeOverTime
    ) // 4.7.7获取临时换班统计记录接口
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("StationId", stationId);
        tmpContainer.put("OffDutyOperatorNo", OffDutyOperatorNo);
        tmpContainer.put("LastTakeOverTime", LastTakeOverTime);
//        tmpContainer.put("InTime", inTime); // 2017-03-14 09:05:51需要相应的转换
//        String yyyyMMddHHmmss = TimeConvertUtils.dateToString("yyyyMMddHHmmss", TimeConvertUtils.stringToDate(inTime));
        tmpContainer.put("ThisTakeOverTime", ThisTakeOverTime);

        EntitySetCarIn setCarIn = RequestByURL.getDataWithoutTokenField("GetHandoverPrint", EntitySetCarIn.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displaySimpleInfo(setCarIn, "GetHandoverPrint");
    }

    /**
     * 车牌登记中，进入界面加载数据，第一步获取机号
     */
    public static List<EntityParkJHSet> GetCCJiHao(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CtrlNumber", "asc");

        String where = RequestByURL.getOrderField(tmpContainer);
        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", "");
        tmpContainer.put("OrderField", where);

        List<EntityParkJHSet> getParkJHSet = RequestByURL.getDataListWithoutTokenField("GetParkJHSet", EntityParkJHSet.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getParkJHSet, "GetCCJiHao(String token)");
        return getParkJHSet;
    }

    /**
     * 车牌登记中获取卡片发行表，即列表的数据 ，第二步
     */
    public static List<EntityCardIssue> GetCarChePIss(String token, Map<String, String> map)
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();
        SelectModel sm = new SelectModel();

        sm.getConditions().add(sm.new conditions("SubSystem", "like", "1%", "and"));
        sm.getConditions().add(sm.new conditions("CardState", "=", "0", "and"));

        lstSM.add(sm);
        if (null != map && map.size() > 0)
        {
            Set<String> strings = map.keySet();
            for (String str : strings)
            {
                sm.getConditions().add(sm.new conditions(str, "like", map.get(str), "and"));
            }
            lstSM.add(sm);
        }

        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CarissueDate", "desc");
        String orderField = RequestByURL.getOrderField(tmpContainer);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        tmpContainer.put("OrderField", orderField);

        List<EntityCardIssue> getCardIssue = RequestByURL.getDataListWithoutTokenField("GetCardIssue", EntityCardIssue.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getCardIssue, "GetCarChePIss(String token, Map<String, String> map)");
        return getCardIssue;
    }

    /**
     * 车牌登记中获取人员编号信息 第三步
     */
    public static List<EntityPersonnelInfo> GetPersonnel(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("UserNo", "asc");

        String orderField = RequestByURL.getOrderField(tmpContainer);
        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", "");
        tmpContainer.put("OrderField", orderField);
        List<EntityPersonnelInfo> getUserInfo = RequestByURL.getDataListWithoutTokenField("GetUserInfo", EntityPersonnelInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getUserInfo, "GetPersonnel(String token)");
        return getUserInfo;
    }

    /**
     * 车牌登记中获取发行卡类型 第四步
     */
    public static List<EntityCarTypeInfo> GetGetFXCardTypeToTrue(String token)
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();

        SelectModel sm = new SelectModel();
        sm.getConditions().add(sm.new conditions("Identifying", "like", "Mth%", "or"));
        sm.getConditions().add(sm.new conditions("Identifying", "like", "Fre%", "or"));
        sm.getConditions().add(sm.new conditions("Identifying", "like", "Str%", "or"));
        lstSM.add(sm);

        SelectModel sm1 = new SelectModel();
        sm.getConditions().add(sm1.new conditions("Enabled", "=", "1", "and"));
        lstSM.add(sm1);

        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        List<EntityCarTypeInfo> getCardTypeDef = RequestByURL.getDataListWithoutTokenField("GetCardTypeDef", EntityCarTypeInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getCardTypeDef, "GetGetFXCardTypeToTrue");
        return getCardTypeDef;
    }

    /**
     * 车牌登记中获取自动卡号信息 GetAutoCardNo 第五步
     */
    public static List<EntityCardIssue> GetAutoCardNo(String token)
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();

        SelectModel sm = new SelectModel();
        sm.getConditions().add(sm.new conditions("CardNO", "like", "88______%", "or"));
        lstSM.add(sm);

        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CardNO", "desc");
        String orderField = RequestByURL.getOrderField(tmpContainer);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        tmpContainer.put("PageSize", "1");
        tmpContainer.put("Page", "1");
        tmpContainer.put("OrderField", orderField);
        List<EntityCardIssue> getCardIssue = RequestByURL.getDataListWithoutTokenField("GetCardIssue", EntityCardIssue.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(getCardIssue, "GetAutoCardNo");
        return getCardIssue;
    }

    /**
     * 车牌登记中获取人员编号信息 第六步
     */
    public static List<EntityUserInfo> GetAutoUsernoPersonnel(String token)
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();

        SelectModel sm = new SelectModel();
        sm.getConditions().add(sm.new conditions("UserNO", "like", "A_____%", "or"));
        lstSM.add(sm);

        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("UserNo", "desc");
        String orderField = RequestByURL.getOrderField(tmpContainer);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        tmpContainer.put("PageSize", "1");
        tmpContainer.put("Page", "1");
        tmpContainer.put("OrderField", orderField);
        List<EntityUserInfo> entityUserInfos = RequestByURL.getDataListWithoutTokenField("GetUserInfo", EntityUserInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(entityUserInfos, "GetAutoUsernoPersonnel");
        return entityUserInfos;
    }

    /**
     * 车牌登记中，点击注销按钮后，第一步先查找
     */
    public static void GetInCPH(String token, String CPH)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CPH", CPH);
        String jsonSearchParam = RequestByURL.getJsonSearchParam(tmpContainer, false, false);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", jsonSearchParam);

        EntitySetCarIn setCarIn = RequestByURL.getDataWithoutTokenField("GetCarIn", EntitySetCarIn.class, null, RequestByURL.mapConvertString(tmpContainer));
    }

    /**
     * 车牌登记中，点击注销按钮后，第二步更新卡片状态
     */
    public static void UpdateICState(String token, String CarNo, String start)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CardNO", CarNo);
        String where = RequestByURL.getJsonSearchParam(tmpContainer, false, false);

        tmpContainer.clear();
        tmpContainer.put("CardState", start);
        String jsonFieldValues = URLEncoder.encode(RequestByURL.objectToGson(tmpContainer));

        tmpContainer.clear();
        tmpContainer.put("token", token);
        String tableName = "";
        if (where == null)
        {
            tmpContainer.put("jsonModel", jsonFieldValues);
            tableName = "UpdateCardIssue";
        }
        else
        {
            tableName = "UpdateCardIssue" + "Fields";
            tmpContainer.put("jsonFieldValues", jsonFieldValues);
            tmpContainer.put("jsonConditions", where);
        }

        int result = RequestByURL.getDataWithoutTokenField(tableName, Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
    }

    /**
     * 车牌登记中，点击保存按钮后，第一步判断车牌号是否存在 //判断车牌是否重复
     */
    public static boolean IfCPHExitsbt(String token, String strCPH)
    {
        if (strCPH.length() < 6)
        {
            return false;
        }

        List<SelectModel> lstSM = new ArrayList<SelectModel>();

        SelectModel sm = new SelectModel();
        sm.getConditions().add(sm.new conditions("CPH", "like", "%" + strCPH.substring(1) + "%", "and"));
        sm.getConditions().add(sm.new conditions("CardState", "<>", "5", "and"));
        lstSM.add(sm);

        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        List<EntityCardIssue> lstCI = RequestByURL.getDataListWithoutTokenField("GetCardIssue", EntityCardIssue.class, null, RequestByURL.mapConvertString(tmpContainer));
        RequestByURL.displayListInfo(lstCI, "IfCPHExitsbt");

        if (lstCI.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean IfCardNOExitsbt(String token, String strCardNO)
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();

        SelectModel sm = new SelectModel();
        sm.getConditions().add(sm.new conditions("CardNO", "=", strCardNO, "and"));
        sm.getConditions().add(sm.new conditions("CardState", "<>", "5", "and"));
        lstSM.add(sm);

        String where = URLEncoder.encode(RequestByURL.objectToGson(lstSM));

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        List<EntityCardIssue> lstCI = RequestByURL.getDataListWithoutTokenField("GetCardIssue", EntityCardIssue.class, null, RequestByURL.mapConvertString(tmpContainer));
        if (lstCI.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 车牌登记中，点击保存按钮后，第二步 //对比车牌后6位
     */
    public static int GetInRecordIsTmp(String token, String strCPH)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CPH", "%" + strCPH.substring(1));
        tmpContainer.put("CardType", "Tmp%");
        String jsonSearchParam = RequestByURL.getJsonSearchParam(tmpContainer, false, true);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", jsonSearchParam);

        List<EntityCardIssue> getCardIssue = RequestByURL.getDataListWithoutTokenField("GetCardIssue", EntityCardIssue.class, null, RequestByURL.mapConvertString(tmpContainer));
        if (getCardIssue != null)
        {
            return getCardIssue.size();
        }
        else
            return 0;
    }

    /**
     * 车牌登记中，点击保存按钮后，第三步 //则把入场记录改为发行卡类 取车牌后6位对比
     */
    public static int UpdateInCPHCardType(String token, String strCPH, String sCardType, String strCardNO)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CPH", "%" + strCPH.substring(1));
        tmpContainer.put("CardType", "Tmp%");
        String where = RequestByURL.getJsonSearchParam(tmpContainer, false, true);

        tmpContainer.clear();
        tmpContainer.put("CardType", sCardType);
        tmpContainer.put("CPH", strCPH);
        tmpContainer.put("CardNO", strCardNO);
        String encode = URLEncoder.encode(RequestByURL.objectToGson(tmpContainer));

        tmpContainer.clear();
        tmpContainer.put("token", token);

        String tableName = "";
        if (where == null)
        {
            tmpContainer.put("jsonModel", encode);
            tableName = "UpdateCarIn";
        }
        else
        {
            tableName = "UpdateCarIn" + "Fields";
            tmpContainer.put("jsonFieldValues", encode);
            tmpContainer.put("jsonConditions", where);
        }

        int result = RequestByURL.getDataWithoutTokenField(tableName, Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        return result;
    }

    /**
     * 车牌登记中，点击保存按钮后，第四步 不太理解
     */
    public static void PersonnelAddCpdj(String token, EntityUserInfo entityUserInfo, int count)
    {
        if (entityUserInfo == null)
        {
            return;
        }

        /**
         *
         * http://192.168.2.158:9000/ParkAPI/UpdateUserInfoFields?token=2adfd0332f73439c977df0c98343042e&jsonFieldValues=
         * %5B%7B%22Combinator%22%3A%22and%22%2C%22Conditions%22%3A%5B%7B%22Combinator%22%3A%22and%22%2C%22FieldName%22%3A%22UserName
         * %22%2C%22FieldValue%22%3A%22wy%22%2C%22Operator%22%3A%22%5Cu003d%22%7D%2C%7B%22Combinator%22%3A%22and%22%2C%22FieldName%22%3A%
         * 22HomeAddress%22%2C%22FieldValue%22%3A%22%22%2C%22Operator%22%3A%22%5Cu003d%22%7D%2C%7B%22Combinator%22%3A%22and%22%2C%22FieldName%22
         * %3A%22IDCard%22%2C%22FieldValue%22%3A%22%22%2C%22Operator%22%3A%22%5Cu003d%22%7D%2C%7B%22Combinator%22%3A%22and%22%2C%22FieldName%22%3A
         * %22MobNumber%22%2C%22FieldValue%22%3A%22%22%2C%22Operator%22%3A%22%5Cu003d%22%7D%2C%7B%22Combinator%22%3A%22and%22%2C%22FieldName%22%3A%22
         * CarPlaceNo%22%2C%22FieldValue%22%3A%221%22%2C%22Operator%22%3A%22%5Cu003d%22%7D%5D%7D%5D&jsonConditions=%5B%7B%22Combinator%22%3A%22and%22%2C%22Conditions
         * %22%3A%5B%7B%22Combinator%22%3A%22and%22%2C%22FieldName%22%3A%22UserNO%22%2C%22FieldValue%22%3A%2280052%22%2C%22Operator%22%3A%22%5Cu003d%22%7D%5D%7D%5D,
         * {"rcode":"40001","msg":"Cannot deserialize the current JSON array (e.g. [1,2,3]) into type 'System.Collections.Generic.Dictionary`2[System.String,System.Object]'
         * because the type requires a JSON object (e.g. {\"name\":\"value\"}) to deserialize correctly.\r\nTo fix this error either change the JSON to a JSON object (e.g.
         * {\"name\":\"value\"}) or change the deserialized type to an array or a type that implements a collection interface (e.g. ICollection, IList) like List<T>
         *     that can be deserialized from a JSON array.
         * JsonArrayAttribute can also be added to the type to force it to deserialize from a JSON array.\r\nPath '', line 1, position 1."}
         *
         *
         * c #代码中的：
         * 		string.Format 返回	"http://192.168.2.158:9000/ParkAPI/UpdateUserInfoFields?
         * token=d691b6fbc0ab4ca1973a57545e233ddb&jsonFieldValues=%7b%0d%0a++%22UserName
         * %22%3a+%22fda%22%2c%0d%0a++%22HomeAddress%22%3a+%22%22%2c%0d%0a++%22IDCard%22%3a+%22%22%2c%0d%0a++%22MobNumber%22%3a+%
         * 22dfa%22%2c%0d%0a++%22CarPlaceNo%22%3a+%221%22%0d%0a%7d&jsonConditions=%5b%7b%22Conditions%22%3a%5b%7b%22FieldName%22%3a%22UserNO%22%2c%22O
         * perator%22%3a%22%3d%22%2c%22FieldValue%22%3a%22A00033%22%2c%22Combinator%22%3a%22and%22%7d%5d%2c%22Combinator%22%3a%22and%22%7d%5d"

         */
        Log.i("GetPersonnel:", entityUserInfo.toString());



        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        if (count > 0)
        {
            tmpContainer.put("UserNO", checkIsNull(entityUserInfo.getUserNO()));

            String where = RequestByURL.getJsonSearchParam(tmpContainer, false, false);

            tmpContainer.clear();
            tmpContainer.put("UserName", checkIsNull(entityUserInfo.getUserName()));
            tmpContainer.put("HomeAddress", checkIsNull(entityUserInfo.getHomeAddress()));
            tmpContainer.put("IDCard", checkIsNull(entityUserInfo.getIDCard()));
            tmpContainer.put("MobNumber", checkIsNull(entityUserInfo.getMobNumber()));
            tmpContainer.put("CarPlaceNo", entityUserInfo.getCarPlaceNo() == 0 ? "1" : String.valueOf(entityUserInfo.getCarPlaceNo()));

            L.i("PersonnelAddCpdj tmpContainer:" + tmpContainer.toString());// 重复的请求数据

//            String orderField = RequestByURL.getJsonSearchParam(tmpContainer, false, false);

            String orderField = URLEncoder.encode(RequestByURL.objectToGson(tmpContainer));

            tmpContainer.clear();
            tmpContainer.put("token", token);
            String tableName = "";
            if (where == null)
            {
                tmpContainer.put("jsonModel", orderField);
                tableName = "UpdateUserInfo";
            }
            else
            {
                tableName = "UpdateUserInfo" + "Fields";
                tmpContainer.put("jsonFieldValues", orderField);
                tmpContainer.put("jsonConditions", where);
            }

            RequestByURL.getDataWithoutTokenField(tableName, Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        }
        else
        {
            String toGson = URLEncoder.encode(RequestByURL.objectToGson(entityUserInfo));
            tmpContainer.put("token", token);
            tmpContainer.put("jsonModel", toGson);
            RequestByURL.getDataWithoutTokenField("AddUserInfo", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        }
    }

    /**
     * 在c# 代码中，是在PersonnelAddCpdj中调用的;
     */
    public static int IsExsits(String token, String UserNO)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("UserNO", UserNO);
        String where = RequestByURL.getJsonSearchParam(tmpContainer, false, false);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", where);
        List<EntityUserInfo> lstUserInfo = RequestByURL.getDataListWithoutTokenField("GetUserInfo", EntityUserInfo.class, null, RequestByURL.mapConvertString(tmpContainer));
        return lstUserInfo == null ? 0 : lstUserInfo.size();
    }

    /**
     * 车牌登记中，点击保存按钮后，第五步
     *
     * @param token
     * @param entityCardIssue
     */
    public static int UpdateCPdjfx(String token, EntityCardIssue entityCardIssue)
    {
        if (null == entityCardIssue) return 0;
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonModel", URLEncoder.encode(RequestByURL.objectToGson(entityCardIssue)));
        RequestByURL.getDataWithoutTokenField("UpdateCardIssue", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        return 1;
    }

    public static int DeleteFaXing(String token, String CarNo)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CardNO", CarNo);
        String jsonSearchParam = RequestByURL.getJsonSearchParam(tmpContainer, false, false);
        tmpContainer.clear();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonConditions", jsonSearchParam);
        int deleteCardIssueBy = RequestByURL.getDataWithoutTokenField("DeleteCardIssueBy", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        return deleteCardIssueBy;
    }

    /**
     * 充值记录表
     */
    public static void AddMoney(String token, EntityMoney money)
    {
        if (null == money)
            return ;
        String objectToGson = URLEncoder.encode(RequestByURL.objectToGson(money));
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonModel", objectToGson);
        RequestByURL.getDataWithoutTokenField("AddMoney", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
    }

    /**
     * 插入操作员表
     *
     * @param cardIssue
     */
    public static void AddOperator(String token, EntityCardIssue cardIssue)
    {
        if (cardIssue == null)
            return;

        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("CardNO", cardIssue.getCardNO());
        String where = RequestByURL.getJsonSearchParam(tmpContainer, false, false);

        tmpContainer.clear();
        tmpContainer.put("UserNO", cardIssue.getUserNO());
        tmpContainer.put("UserName", cardIssue.getUserName());
//        tmpContainer.put("DeptName", cardIssue.getDeptName());
        String orderField = RequestByURL.objectToGson(tmpContainer);

        tmpContainer.clear();
        tmpContainer.put("token", token);
        String tableName = "";
        if (where == null)
        {
            tmpContainer.put("jsonModel", orderField);
            tableName = "UpdateOperators";
        }
        else
        {
            tableName = "UpdateOperators" + "Fields";
            tmpContainer.put("jsonFieldValues", orderField);
            tmpContainer.put("jsonConditions", where);
        }
        int ret = RequestByURL.getDataWithoutTokenField(tableName, Integer.class, null, RequestByURL.mapConvertString(tmpContainer));

        if (ret > 0)
        {

        }
        else
        {
            EntityOperatorDetail ot = new EntityOperatorDetail();
            ot.setCardNO(cardIssue.getCardNO());
            ot.setCardType(cardIssue.getCardType());
            ot.setUserNO(cardIssue.getUserNO());

            ot.setUserName(cardIssue.getUserName());
//            ot.setDeptName(cardIssue.getDeptName());
            ot.setPwd("");
            ot.setCardState(0);
            ot.setUserLevel(2);
            String objectToGson = URLEncoder.encode(RequestByURL.objectToGson(ot));
            tmpContainer.clear();
            tmpContainer.put("token", token);
            tmpContainer.put("jsonModel", objectToGson);
            RequestByURL.getDataWithoutTokenField("AddOperators", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        }
    }


    public static void Addchdj(String token, EntityCardIssue model)
    {
        if (null == model)
            return;
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        if ((
                model.getCarCardType().substring(0, 3).equals("Mth")
                        || model.getCarCardType().substring(0, 3).equals("Fre")
                        || model.getCarCardType().substring(0, 3).equals("Str")
        )
                && !model.getCPH().equals(""))
        {
            tmpContainer.put("CPH", model.getCPH());
            String objectToGson = RequestByURL.getJsonSearchParam(tmpContainer, false, false);
            tmpContainer.clear();
            tmpContainer.put("token", token);
            tmpContainer.put("jsonConditions", objectToGson);

            RequestByURL.getDataWithoutTokenField("DeleteCardIssueBy", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
        }
        String encode = URLEncoder.encode(RequestByURL.objectToGson(model));
        tmpContainer.put("token", token);
        tmpContainer.put("jsonModel", encode);
        RequestByURL.getDataWithoutTokenField("AddCardIssue", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
    }

    public static void GetPrint(String token)
    {
        LinkedHashMap<String, String> tmpContainer = new LinkedHashMap<String, String>();
        tmpContainer.put("token", token);
        tmpContainer.put("jsonSearchParam", "");
        RequestByURL.getDataWithoutTokenField("GetBillPrintSet", Integer.class, null, RequestByURL.mapConvertString(tmpContainer));
    }

    private static String checkIsNull(String src)
    {
        if (src == null)
            return "";
        else
            return src.trim();
    }
}
