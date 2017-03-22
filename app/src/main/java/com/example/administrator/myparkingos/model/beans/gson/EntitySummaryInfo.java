package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-03-10.
 */
public class EntitySummaryInfo
{

    /**
     * rcode : 200
     * msg : OK
     * data : {"MthCount":6,"MtpCount":0,"TmpCount":27,"TfrCount":0,"StrCount":0,"OptCount":0,"FreCount":1,"TotalCount":34}
     */

    /**
     * MthCount : 6
     * MtpCount : 0
     * TmpCount : 27
     * TfrCount : 0
     * StrCount : 0
     * OptCount : 0
     * FreCount : 1
     * TotalCount : 34
     */

    private int MthCount;
    private int MtpCount;
    private int TmpCount;
    private int TfrCount;
    private int StrCount;
    private int OptCount;
    private int FreCount;
    private int TotalCount;

    public int getMthCount()
    {
        return MthCount;
    }

    public void setMthCount(int MthCount)
    {
        this.MthCount = MthCount;
    }

    public int getMtpCount()
    {
        return MtpCount;
    }

    public void setMtpCount(int MtpCount)
    {
        this.MtpCount = MtpCount;
    }

    public int getTmpCount()
    {
        return TmpCount;
    }

    public void setTmpCount(int TmpCount)
    {
        this.TmpCount = TmpCount;
    }

    public int getTfrCount()
    {
        return TfrCount;
    }

    public void setTfrCount(int TfrCount)
    {
        this.TfrCount = TfrCount;
    }

    public int getStrCount()
    {
        return StrCount;
    }

    public void setStrCount(int StrCount)
    {
        this.StrCount = StrCount;
    }

    public int getOptCount()
    {
        return OptCount;
    }

    public void setOptCount(int OptCount)
    {
        this.OptCount = OptCount;
    }

    public int getFreCount()
    {
        return FreCount;
    }

    public void setFreCount(int FreCount)
    {
        this.FreCount = FreCount;
    }

    public int getTotalCount()
    {
        return TotalCount;
    }

    public void setTotalCount(int TotalCount)
    {
        this.TotalCount = TotalCount;
    }

    @Override
    public String toString()
    {
        return "EntitySummaryInfo{" +
                "MthCount=" + MthCount +
                ", MtpCount=" + MtpCount +
                ", TmpCount=" + TmpCount +
                ", TfrCount=" + TfrCount +
                ", StrCount=" + StrCount +
                ", OptCount=" + OptCount +
                ", FreCount=" + FreCount +
                ", TotalCount=" + TotalCount +
                '}';
    }
}
