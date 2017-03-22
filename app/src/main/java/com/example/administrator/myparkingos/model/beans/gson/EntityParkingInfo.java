package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityParkingInfo
{

    /**
     * rcode : 200
     * msg : OK
     * data : {"TotalDiscount":0,"TotalCharge":0,"ManualOpenCarCount":0,"TotalCarCountInPark":16,"MonthCarCountInPark":3,"TempCarCountInPark":13,"PrepaidCarCountInPark":0,"FreeCarCountInPark":0}
     */

    /**
     * TotalDiscount : 0.0
     * TotalCharge : 0.0
     * ManualOpenCarCount : 0
     * TotalCarCountInPark : 16
     * MonthCarCountInPark : 3
     * TempCarCountInPark : 13
     * PrepaidCarCountInPark : 0
     * FreeCarCountInPark : 0
     */

    private double TotalDiscount;
    private double TotalCharge;
    private int ManualOpenCarCount;
    private int TotalCarCountInPark;
    private int MonthCarCountInPark;
    private int TempCarCountInPark;
    private int PrepaidCarCountInPark;
    private int FreeCarCountInPark;

    public double getTotalDiscount()
    {
        return TotalDiscount;
    }

    public void setTotalDiscount(double TotalDiscount)
    {
        this.TotalDiscount = TotalDiscount;
    }

    public double getTotalCharge()
    {
        return TotalCharge;
    }

    public void setTotalCharge(double TotalCharge)
    {
        this.TotalCharge = TotalCharge;
    }

    public int getManualOpenCarCount()
    {
        return ManualOpenCarCount;
    }

    public void setManualOpenCarCount(int ManualOpenCarCount)
    {
        this.ManualOpenCarCount = ManualOpenCarCount;
    }

    public int getTotalCarCountInPark()
    {
        return TotalCarCountInPark;
    }

    public void setTotalCarCountInPark(int TotalCarCountInPark)
    {
        this.TotalCarCountInPark = TotalCarCountInPark;
    }

    public int getMonthCarCountInPark()
    {
        return MonthCarCountInPark;
    }

    public void setMonthCarCountInPark(int MonthCarCountInPark)
    {
        this.MonthCarCountInPark = MonthCarCountInPark;
    }

    public int getTempCarCountInPark()
    {
        return TempCarCountInPark;
    }

    public void setTempCarCountInPark(int TempCarCountInPark)
    {
        this.TempCarCountInPark = TempCarCountInPark;
    }

    public int getPrepaidCarCountInPark()
    {
        return PrepaidCarCountInPark;
    }

    public void setPrepaidCarCountInPark(int PrepaidCarCountInPark)
    {
        this.PrepaidCarCountInPark = PrepaidCarCountInPark;
    }

    public int getFreeCarCountInPark()
    {
        return FreeCarCountInPark;
    }

    public void setFreeCarCountInPark(int FreeCarCountInPark)
    {
        this.FreeCarCountInPark = FreeCarCountInPark;
    }

    @Override
    public String toString()
    {
        return "EntityParkingInfo{" +
                "TotalDiscount=" + TotalDiscount +
                ", TotalCharge=" + TotalCharge +
                ", ManualOpenCarCount=" + ManualOpenCarCount +
                ", TotalCarCountInPark=" + TotalCarCountInPark +
                ", MonthCarCountInPark=" + MonthCarCountInPark +
                ", TempCarCountInPark=" + TempCarCountInPark +
                ", PrepaidCarCountInPark=" + PrepaidCarCountInPark +
                ", FreeCarCountInPark=" + FreeCarCountInPark +
                '}';
    }
}
