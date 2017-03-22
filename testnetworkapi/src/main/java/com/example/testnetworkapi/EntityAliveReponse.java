package com.example.testnetworkapi;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityAliveReponse
{
    /**
     * rcode : 200
     * msg : OK
     * data: 30000
     */
    private int data;

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "EntityLogReponse{" +
                "data=" + data +
                '}';
    }
}
