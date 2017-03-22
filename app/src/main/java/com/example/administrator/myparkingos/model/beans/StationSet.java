package com.example.administrator.myparkingos.model.beans;

/**
 * Created by Administrator on 2017-02-17.
 */
public class StationSet
{
    private long ID;
    private short StationId; // 工作站ID
    private String StationName;
    private int CarparkNO;

    public StationSet()
    {

    }


    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public short getStationId()
    {
        return StationId;
    }

    public void setStationId(short stationId)
    {
        StationId = stationId;
    }

    public String getStationName()
    {
        return StationName;
    }

    public void setStationName(String stationName)
    {
        StationName = stationName;
    }

    public int getCarparkNO()
    {
        return CarparkNO;
    }

    public void setCarparkNO(int carparkNO)
    {
        CarparkNO = carparkNO;
    }

    @Override
    public String toString()
    {
        return "StationSet{" +
                "ID=" + ID +
                ", StationId=" + StationId +
                ", StationName='" + StationName + '\'' +
                ", CarparkNO=" + CarparkNO +
                '}';
    }
}
