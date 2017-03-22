package com.example.administrator.myparkingos.model.beans.gson;

import java.util.List;

/**
 * Created by Administrator on 2017-03-17.
 */
public class EntityParkJHSet
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"CtrlNumber":1,"Location":"1","ID":1},{"CtrlNumber":2,"Location":"2","ID":2},{"CtrlNumber":3,"Location":"3","ID":3},{"CtrlNumber":4,"Location":"4","ID":4},{"CtrlNumber":5,"Location":"5","ID":31},{"CtrlNumber":6,"Location":"6","ID":32},{"CtrlNumber":7,"Location":"7","ID":7},{"CtrlNumber":8,"Location":"8","ID":8},{"CtrlNumber":9,"Location":"9","ID":9},{"CtrlNumber":10,"Location":"10","ID":10},{"CtrlNumber":11,"Location":"11","ID":11},{"CtrlNumber":12,"Location":"12","ID":12},{"CtrlNumber":13,"Location":"13","ID":13},{"CtrlNumber":14,"Location":"14","ID":14},{"CtrlNumber":15,"Location":"15","ID":15},{"CtrlNumber":16,"Location":"16","ID":16},{"CtrlNumber":17,"Location":"17","ID":17},{"CtrlNumber":18,"Location":"18","ID":18},{"CtrlNumber":19,"Location":"19","ID":19},{"CtrlNumber":20,"Location":"20","ID":20},{"CtrlNumber":21,"Location":"21","ID":21},{"CtrlNumber":22,"Location":"22","ID":22},{"CtrlNumber":23,"Location":"23","ID":23},{"CtrlNumber":24,"Location":"24","ID":24},{"CtrlNumber":25,"Location":"25","ID":25},{"CtrlNumber":26,"Location":"26","ID":26},{"CtrlNumber":27,"Location":"27","ID":27},{"CtrlNumber":28,"Location":"28","ID":28},{"CtrlNumber":29,"Location":"29","ID":29},{"CtrlNumber":30,"Location":"30","ID":30},{"CtrlNumber":127,"Location":"127","ID":45}]
     */

    /**
     * CtrlNumber : 1
     * Location : 1
     * ID : 1
     */

    private int CtrlNumber;
    private String Location;
    private int ID;

    public int getCtrlNumber()
    {
        return CtrlNumber;
    }

    public void setCtrlNumber(int CtrlNumber)
    {
        this.CtrlNumber = CtrlNumber;
    }

    public String getLocation()
    {
        return Location;
    }

    public void setLocation(String Location)
    {
        this.Location = Location;
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
        return "EntityParkJHSet{" +
                "CtrlNumber=" + CtrlNumber +
                ", Location='" + Location + '\'' +
                ", ID=" + ID +
                '}';
    }
}
