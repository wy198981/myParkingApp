package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-11.
 */
public class EntitySetCarOut
{

    /**
     * rcode : 200
     * msg : OK
     * data : {"OpenMode":1,"CardNO":"35A88143","CardType":"TmpA","ImageName":"35A88143170311104518out34937322-5460-44e9-a0bb-6d00fbca2503.jpg","CPH":"?b55555","InTime":"2017-03-11 10:45:18","UserNO":null,"UserName":null,"DeptName":null,"Balance":0,"CarValidEndDate":null,"CarPlace":null,"RemainingDays":null,"OutTime":"2017-03-11 10:45:18","StayTime":"","SFJE":0,"YSJE":0,"DiscountSet":null}
     */

    /**
     * OpenMode : 1
     * CardNO : 35A88143
     * CardType : TmpA
     * ImageName : 35A88143170311104518out34937322-5460-44e9-a0bb-6d00fbca2503.jpg
     * CPH : ?b55555
     * InTime : 2017-03-11 10:45:18
     * UserNO : null
     * UserName : null
     * DeptName : null
     * Balance : 0.0
     * CarValidEndDate : null
     * CarPlace : null
     * RemainingDays : null
     * OutTime : 2017-03-11 10:45:18
     * StayTime :
     * SFJE : 0.0
     * YSJE : 0.0
     * DiscountSet : null
     */

    private int OpenMode;
    private String CardNO;
    private String CardType;
    private String ImageName;
    private String CPH;
    private String InTime;
    private String UserNO;
    private String UserName;
    private String DeptName;
    private double Balance;
    private String CarValidEndDate;
    private String CarPlace;
    private String RemainingDays;
    private String OutTime;
    private String StayTime;
    private double SFJE;
    private double YSJE;
    private String DiscountSet;

    public int getOpenMode()
    {
        return OpenMode;
    }

    public void setOpenMode(int OpenMode)
    {
        this.OpenMode = OpenMode;
    }

    public String getCardNO()
    {
        return CardNO;
    }

    public void setCardNO(String CardNO)
    {
        this.CardNO = CardNO;
    }

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String CardType)
    {
        this.CardType = CardType;
    }

    public String getImageName()
    {
        return ImageName;
    }

    public void setImageName(String ImageName)
    {
        this.ImageName = ImageName;
    }

    public String getCPH()
    {
        return CPH;
    }

    public void setCPH(String CPH)
    {
        this.CPH = CPH;
    }

    public String getInTime()
    {
        return InTime;
    }

    public void setInTime(String InTime)
    {
        this.InTime = InTime;
    }

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

    public String getDeptName()
    {
        return DeptName;
    }

    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }

    public double getBalance()
    {
        return Balance;
    }

    public void setBalance(double Balance)
    {
        this.Balance = Balance;
    }

    public String getCarValidEndDate()
    {
        return CarValidEndDate;
    }

    public void setCarValidEndDate(String CarValidEndDate)
    {
        this.CarValidEndDate = CarValidEndDate;
    }

    public String getCarPlace()
    {
        return CarPlace;
    }

    public void setCarPlace(String CarPlace)
    {
        this.CarPlace = CarPlace;
    }

    public String getRemainingDays()
    {
        return RemainingDays;
    }

    public void setRemainingDays(String RemainingDays)
    {
        this.RemainingDays = RemainingDays;
    }

    public String getOutTime()
    {
        return OutTime;
    }

    public void setOutTime(String OutTime)
    {
        this.OutTime = OutTime;
    }

    public String getStayTime()
    {
        return StayTime;
    }

    public void setStayTime(String StayTime)
    {
        this.StayTime = StayTime;
    }

    public double getSFJE()
    {
        return SFJE;
    }

    public void setSFJE(double SFJE)
    {
        this.SFJE = SFJE;
    }

    public double getYSJE()
    {
        return YSJE;
    }

    public void setYSJE(double YSJE)
    {
        this.YSJE = YSJE;
    }

    public String getDiscountSet()
    {
        return DiscountSet;
    }

    public void setDiscountSet(String DiscountSet)
    {
        this.DiscountSet = DiscountSet;
    }

    @Override
    public String toString()
    {
        return "EntitySetCarOut{" +
                "OpenMode=" + OpenMode +
                ", CardNO='" + CardNO + '\'' +
                ", CardType='" + CardType + '\'' +
                ", ImageName='" + ImageName + '\'' +
                ", CPH='" + CPH + '\'' +
                ", InTime='" + InTime + '\'' +
                ", UserNO=" + UserNO +
                ", UserName=" + UserName +
                ", DeptName=" + DeptName +
                ", Balance=" + Balance +
                ", CarValidEndDate=" + CarValidEndDate +
                ", CarPlace=" + CarPlace +
                ", RemainingDays=" + RemainingDays +
                ", OutTime='" + OutTime + '\'' +
                ", StayTime='" + StayTime + '\'' +
                ", SFJE=" + SFJE +
                ", YSJE=" + YSJE +
                ", DiscountSet=" + DiscountSet +
                '}';
    }
}
