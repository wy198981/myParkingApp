package com.example.administrator.myparkingos.model;

/**
 * Created by Administrator on 2017-02-20.
 */
public class Rights
{

    /// <summary>
    /// 自增主键
    /// </summary>
    private long ID;

    /// <summary>
    /// 权限组编号
    /// </summary>
    private long GroupID;

    /// <summary>
    /// 权限项目ID
    /// </summary>
    private long RightsItemID;

    /// <summary>
    /// CanView
    /// </summary>
    private boolean CanView;

    /// <summary>
    /// CanOperate
    /// </summary>
    private boolean CanOperate;

    public long PID;

    public String Category;

    public String FormName;

    public String ItemName;

    public String GroupName;

    public String Description;

    public String Orders;

    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public long getGroupID()
    {
        return GroupID;
    }

    public void setGroupID(long groupID)
    {
        GroupID = groupID;
    }

    public long getRightsItemID()
    {
        return RightsItemID;
    }

    public void setRightsItemID(long rightsItemID)
    {
        RightsItemID = rightsItemID;
    }

    public boolean isCanView()
    {
        return CanView;
    }

    public void setCanView(boolean canView)
    {
        CanView = canView;
    }

    public boolean isCanOperate()
    {
        return CanOperate;
    }

    public void setCanOperate(boolean canOperate)
    {
        CanOperate = canOperate;
    }

    @Override
    public String toString()
    {
        return "Rights{" +
                "ID=" + ID +
                ", GroupID=" + GroupID +
                ", RightsItemID=" + RightsItemID +
                ", CanView=" + CanView +
                ", CanOperate=" + CanOperate +
                ", PID=" + PID +
                ", Category='" + Category + '\'' +
                ", FormName='" + FormName + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", GroupName='" + GroupName + '\'' +
                ", Description='" + Description + '\'' +
                ", Orders='" + Orders + '\'' +
                '}';
    }
}
