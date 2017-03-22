package com.example.administrator.myparkingos.model.beans;

/**
 * Created by Administrator on 2017-03-14.
 */
public class BlackListOpt
{
    /// <summary>
    /// ID
    /// </summary>
    private int ID;

    private String CPH;

    /// <summary>
    /// StartTime
    /// </summary>
    private String StartTime;

    /// <summary>
    /// EndTime
    /// </summary>
    private String EndTime;

    /// <summary>
    /// Reason
    /// </summary>
    private String Reason;

    /// <summary>
    /// DownloadSignal
    /// </summary>
    private String DownloadSignal;

    /// <summary>
    /// AddDelete
    /// </summary>
    private int AddDelete;

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

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

    public void setStartTime(String startTime)
    {
        StartTime = startTime;
    }

    public String getEndTime()
    {
        return EndTime;
    }

    public void setEndTime(String endTime)
    {
        EndTime = endTime;
    }

    public String getReason()
    {
        return Reason;
    }

    public void setReason(String reason)
    {
        Reason = reason;
    }

    public String getDownloadSignal()
    {
        return DownloadSignal;
    }

    public void setDownloadSignal(String downloadSignal)
    {
        DownloadSignal = downloadSignal;
    }

    public int getAddDelete()
    {
        return AddDelete;
    }

    public void setAddDelete(int addDelete)
    {
        AddDelete = addDelete;
    }

    @Override
    public String toString()
    {
        return "BlackListOpt{" +
                "ID=" + ID +
                ", CPH='" + CPH + '\'' +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", Reason='" + Reason + '\'' +
                ", DownloadSignal='" + DownloadSignal + '\'' +
                ", AddDelete=" + AddDelete +
                '}';
    }
}
