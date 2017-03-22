package com.example.administrator.myparkingos.ParkingModel;

/**
 * Created by Administrator on 2017-02-20.
 */
public class OptLog
{
    public OptLog()
    {

    }

    /// <summary>
    /// 1) ID
    /// </summary>
    private long ID;

    /// <summary>
    /// 2) 工作站编号
    /// </summary>
    private int StationID;

    /// <summary>
    /// 3) 操作员编号
    /// </summary>
    private String OptNO;

    /// <summary>
    /// 4) 操作员
    /// </summary>
    private String UserName;

    /// <summary>
    /// 5) 操作菜单
    /// </summary>
    private String OptMenu;

    /// <summary>
    /// 6) 操作内容
    /// </summary>
    private String OptContent;

    /// <summary>
    /// 7) 操作时间
    /// </summary>
//    private DateTime OptTime;

    /// <summary>
    /// 8) 电脑名
    /// </summary>
    private String PCName;

    /// 9) 车场号
    private int CarparkNO;

    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public int getStationID()
    {
        return StationID;
    }

    public void setStationID(int stationID)
    {
        StationID = stationID;
    }

    public String getOptNO()
    {
        return OptNO;
    }

    public void setOptNO(String optNO)
    {
        OptNO = optNO;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String userName)
    {
        UserName = userName;
    }

    public String getOptMenu()
    {
        return OptMenu;
    }

    public void setOptMenu(String optMenu)
    {
        OptMenu = optMenu;
    }

    public String getOptContent()
    {
        return OptContent;
    }

    public void setOptContent(String optContent)
    {
        OptContent = optContent;
    }

    // DataTime c# 中独有的 android用Time替换
//    public DateTime getOptTime()
//    {
//        return OptTime;
//    }

//    public void setOptTime(DateTime optTime)
//    {
//        OptTime = optTime;
//    }

    public String getPCName()
    {
        return PCName;
    }

    public void setPCName(String PCName)
    {
        this.PCName = PCName;
    }

    public int getCarparkNO()
    {
        return CarparkNO;
    }

    public void setCarparkNO(int carparkNO)
    {
        CarparkNO = carparkNO;
    }

    @Override
    public String toString()
    {
        return "OptLog{" +
                "ID=" + ID +
                ", StationID=" + StationID +
                ", OptNO='" + OptNO + '\'' +
                ", UserName='" + UserName + '\'' +
                ", OptMenu='" + OptMenu + '\'' +
                ", OptContent='" + OptContent + '\'' +
//                ", OptTime=" + OptTime +
                ", PCName='" + PCName + '\'' +
                ", CarparkNO=" + CarparkNO +
                '}';
    }
}
