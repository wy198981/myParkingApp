package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-09.
 */
public class ParkingInfo
{

    /**
     * rcode : 200
     * msg : OK
     * data : {"TotalDiscount":0,"TotalCharge":0,"ManualOpenCarCount":0,"TotalCarCountInPark":55,"MonthCarCountInPark":3,"TempCarCountInPark":52,"PrepaidCarCountInPark":0,"FreeCarCountInPark":0}
     */

    private String rcode;
    private String msg;
    private DataBean data;

    public String getRcode()
    {
        return rcode;
    }

    public void setRcode(String rcode)
    {
        this.rcode = rcode;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public DataBean getData()
    {
        return data;
    }

    public void setData(DataBean data)
    {
        this.data = data;
    }

    public static class DataBean
    {
        /**
         * TotalDiscount : 0.0
         * TotalCharge : 0.0
         * ManualOpenCarCount : 0
         * TotalCarCountInPark : 55
         * MonthCarCountInPark : 3
         * TempCarCountInPark : 52
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
    }
}
