package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-14.
 */
public class EntitySetCarOutNoCPH
{

    /**
     * rcode : 200
     * msg : OK
     * data : {"OpenMode":1,"CardNO":"372B3549","CardType":"TmpA","ImageName":"372B3549170314105121out6928ddf8-9dd0-4f8c-a58a-e2af1744f598.jpg","CPH":"","InTime":"2017-03-14 10:51:21","UserNO":null,"UserName":null,"DeptName":null,"Balance":0,"CarValidEndDate":null,"CarPlace":null,"OutTime":"2017-03-14 10:51:21","StayTime":"","SFJE":0,"YSJE":0,"DiscountSet":null}
     */

    /**
     * OpenMode : 1
     * CardNO : 372B3549
     * CardType : TmpA
     * ImageName : 372B3549170314105121out6928ddf8-9dd0-4f8c-a58a-e2af1744f598.jpg
     * CPH :
     * InTime : 2017-03-14 10:51:21
     * UserNO : null
     * UserName : null
     * DeptName : null
     * Balance : 0.0
     * CarValidEndDate : null
     * CarPlace : null
     * OutTime : 2017-03-14 10:51:21
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
    private Object UserNO;
    private Object UserName;
    private Object DeptName;
    private double Balance;
    private Object CarValidEndDate;
    private Object CarPlace;
    private String OutTime;
    private String StayTime;
    private double SFJE;
    private double YSJE;
    private Object DiscountSet;

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

    public Object getUserNO()
    {
        return UserNO;
    }

    public void setUserNO(Object UserNO)
    {
        this.UserNO = UserNO;
    }

    public Object getUserName()
    {
        return UserName;
    }

    public void setUserName(Object UserName)
    {
        this.UserName = UserName;
    }

    public Object getDeptName()
    {
        return DeptName;
    }

    public void setDeptName(Object DeptName)
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

    public Object getCarValidEndDate()
    {
        return CarValidEndDate;
    }

    public void setCarValidEndDate(Object CarValidEndDate)
    {
        this.CarValidEndDate = CarValidEndDate;
    }

    public Object getCarPlace()
    {
        return CarPlace;
    }

    public void setCarPlace(Object CarPlace)
    {
        this.CarPlace = CarPlace;
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

    public Object getDiscountSet()
    {
        return DiscountSet;
    }

    public void setDiscountSet(Object DiscountSet)
    {
        this.DiscountSet = DiscountSet;
    }

    @Override
    public String toString()
    {
        return "EntitySetCarOutNoCPH{" +
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
                ", OutTime='" + OutTime + '\'' +
                ", StayTime='" + StayTime + '\'' +
                ", SFJE=" + SFJE +
                ", YSJE=" + YSJE +
                ", DiscountSet=" + DiscountSet +
                '}';
    }
}
