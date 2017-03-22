package com.example.testnetworkapi;

import java.util.List;

/**
 * Created by Administrator on 2017-02-18.
 */
public class RequestData<T>
{

    /**
     * rcode : 200
     * msg : OK
     * data : [{"UserNO":"888888","UserName":"管理员"},{"UserNO":"800001","UserName":"小李"},{"UserNO":"800002","UserName":"小王"},{"UserNO":"80055","UserName":"sss"},{"UserNO":"80052","UserName":"TTTT"},{"UserNO":"80067","UserName":"qq"}]
     */

    private String rcode;
    private String msg;
    // 这里定义泛型

    //    private List<DataBean> data;
    private List<T> data;

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

    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

//    public static class DataBean
//    {
//        /**
//         * UserNO : 888888
//         * UserName : 管理员
//         */
//
//        private String UserNO;
//        private String UserName;
//
//        public String getUserNO()
//        {
//            return UserNO;
//        }
//
//        public void setUserNO(String UserNO)
//        {
//            this.UserNO = UserNO;
//        }
//
//        public String getUserName()
//        {
//            return UserName;
//        }
//
//        public void setUserName(String UserName)
//        {
//            this.UserName = UserName;
//        }
//    }
}
