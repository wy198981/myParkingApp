package com.example.administrator.myparkingos.model.beans.gson;

import java.util.List;

/**
 * Created by Administrator on 2017-03-14.
 */
public class EntityBlackList
{
    public EntityBlackList(String CPH)
    {
    }
    /**
     * rcode : 200
     * msg : OK
     * data : [{"CPH":"粤HHHHHH","StartTime":"2017-03-08 00:00:00","EndTime":"2017-03-08 23:59:59","Reason":"xiaoming","DownloadSignal":"000001000000000","AddDelete":0,"ID":16},{"CPH":"粤SS4567","StartTime":"2017-03-10 00:00:00","EndTime":"2017-03-10 23:59:59","Reason":"ss","DownloadSignal":"000001000000000","AddDelete":0,"ID":17}]
     */
    public EntityBlackList(String CPH, String startTime, String endTime, String reason, int addDelete)
    {
        this.CPH = CPH;
        this.StartTime = startTime;
        this.EndTime = endTime;
        this.Reason = reason;
        this.AddDelete = addDelete;
    }

    /**
     * CPH : 粤HHHHHH
     * StartTime : 2017-03-08 00:00:00
     * EndTime : 2017-03-08 23:59:59
     * Reason : xiaoming
     * DownloadSignal : 000001000000000
     * AddDelete : 0
     * ID : 16
     */


    private String CPH;
    private String StartTime;
    private String EndTime;
    private String Reason;
    private String DownloadSignal;
    private int AddDelete;
    private int ID;

    public String getCPH()
    {
        return CPH;
    }

    public void setCPH(String CPH)
    {
        this.CPH = CPH;
    }

    public String getStartTime()
    {
        return StartTime;
    }

    public void setStartTime(String StartTime)
    {
        this.StartTime = StartTime;
    }

    public String getEndTime()
    {
        return EndTime;
    }

    public void setEndTime(String EndTime)
    {
        this.EndTime = EndTime;
    }

    public String getReason()
    {
        return Reason;
    }

    public void setReason(String Reason)
    {
        this.Reason = Reason;
    }

    public String getDownloadSignal()
    {
        return DownloadSignal;
    }

    public void setDownloadSignal(String DownloadSignal)
    {
        this.DownloadSignal = DownloadSignal;
    }

    public int getAddDelete()
    {
        return AddDelete;
    }

    public void setAddDelete(int AddDelete)
    {
        this.AddDelete = AddDelete;
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
        return "EntityBlackList{" +
                "CPH='" + CPH + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", Reason='" + Reason + '\'' +
                ", DownloadSignal='" + DownloadSignal + '\'' +
                ", AddDelete=" + AddDelete +
                ", ID=" + ID +
                '}';
    }
}
