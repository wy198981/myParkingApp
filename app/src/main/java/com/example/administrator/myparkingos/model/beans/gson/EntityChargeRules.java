package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityChargeRules
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"Enabled":true,"Remarks":"TempA","ChineseName":"临时车A","ParkID":0,"CardType":"TmpA","FreeMinute":0,"TopSF":24,"Hours":30,"JE":1,"ID":823},{"Enabled":true,"Remarks":"TempA","ChineseName":"临时车A","ParkID":0,"CardType":"TmpA","FreeMinute":0,"TopSF":24,"Hours":40,"JE":3,"ID":824}]
     */
    /**
     * Enabled : true
     * Remarks : TempA
     * ChineseName : 临时车A
     * ParkID : 0
     * CardType : TmpA
     * FreeMinute : 0
     * TopSF : 24
     * Hours : 30
     * JE : 1.0
     * ID : 823
     */

    private boolean Enabled;
    private String Remarks;
    private String ChineseName;
    private int ParkID;
    private String CardType;
    private int FreeMinute;
    private int TopSF;
    private int Hours;
    private double JE;
    private int ID;

    public boolean isEnabled()
    {
        return Enabled;
    }

    public void setEnabled(boolean Enabled)
    {
        this.Enabled = Enabled;
    }

    public String getRemarks()
    {
        return Remarks;
    }

    public void setRemarks(String Remarks)
    {
        this.Remarks = Remarks;
    }

    public String getChineseName()
    {
        return ChineseName;
    }

    public void setChineseName(String ChineseName)
    {
        this.ChineseName = ChineseName;
    }

    public int getParkID()
    {
        return ParkID;
    }

    public void setParkID(int ParkID)
    {
        this.ParkID = ParkID;
    }

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String CardType)
    {
        this.CardType = CardType;
    }

    public int getFreeMinute()
    {
        return FreeMinute;
    }

    public void setFreeMinute(int FreeMinute)
    {
        this.FreeMinute = FreeMinute;
    }

    public int getTopSF()
    {
        return TopSF;
    }

    public void setTopSF(int TopSF)
    {
        this.TopSF = TopSF;
    }

    public int getHours()
    {
        return Hours;
    }

    public void setHours(int Hours)
    {
        this.Hours = Hours;
    }

    public double getJE()
    {
        return JE;
    }

    public void setJE(double JE)
    {
        this.JE = JE;
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
        return "EntityChargeRules{" +
                "Enabled=" + Enabled +
                ", Remarks='" + Remarks + '\'' +
                ", ChineseName='" + ChineseName + '\'' +
                ", ParkID=" + ParkID +
                ", CardType='" + CardType + '\'' +
                ", FreeMinute=" + FreeMinute +
                ", TopSF=" + TopSF +
                ", Hours=" + Hours +
                ", JE=" + JE +
                ", ID=" + ID +
                '}';
    }
}
