package com.example.testnetworkapi.ui;

import java.util.List;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityCarTypeInfo
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"CardType":"临时车A","Identifying":"TmpA","Enabled":true,"Remarks":"TempA","ID":9},{"CardType":"临时车B","Identifying":"TmpB","Enabled":true,"Remarks":"TempB","ID":10}]
     */
    /**
     * CardType : 临时车A
     * Identifying : TmpA
     * Enabled : true
     * Remarks : TempA
     * ID : 9
     */

    private String CardType;
    private String Identifying;
    private boolean Enabled;
    private String Remarks;
    private int ID;

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String CardType)
    {
        this.CardType = CardType;
    }

    public String getIdentifying()
    {
        return Identifying;
    }

    public void setIdentifying(String Identifying)
    {
        this.Identifying = Identifying;
    }

    public boolean isEnabled()
    {
        return Enabled;
    }

    public void setEnabled(boolean Enabled)
    {
        this.Enabled = Enabled;
    }

    public String getRemarks()
    {
        return Remarks;
    }

    public void setRemarks(String Remarks)
    {
        this.Remarks = Remarks;
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
        return "EntityCarTypeInfo{" +
                "CardType='" + CardType + '\'' +
                ", Identifying='" + Identifying + '\'' +
                ", Enabled=" + Enabled +
                ", Remarks='" + Remarks + '\'' +
                ", ID=" + ID +
                '}';
    }
}
