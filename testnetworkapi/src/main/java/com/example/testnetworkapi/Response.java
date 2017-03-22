package com.example.testnetworkapi;

/**
 * Created by Administrator on 2017-02-18.
 */
public class Response
{
    private Object data;
    private String msg;
    private String rcode;

    public Response()
    {

    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

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

    @Override
    public String toString()
    {
        return "Response{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", rcode='" + rcode + '\'' +
                '}';
    }
}
