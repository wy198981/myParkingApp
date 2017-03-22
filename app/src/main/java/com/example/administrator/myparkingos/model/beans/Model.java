package com.example.administrator.myparkingos.model.beans;

import com.example.administrator.myparkingos.model.beans.gson.EntityRights;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-02-17.
 */
public class Model
{
    /**
     * 1, 服务器 IP 地址
     */
    public static String serverIP = "192.168.2.158";
    /**
     * 2，服务器的端口号
     */
    public static String serverPort = "9000";

    /// <summary>
    /// 权限分配List
    /// </summary>
    public static List<EntityRights> lstRights = new ArrayList<EntityRights>();

    /// <summary>
    /// token(用于访问服务器的唯一凭证)
    /// </summary>
    public static String token = "";

    /// <summary>
    /// 当前工作站的编号(唯一)
    /// </summary>
    public static int stationID = 1;

    /// <summary>
    /// 公司名称
    /// </summary>
    public static String sCompany = "";

    /// <summary>
    /// 用户名称
    /// </summary>
    public static String sUserName = "";

    /// <summary>
    /// 用户卡号
    /// </summary>
    public static String sUserCard = "";

    /// <summary>
    /// 用户权限组编号
    /// </summary>
    public static int sGroupNo = 0;

    /// <summary>
    /// 用户密码
    /// </summary>
    public static String sUserPwd = "";


    /// <summary>
    /// 车场编号(TTCBianHao)
    /// </summary>
    public static int iParkingNo = 0;

    /// <summary>
    ///登录时间 用长整形来表示
    /// </summary>
//    public static DateTime dLoginTime;//
    public static long dLoginTime;

    /// <summary>
    /// 当前电脑设置的车道数量
    /// </summary>
    public static int iChannelCount;
    /**
     * 对于 Model 数据初始化
     */
    public static void DataInit()
    {

    }
}
