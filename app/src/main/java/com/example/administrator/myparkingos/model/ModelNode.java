package com.example.administrator.myparkingos.model;

/**
 * Created by Administrator on 2017-03-09.
 */
public class ModelNode
{
    public int iDzIndex;
    public String sDzScan;
    public String strFile;
    public String strFileJpg;
    public String strCPH;

    public ModelNode(int iDzIndex, String sDzScan, String strFile, String strFileJpg, String strCPH)
    {
        this.iDzIndex = iDzIndex;
        this.sDzScan = sDzScan;
        this.strFile = strFile;
        this.strFileJpg = strFileJpg;
        this.strCPH = strCPH;
    }

    @Override
    public String toString()
    {
        return "ModelNode{" +
                "iDzIndex=" + iDzIndex +
                ", sDzScan='" + sDzScan + '\'' +
                ", strFile='" + strFile + '\'' +
                ", strFileJpg='" + strFileJpg + '\'' +
                ", strCPH='" + strCPH + '\'' +
                '}';
    }
}
