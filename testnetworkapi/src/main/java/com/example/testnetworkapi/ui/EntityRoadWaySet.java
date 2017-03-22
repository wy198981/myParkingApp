package com.example.testnetworkapi.ui;

import java.util.List;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityRoadWaySet
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"StationName":"2号工作站","CarparkNO":0,"StationID":2,"InOut":0,"InOutName":"入口车道3","CtrlNumber":3,"OpenID":3,"OpenType":7,"PersonVideo":0,"BigSmall":0,"CheckPortID":0,"OnLine":1,"TempOut":0,"HasOutCard":0,"XieYi":1,"IP":"192.168.2.182","CameraIP":"192.168.6.211","OfflineSendSignal":false,"OfflineReciveSignal":false,"Temp1":0,"Temp2":0,"Temp3":0,"ID":45},{"StationName":"2号工作站","CarparkNO":0,"StationID":2,"InOut":1,"InOutName":"出口车道4","CtrlNumber":4,"OpenID":4,"OpenType":7,"PersonVideo":0,"BigSmall":0,"CheckPortID":0,"OnLine":1,"TempOut":0,"HasOutCard":0,"XieYi":1,"IP":"192.168.2.183","CameraIP":"192.168.6.212","OfflineSendSignal":false,"OfflineReciveSignal":false,"Temp1":0,"Temp2":0,"Temp3":0,"ID":46}]
     */

    /**
     * StationName : 2号工作站
     * CarparkNO : 0
     * StationID : 2
     * InOut : 0
     * InOutName : 入口车道3
     * CtrlNumber : 3
     * OpenID : 3
     * OpenType : 7
     * PersonVideo : 0
     * BigSmall : 0
     * CheckPortID : 0
     * OnLine : 1
     * TempOut : 0
     * HasOutCard : 0
     * XieYi : 1
     * IP : 192.168.2.182
     * CameraIP : 192.168.6.211
     * OfflineSendSignal : false
     * OfflineReciveSignal : false
     * Temp1 : 0
     * Temp2 : 0
     * Temp3 : 0
     * ID : 45
     */

    private String StationName;
    private int CarparkNO;
    private int StationID;
    private int InOut;
    private String InOutName;
    private int CtrlNumber;
    private int OpenID;
    private int OpenType;
    private int PersonVideo;
    private int BigSmall;
    private int CheckPortID;
    private int OnLine;
    private int TempOut;
    private int HasOutCard;
    private int XieYi;
    private String IP;
    private String CameraIP;
    private boolean OfflineSendSignal;
    private boolean OfflineReciveSignal;
    private int Temp1;
    private int Temp2;
    private int Temp3;
    private int ID;

    public String getStationName()
    {
        return StationName;
    }

    public void setStationName(String StationName)
    {
        this.StationName = StationName;
    }

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

    public int getInOut()
    {
        return InOut;
    }

    public void setInOut(int InOut)
    {
        this.InOut = InOut;
    }

    public String getInOutName()
    {
        return InOutName;
    }

    public void setInOutName(String InOutName)
    {
        this.InOutName = InOutName;
    }

    public int getCtrlNumber()
    {
        return CtrlNumber;
    }

    public void setCtrlNumber(int CtrlNumber)
    {
        this.CtrlNumber = CtrlNumber;
    }

    public int getOpenID()
    {
        return OpenID;
    }

    public void setOpenID(int OpenID)
    {
        this.OpenID = OpenID;
    }

    public int getOpenType()
    {
        return OpenType;
    }

    public void setOpenType(int OpenType)
    {
        this.OpenType = OpenType;
    }

    public int getPersonVideo()
    {
        return PersonVideo;
    }

    public void setPersonVideo(int PersonVideo)
    {
        this.PersonVideo = PersonVideo;
    }

    public int getBigSmall()
    {
        return BigSmall;
    }

    public void setBigSmall(int BigSmall)
    {
        this.BigSmall = BigSmall;
    }

    public int getCheckPortID()
    {
        return CheckPortID;
    }

    public void setCheckPortID(int CheckPortID)
    {
        this.CheckPortID = CheckPortID;
    }

    public int getOnLine()
    {
        return OnLine;
    }

    public void setOnLine(int OnLine)
    {
        this.OnLine = OnLine;
    }

    public int getTempOut()
    {
        return TempOut;
    }

    public void setTempOut(int TempOut)
    {
        this.TempOut = TempOut;
    }

    public int getHasOutCard()
    {
        return HasOutCard;
    }

    public void setHasOutCard(int HasOutCard)
    {
        this.HasOutCard = HasOutCard;
    }

    public int getXieYi()
    {
        return XieYi;
    }

    public void setXieYi(int XieYi)
    {
        this.XieYi = XieYi;
    }

    public String getIP()
    {
        return IP;
    }

    public void setIP(String IP)
    {
        this.IP = IP;
    }

    public String getCameraIP()
    {
        return CameraIP;
    }

    public void setCameraIP(String CameraIP)
    {
        this.CameraIP = CameraIP;
    }

    public boolean isOfflineSendSignal()
    {
        return OfflineSendSignal;
    }

    public void setOfflineSendSignal(boolean OfflineSendSignal)
    {
        this.OfflineSendSignal = OfflineSendSignal;
    }

    public boolean isOfflineReciveSignal()
    {
        return OfflineReciveSignal;
    }

    public void setOfflineReciveSignal(boolean OfflineReciveSignal)
    {
        this.OfflineReciveSignal = OfflineReciveSignal;
    }

    public int getTemp1()
    {
        return Temp1;
    }

    public void setTemp1(int Temp1)
    {
        this.Temp1 = Temp1;
    }

    public int getTemp2()
    {
        return Temp2;
    }

    @Override
    public String toString()
    {
        return "EntityRoadWaySet{" +
                "StationName='" + StationName + '\'' +
                ", CarparkNO=" + CarparkNO +
                ", StationID=" + StationID +
                ", InOut=" + InOut +
                ", InOutName='" + InOutName + '\'' +
                ", CtrlNumber=" + CtrlNumber +
                ", OpenID=" + OpenID +
                ", OpenType=" + OpenType +
                ", PersonVideo=" + PersonVideo +
                ", BigSmall=" + BigSmall +
                ", CheckPortID=" + CheckPortID +
                ", OnLine=" + OnLine +
                ", TempOut=" + TempOut +
                ", HasOutCard=" + HasOutCard +
                ", XieYi=" + XieYi +
                ", IP='" + IP + '\'' +
                ", CameraIP='" + CameraIP + '\'' +
                ", OfflineSendSignal=" + OfflineSendSignal +
                ", OfflineReciveSignal=" + OfflineReciveSignal +
                ", Temp1=" + Temp1 +
                ", Temp2=" + Temp2 +
                ", Temp3=" + Temp3 +
                ", ID=" + ID +
                '}';
    }

    public void setTemp2(int Temp2)
    {
        this.Temp2 = Temp2;
    }

    public int getTemp3()
    {
        return Temp3;
    }

    public void setTemp3(int Temp3)
    {
        this.Temp3 = Temp3;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

}
