package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-11.
 */
public class EntityNoPlateCarIn
{

    /**
     * rcode : 200
     * msg : OK
     * data : {"OpenMode":0,"CardNO":"35A9CB09","CardType":"TmpA","ImageName":"35A9CB09170311102844in16fa0f58-3fe6-417d-845b-41fa92368295.jpg","CPH":"","InTime":"2017-03-11 10:28:44"}
     */

    /**
     * OpenMode : 0
     * CardNO : 35A9CB09
     * CardType : TmpA
     * ImageName : 35A9CB09170311102844in16fa0f58-3fe6-417d-845b-41fa92368295.jpg
     * CPH :
     * InTime : 2017-03-11 10:28:44
     */

    private int OpenMode;
    private String CardNO;
    private String CardType;
    private String ImageName;
    private String CPH;
    private String InTime;

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

    @Override
    public String toString()
    {
        return "EntityNoPlateCarIn{" +
                "OpenMode=" + OpenMode +
                ", CardNO='" + CardNO + '\'' +
                ", CardType='" + CardType + '\'' +
                ", ImageName='" + ImageName + '\'' +
                ", CPH='" + CPH + '\'' +
                ", InTime='" + InTime + '\'' +
                '}';
    }
}
