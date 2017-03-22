package com.example.testnetworkapi.ui;

import java.util.List;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityCarOut
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"UserNO":"A00009","UserName":"1111","DeptId":0,"DeptName":"","ChineseName":"月租车A","StationName":"5","CarparkNOInStation":0,"PayTypeCaption":"现金","InID":111,"CardNO":"88000012","CPH":"粤TTTTTT","CardType":"MthA","InTime":"2017-02-21 14:57:52","OutTime":"2017-02-21 14:57:56","InGateName":"入口车道21","OutGateName":"出口车道24","InOperatorCard":"888888","OutOperatorCard":"888888","InOperator":"管理员","OutOperator":"管理员","InPic":"CaptureImage\\5\\20170221\\7a9a2cb0-de2f-409d-854b-0266f73500bb20170221145752cin.jpg","InUser":"","OutPic":"CaptureImage\\5\\20170221\\d3c01915-5ca5-447c-9272-c4ada464404c20170221145756cin.jpg","OutUser":"","SFJE":0,"Balance":0,"YSJE":0,"SFTime":"2017-02-21 14:57:56","OvertimeSFTime":"2017-02-21 14:57:57","OvertimeSFJE":0,"CarparkNO":0,"BigSmall":0,"FreeReason":"","StayTime":"","StationID":5,"YHJE":0,"OnlineState_In":0,"OnlineState_Out":0,"PayType":0,"ID":123}]
     */

    /**
     * UserNO : A00009
     * UserName : 1111
     * DeptId : 0
     * DeptName :
     * ChineseName : 月租车A
     * StationName : 5
     * CarparkNOInStation : 0
     * PayTypeCaption : 现金
     * InID : 111
     * CardNO : 88000012
     * CPH : 粤TTTTTT
     * CardType : MthA
     * InTime : 2017-02-21 14:57:52
     * OutTime : 2017-02-21 14:57:56
     * InGateName : 入口车道21
     * OutGateName : 出口车道24
     * InOperatorCard : 888888
     * OutOperatorCard : 888888
     * InOperator : 管理员
     * OutOperator : 管理员
     * InPic : CaptureImage\5\20170221\7a9a2cb0-de2f-409d-854b-0266f73500bb20170221145752cin.jpg
     * InUser :
     * OutPic : CaptureImage\5\20170221\d3c01915-5ca5-447c-9272-c4ada464404c20170221145756cin.jpg
     * OutUser :
     * SFJE : 0.0
     * Balance : 0.0
     * YSJE : 0.0
     * SFTime : 2017-02-21 14:57:56
     * OvertimeSFTime : 2017-02-21 14:57:57
     * OvertimeSFJE : 0.0
     * CarparkNO : 0
     * BigSmall : 0
     * FreeReason :
     * StayTime :
     * StationID : 5
     * YHJE : 0.0
     * OnlineState_In : 0
     * OnlineState_Out : 0
     * PayType : 0
     * ID : 123
     */

    private String UserNO;
    private String UserName;
    private int DeptId;
    private String DeptName;
    private String ChineseName;
    private String StationName;
    private int CarparkNOInStation;
    private String PayTypeCaption;
    private int InID;
    private String CardNO;
    private String CPH;
    private String CardType;
    private String InTime;
    private String OutTime;
    private String InGateName;
    private String OutGateName;
    private String InOperatorCard;
    private String OutOperatorCard;
    private String InOperator;
    private String OutOperator;
    private String InPic;
    private String InUser;
    private String OutPic;
    private String OutUser;
    private double SFJE;
    private double Balance;
    private double YSJE;
    private String SFTime;
    private String OvertimeSFTime;
    private double OvertimeSFJE;
    private int CarparkNO;
    private int BigSmall;
    private String FreeReason;
    private String StayTime;
    private int StationID;
    private double YHJE;
    private int OnlineState_In;
    private int OnlineState_Out;
    private int PayType;
    private int ID;

    public String getUserNO()
    {
        return UserNO;
    }

    public void setUserNO(String UserNO)
    {
        this.UserNO = UserNO;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    public int getDeptId()
    {
        return DeptId;
    }

    public void setDeptId(int DeptId)
    {
        this.DeptId = DeptId;
    }

    public String getDeptName()
    {
        return DeptName;
    }

    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }

    public String getChineseName()
    {
        return ChineseName;
    }

    public void setChineseName(String ChineseName)
    {
        this.ChineseName = ChineseName;
    }

    public String getStationName()
    {
        return StationName;
    }

    public void setStationName(String StationName)
    {
        this.StationName = StationName;
    }

    public int getCarparkNOInStation()
    {
        return CarparkNOInStation;
    }

    public void setCarparkNOInStation(int CarparkNOInStation)
    {
        this.CarparkNOInStation = CarparkNOInStation;
    }

    public String getPayTypeCaption()
    {
        return PayTypeCaption;
    }

    public void setPayTypeCaption(String PayTypeCaption)
    {
        this.PayTypeCaption = PayTypeCaption;
    }

    public int getInID()
    {
        return InID;
    }

    public void setInID(int InID)
    {
        this.InID = InID;
    }

    public String getCardNO()
    {
        return CardNO;
    }

    public void setCardNO(String CardNO)
    {
        this.CardNO = CardNO;
    }

    public String getCPH()
    {
        return CPH;
    }

    public void setCPH(String CPH)
    {
        this.CPH = CPH;
    }

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String CardType)
    {
        this.CardType = CardType;
    }

    public String getInTime()
    {
        return InTime;
    }

    public void setInTime(String InTime)
    {
        this.InTime = InTime;
    }

    public String getOutTime()
    {
        return OutTime;
    }

    public void setOutTime(String OutTime)
    {
        this.OutTime = OutTime;
    }

    public String getInGateName()
    {
        return InGateName;
    }

    public void setInGateName(String InGateName)
    {
        this.InGateName = InGateName;
    }

    public String getOutGateName()
    {
        return OutGateName;
    }

    public void setOutGateName(String OutGateName)
    {
        this.OutGateName = OutGateName;
    }

    public String getInOperatorCard()
    {
        return InOperatorCard;
    }

    public void setInOperatorCard(String InOperatorCard)
    {
        this.InOperatorCard = InOperatorCard;
    }

    public String getOutOperatorCard()
    {
        return OutOperatorCard;
    }

    public void setOutOperatorCard(String OutOperatorCard)
    {
        this.OutOperatorCard = OutOperatorCard;
    }

    public String getInOperator()
    {
        return InOperator;
    }

    public void setInOperator(String InOperator)
    {
        this.InOperator = InOperator;
    }

    public String getOutOperator()
    {
        return OutOperator;
    }

    public void setOutOperator(String OutOperator)
    {
        this.OutOperator = OutOperator;
    }

    public String getInPic()
    {
        return InPic;
    }

    public void setInPic(String InPic)
    {
        this.InPic = InPic;
    }

    public String getInUser()
    {
        return InUser;
    }

    public void setInUser(String InUser)
    {
        this.InUser = InUser;
    }

    public String getOutPic()
    {
        return OutPic;
    }

    public void setOutPic(String OutPic)
    {
        this.OutPic = OutPic;
    }

    public String getOutUser()
    {
        return OutUser;
    }

    public void setOutUser(String OutUser)
    {
        this.OutUser = OutUser;
    }

    public double getSFJE()
    {
        return SFJE;
    }

    public void setSFJE(double SFJE)
    {
        this.SFJE = SFJE;
    }

    public double getBalance()
    {
        return Balance;
    }

    public void setBalance(double Balance)
    {
        this.Balance = Balance;
    }

    public double getYSJE()
    {
        return YSJE;
    }

    public void setYSJE(double YSJE)
    {
        this.YSJE = YSJE;
    }

    public String getSFTime()
    {
        return SFTime;
    }

    public void setSFTime(String SFTime)
    {
        this.SFTime = SFTime;
    }

    public String getOvertimeSFTime()
    {
        return OvertimeSFTime;
    }

    public void setOvertimeSFTime(String OvertimeSFTime)
    {
        this.OvertimeSFTime = OvertimeSFTime;
    }

    public double getOvertimeSFJE()
    {
        return OvertimeSFJE;
    }

    public void setOvertimeSFJE(double OvertimeSFJE)
    {
        this.OvertimeSFJE = OvertimeSFJE;
    }

    public int getCarparkNO()
    {
        return CarparkNO;
    }

    public void setCarparkNO(int CarparkNO)
    {
        this.CarparkNO = CarparkNO;
    }

    public int getBigSmall()
    {
        return BigSmall;
    }

    public void setBigSmall(int BigSmall)
    {
        this.BigSmall = BigSmall;
    }

    public String getFreeReason()
    {
        return FreeReason;
    }

    public void setFreeReason(String FreeReason)
    {
        this.FreeReason = FreeReason;
    }

    public String getStayTime()
    {
        return StayTime;
    }

    public void setStayTime(String StayTime)
    {
        this.StayTime = StayTime;
    }

    public int getStationID()
    {
        return StationID;
    }

    public void setStationID(int StationID)
    {
        this.StationID = StationID;
    }

    public double getYHJE()
    {
        return YHJE;
    }

    public void setYHJE(double YHJE)
    {
        this.YHJE = YHJE;
    }

    public int getOnlineState_In()
    {
        return OnlineState_In;
    }

    public void setOnlineState_In(int OnlineState_In)
    {
        this.OnlineState_In = OnlineState_In;
    }

    public int getOnlineState_Out()
    {
        return OnlineState_Out;
    }

    public void setOnlineState_Out(int OnlineState_Out)
    {
        this.OnlineState_Out = OnlineState_Out;
    }

    public int getPayType()
    {
        return PayType;
    }

    public void setPayType(int PayType)
    {
        this.PayType = PayType;
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
        return "EntityCarOut{" +
                "UserNO='" + UserNO + '\'' +
                ", UserName='" + UserName + '\'' +
                ", DeptId=" + DeptId +
                ", DeptName='" + DeptName + '\'' +
                ", ChineseName='" + ChineseName + '\'' +
                ", StationName='" + StationName + '\'' +
                ", CarparkNOInStation=" + CarparkNOInStation +
                ", PayTypeCaption='" + PayTypeCaption + '\'' +
                ", InID=" + InID +
                ", CardNO='" + CardNO + '\'' +
                ", CPH='" + CPH + '\'' +
                ", CardType='" + CardType + '\'' +
                ", InTime='" + InTime + '\'' +
                ", OutTime='" + OutTime + '\'' +
                ", InGateName='" + InGateName + '\'' +
                ", OutGateName='" + OutGateName + '\'' +
                ", InOperatorCard='" + InOperatorCard + '\'' +
                ", OutOperatorCard='" + OutOperatorCard + '\'' +
                ", InOperator='" + InOperator + '\'' +
                ", OutOperator='" + OutOperator + '\'' +
                ", InPic='" + InPic + '\'' +
                ", InUser='" + InUser + '\'' +
                ", OutPic='" + OutPic + '\'' +
                ", OutUser='" + OutUser + '\'' +
                ", SFJE=" + SFJE +
                ", Balance=" + Balance +
                ", YSJE=" + YSJE +
                ", SFTime='" + SFTime + '\'' +
                ", OvertimeSFTime='" + OvertimeSFTime + '\'' +
                ", OvertimeSFJE=" + OvertimeSFJE +
                ", CarparkNO=" + CarparkNO +
                ", BigSmall=" + BigSmall +
                ", FreeReason='" + FreeReason + '\'' +
                ", StayTime='" + StayTime + '\'' +
                ", StationID=" + StationID +
                ", YHJE=" + YHJE +
                ", OnlineState_In=" + OnlineState_In +
                ", OnlineState_Out=" + OnlineState_Out +
                ", PayType=" + PayType +
                ", ID=" + ID +
                '}';
    }
}
