package com.example.testnetworkapi.ui;

import java.util.List;

/**
 * Created by Administrator on 2017-03-01.
 */
public class EntityOperatorDetail
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"DeptName":"管理部","GroupName":"管理员组","CardNO":"888888","CardType":"操作卡","UserNO":"888888","UserName":"管理员","DeptId":1,"CardState":0,"UserLevel":1,"ID":1}]
     */

    /**
     * DeptName : 管理部
     * GroupName : 管理员组
     * CardNO : 888888
     * CardType : 操作卡
     * UserNO : 888888
     * UserName : 管理员
     * DeptId : 1
     * CardState : 0
     * UserLevel : 1
     * ID : 1
     */

    private String DeptName;
    private String GroupName;
    private String CardNO;
    private String CardType;
    private String UserNO;
    private String UserName;
    private int DeptId;
    private int CardState;
    private int UserLevel;
    private int ID;

    public String getDeptName()
    {
        return DeptName;
    }

    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }

    public String getGroupName()
    {
        return GroupName;
    }

    public void setGroupName(String GroupName)
    {
        this.GroupName = GroupName;
    }

    public String getCardNO()
    {
        return CardNO;
    }

    public void setCardNO(String CardNO)
    {
        this.CardNO = CardNO;
    }

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String CardType)
    {
        this.CardType = CardType;
    }

    public String getUserNO()
    {
        return UserNO;
    }

    public void setUserNO(String UserNO)
    {
        this.UserNO = UserNO;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    public int getDeptId()
    {
        return DeptId;
    }

    public void setDeptId(int DeptId)
    {
        this.DeptId = DeptId;
    }

    public int getCardState()
    {
        return CardState;
    }

    public void setCardState(int CardState)
    {
        this.CardState = CardState;
    }

    public int getUserLevel()
    {
        return UserLevel;
    }

    public void setUserLevel(int UserLevel)
    {
        this.UserLevel = UserLevel;
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
        return "EntityOperatorDetail{" +
                "DeptName='" + DeptName + '\'' +
                ", GroupName='" + GroupName + '\'' +
                ", CardNO='" + CardNO + '\'' +
                ", CardType='" + CardType + '\'' +
                ", UserNO='" + UserNO + '\'' +
                ", UserName='" + UserName + '\'' +
                ", DeptId=" + DeptId +
                ", CardState=" + CardState +
                ", UserLevel=" + UserLevel +
                ", ID=" + ID +
                '}';
    }
}
