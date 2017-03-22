package com.example.administrator.myparkingos.model;

import com.google.gson.Gson;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017-02-18.
 */
public class CommonJsonList<T> implements Serializable
{
    private static final long serialVersionUID = -369558847578246550L;

    //    {“rcode”:”40000”,”msg”:”token已经失效,请重新获取”,”data”:null} json的返回数据
    private String rcode;
    private String msg;

    /**
     * 数据
     */
    private List<T> data;


    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getRcode()
    {
        return rcode;
    }

    public void setRcode(String rcode)
    {
        this.rcode = rcode;
    }


    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

    public static CommonJsonList fromJson(String json, Class clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJsonList.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJsonList.class, clazz);
        return gson.toJson(this, objectType);
    }

    static ParameterizedType type(final Class raw, final Type... args)
    {
        return new ParameterizedType()
        {
            public Type getRawType()
            {
                return raw;
            }

            public Type[] getActualTypeArguments()
            {
                return args;
            }

            public Type getOwnerType()
            {
                return null;
            }
        };
    }
}
