package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-02-28.
 */
public class EntitySystemTime
{
    private String serverTime;

    public String getServerTime()
    {
        return serverTime;
    }

    public void setServerTime(String serverTime)
    {
        this.serverTime = serverTime;
    }

    @Override
    public String toString()
    {
        return "EntitySystemTime{" +
                "serverTime='" + serverTime + '\'' +
                '}';
    }
}
