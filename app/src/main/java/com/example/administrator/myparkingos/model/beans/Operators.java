package com.example.administrator.myparkingos.model.beans;

/**
 * Created by Administrator on 2017-02-17.
 * 表示操作员，其人员姓名在登录界面会使用到；
 */
public class Operators
{
    /**
     * 1), ID
     */
    private int ID;

    /**
     * 2), 卡号
     */
    private String CardNo;
    /**
     * 3), 卡类
     */
    private String CardType;

    /**
     * 4)，人员编号
     */
    private String UserNo;

    /**
     * 5)，人员姓名
     */
    private String UserName;

    /**
     * 6),部门
     */
    private String DeptName;
    /**
     *  7),密码
     */
    private String Pwd;

    /**
     * 8), 卡状态
     */
    private int CardState;

    /**
     * 9), 权限组
     */
    private int UserLevel;

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getCardNo()
    {
        return CardNo;
    }

    public void setCardNo(String cardNo)
    {
        CardNo = cardNo;
    }

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String cardType)
    {
        CardType = cardType;
    }

    public String getUserNo()
    {
        return UserNo;
    }

    public void setUserNo(String userNo)
    {
        UserNo = userNo;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String userName)
    {
        UserName = userName;
    }

    public String getDeptName()
    {
        return DeptName;
    }

    public void setDeptName(String deptName)
    {
        DeptName = deptName;
    }

    public String getPwd()
    {
        return Pwd;
    }

    public void setPwd(String pwd)
    {
        Pwd = pwd;
    }

    public int getCardState()
    {
        return CardState;
    }

    public void setCardState(int cardState)
    {
        CardState = cardState;
    }

    public int getUserLevel()
    {
        return UserLevel;
    }

    public void setUserLevel(int userLevel)
    {
        UserLevel = userLevel;
    }
}
