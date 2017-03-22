package com.example.testnetworkapi.ui;


/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityNetCameraSet
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"CarparkNO":0,"StationID":0,"VideoIP":"192.168.6.211","VideoPort":80,"VideoUserName":"admin","VideoPassWord":"admin","VideoType":"ZNYKTY5","ID":18}]
     */
    /**
     * CarparkNO : 0
     * StationID : 0
     * VideoIP : 192.168.6.211
     * VideoPort : 80
     * VideoUserName : admin
     * VideoPassWord : admin
     * VideoType : ZNYKTY5
     * ID : 18
     */

    private int CarparkNO;
    private int StationID;
    private String VideoIP;
    private int VideoPort;
    private String VideoUserName;
    private String VideoPassWord;
    private String VideoType;
    private int ID;

    public int getCarparkNO()
    {
        return CarparkNO;
    }

    public void setCarparkNO(int CarparkNO)
    {
        this.CarparkNO = CarparkNO;
    }

    public int getStationID()
    {
        return StationID;
    }

    public void setStationID(int StationID)
    {
        this.StationID = StationID;
    }

    public String getVideoIP()
    {
        return VideoIP;
    }

    public void setVideoIP(String VideoIP)
    {
        this.VideoIP = VideoIP;
    }

    public int getVideoPort()
    {
        return VideoPort;
    }

    public void setVideoPort(int VideoPort)
    {
        this.VideoPort = VideoPort;
    }

    public String getVideoUserName()
    {
        return VideoUserName;
    }

    public void setVideoUserName(String VideoUserName)
    {
        this.VideoUserName = VideoUserName;
    }

    public String getVideoPassWord()
    {
        return VideoPassWord;
    }

    public void setVideoPassWord(String VideoPassWord)
    {
        this.VideoPassWord = VideoPassWord;
    }

    public String getVideoType()
    {
        return VideoType;
    }

    public void setVideoType(String VideoType)
    {
        this.VideoType = VideoType;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    @Override
    public String toString()
    {
        return "EntityNetCameraSet{" +
                "CarparkNO=" + CarparkNO +
                ", StationID=" + StationID +
                ", VideoIP='" + VideoIP + '\'' +
                ", VideoPort=" + VideoPort +
                ", VideoUserName='" + VideoUserName + '\'' +
                ", VideoPassWord='" + VideoPassWord + '\'' +
                ", VideoType='" + VideoType + '\'' +
                ", ID=" + ID +
                '}';
    }
}
