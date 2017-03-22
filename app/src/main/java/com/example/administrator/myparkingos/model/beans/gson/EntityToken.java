package com.example.administrator.myparkingos.model.beans.gson;

/**
 * Created by Administrator on 2017-02-28.
 */
public class EntityToken
{
    private String token;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    @Override
    public String toString()
    {
        return "EntityToken{" +
                "token='" + token + '\'' +
                '}';
    }
}
