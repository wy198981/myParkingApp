package com.example.administrator.myparkingos.ParkingInterface;

/**
 * Created by Administrator on 2017-02-20.
 */
public class GetServiceData
{
    /*Request request = new Request();

    *//**
     * 添加一条日志记录
     * @param OptMenu 表示当前UI 界面的标题
     * @param OptContent 表示具体消息的信息
     *//*
    public void AddLog(String OptMenu, String OptContent)
    {
        OptLog opt = new OptLog();
        opt.setOptNO(Model.sUserCard);
        opt.setUserName(Model.sUserName);
        opt.setOptMenu(OptMenu);
        opt.setOptContent(OptContent);
//        opt.setOptTime(DateTime.Now); // DateTime -> Time来替换

        opt.setStationID(Model.stationID);
        String addStr = JsonJoin.ModelToJson(opt);
        int ret = request.AddData(Model.token, "tOptLog", addStr);

    }

    *//**
     * 获取车场数据，并保存到全局变量中
     *//*
    public void DataSourceToPubVar()
    {

    }

    *//**
     * 获取系统时间
     * @return
     *//*
    public String GetSysTime()
    {
        return null;
    }

    *//**
     * 通过 userNo找到操作员列表
     * @param userNo
     * @return
     *//*
    public List<Operators> GetOperators(String userNo)
    {
        return null;
    }

    *//**
     * 通过groupNo获取权限列表
     * @param groupNo
     * @return
     *//*
    public List<Rights> GetRights(int groupNo)
    {
        return null;
    }

    *//**
     * 例如，从在线监控中的CmdView中获取权限列表
     * @param fromName
     * @param itemName
     * @return
     *//*
    public List<Rights> GetRightsByName(String fromName, String itemName)
    {
        return null;
    }

    public Map<String, String> GetParkSysSet(int stationId)
    {
        Map<String, String> dic = request.GetSysSettingObject(Model.token, stationId);
        return dic;
    }*/
}
