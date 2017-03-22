package com.example.administrator.myparkingos.model;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017-02-28.
 */
public class CommonJson<T>
{

    /**
     * rcode : 200
     * msg : 获取Token成功
     * data : {"token":"05f9e0ba26254b529625da8c424cb089"}
     */


    private String rcode;
    private String msg;
    private T data;

    public String getRcode()
    {
        return rcode;
    }

    public void setRcode(String rcode)
    {
        this.rcode = rcode;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T t)
    {
        this.data = t;
    }

    public static CommonJson fromJson(String json, Class clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJson.class, clazz);
        return gson.fromJson(json, objectType);
    }

    public String toJson(Class<T> clazz)
    {
        Gson gson = new Gson();
        Type objectType = type(CommonJson.class, clazz);
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
