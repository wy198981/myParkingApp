package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-02-28.
 */
public class EntityOperator
{
    /**
     * UserNO : 888888
     * UserName : 管理员
     */

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
        return "DataBean{" +
                "UserNO='" + UserNO + '\'' +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
