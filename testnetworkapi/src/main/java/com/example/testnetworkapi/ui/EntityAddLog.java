package com.example.testnetworkapi.ui;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityAddLog
{

    /**
     * ID : 0
     * StationID : 2
     * OptNO : 888888
     * UserName : 管理员
     * OptMenu : 分布式停车场管理系统
     * OptContent : 登陆
     * OptTime : 2017-02-23 14:46:23
     * PCName : null
     * CarparkNO : 0
     */

    private int ID;
    private int StationID;
    private String OptNO;
    private String UserName;
    private String OptMenu;
    private String OptContent;
    private String OptTime;
    private Object PCName;
    private int CarparkNO;

    public EntityAddLog()
    {

    }

    public EntityAddLog(int ID, int stationID, String optNO, String userName, String optMenu, String optContent, String optTime, Object PCName, int carparkNO)
    {
        this.ID = ID;
        StationID = stationID;
        OptNO = optNO;
        UserName = userName;
        OptMenu = optMenu;
        OptContent = optContent;
        OptTime = optTime;
        this.PCName = PCName;
        CarparkNO = carparkNO;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getStationID()
    {
        return StationID;
    }

    public void setStationID(int StationID)
    {
        this.StationID = StationID;
    }

    public String getOptNO()
    {
        return OptNO;
    }

    public void setOptNO(String OptNO)
    {
        this.OptNO = OptNO;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    public String getOptMenu()
    {
        return OptMenu;
    }

    public void setOptMenu(String OptMenu)
    {
        this.OptMenu = OptMenu;
    }

    public String getOptContent()
    {
        return OptContent;
    }

    public void setOptContent(String OptContent)
    {
        this.OptContent = OptContent;
    }

    public String getOptTime()
    {
        return OptTime;
    }

    public void setOptTime(String OptTime)
    {
        this.OptTime = OptTime;
    }

    public Object getPCName()
    {
        return PCName;
    }

    public void setPCName(Object PCName)
    {
        this.PCName = PCName;
    }

    public int getCarparkNO()
    {
        return CarparkNO;
    }

    public void setCarparkNO(int CarparkNO)
    {
        this.CarparkNO = CarparkNO;
    }

    @Override
    public String toString()
    {
        return "EntityAddLog{" +
                "ID=" + ID +
                ", StationID=" + StationID +
                ", OptNO='" + OptNO + '\'' +
                ", UserName='" + UserName + '\'' +
                ", OptMenu='" + OptMenu + '\'' +
                ", OptContent='" + OptContent + '\'' +
                ", OptTime='" + OptTime + '\'' +
                ", PCName=" + PCName +
                ", CarparkNO=" + CarparkNO +
                '}';
    }
}
