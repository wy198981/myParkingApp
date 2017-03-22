package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-04.
 */
public class EntitySetCarIn
{

    /**
     * rcode : -3
     * msg : 重复入场
     * data : {"OpenMode":0,"CardNO":"35A88143","CardType":"TmpA","ImageName":"35A88143170311102844in920b64a7-d07a-400d-b3cf-2a9d11707f25.jpg","CPH":"?b55555","InTime":"2017-03-11 10:28:44","UserNO":null,"UserName":null,"DeptName":null,"Balance":0,"CarValidEndDate":null,"CarPlace":null,"RemainingDays":null}
     */
    /**
     * OpenMode : 0
     * CardNO : 35A88143
     * CardType : TmpA
     * ImageName : 35A88143170311102844in920b64a7-d07a-400d-b3cf-2a9d11707f25.jpg
     * CPH : ?b55555
     * InTime : 2017-03-11 10:28:44
     * UserNO : null
     * UserName : null
     * DeptName : null
     * Balance : 0.0
     * CarValidEndDate : null
     * CarPlace : null
     * RemainingDays : null
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

    @Override
    public String toString()
    {
        return "EntitySetCarIn{" +
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
                '}';
    }
}
