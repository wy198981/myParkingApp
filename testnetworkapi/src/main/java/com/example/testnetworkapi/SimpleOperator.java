package com.example.testnetworkapi;

/**
 * Created by Administrator on 2017-02-18.
 */
public class SimpleOperator
{
    /**
     * UserNO : 888888
     * UserName : 管理员
     */

    public SimpleOperator()
    {

    }

    private String UserNO;
    private String UserName;

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

    @Override
    public String toString()
    {
        return "SimpleOperator{" +
                "UserNO='" + UserNO + '\'' +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}

