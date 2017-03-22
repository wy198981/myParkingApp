package com.example.testnetworkapi.ui;

import java.util.List;

/**
 * Created by Administrator on 2017-02-28.
 */
public class EntityStationSet
{
    /**
     * StationId : 1
     * StationName : 1
     * CarparkNO : 5
     * ID : 12
     */

    private int StationId;
    private String StationName;
    private int CarparkNO;
    private int ID;

    public int getStationId()
    {
        return StationId;
    }

    public void setStationId(int StationId)
    {
        this.StationId = StationId;
    }

    public String getStationName()
    {
        return StationName;
    }

    public void setStationName(String StationName)
    {
        this.StationName = StationName;
    }

    public int getCarparkNO()
    {
        return CarparkNO;
    }

    public void setCarparkNO(int CarparkNO)
    {
        this.CarparkNO = CarparkNO;
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
        return "DataBean{" +
                "StationId=" + StationId +
                ", StationName='" + StationName + '\'' +
                ", CarparkNO=" + CarparkNO +
                ", ID=" + ID +
                '}';
    }
}
