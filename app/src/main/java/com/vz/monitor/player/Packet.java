package com.vz.monitor.player;

import java.util.Vector;

public class Packet
{
    private int amount;
    private Vector<Integer> positionList;

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public Vector<Integer> getPositionList()
    {
        return positionList;
    }

    public void setPositionList(Vector<Integer> positionList)
    {
        this.positionList = positionList;
    }
}
