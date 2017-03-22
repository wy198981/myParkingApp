package com.example.testnetworkapi;

import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017-02-17.
 */
public class Request
{
    private final String TAG = "Request";

    private String address = "";
    private Gson mGson = new Gson();

    public Request()
    {
        address = "http://" + Model.serverIP + ":" + Model.serverPort + "/";
    }

    public String[] errInfoList = new String[]{
            ("token已经失效,请重新获取"), // 40000
            ("未知异常,请联系管理员查看异常日志"), // 40001
            ("输入参数缺失或错误"), // 40002
            ("Token已过期"), // 40003
            ("重复登陆") // 40004
    };

    private String errInfo(String code)
    {
        if (code == null || code.equals(""))
        {
            return null;
        }
        int index = Integer.parseInt(code) - 40000;
        return errInfoList[index];
    }

    public <T> List<T> getData(String interfaceName, Class clazz, String orderField, String param)
    {
        String data;
        List<T> result = null;

        /**
         * 表示url需要的参数序列
         */
        String URLParam = String.format("token=%1$s%2$s%3$s",
                Model.token, // param1
//                null == lstConditionGroup ? "" : "&jsonSearchParam=" + JsonJoin.ObjectToJson(lstConditionGroup), // 这两个参数暂时没有用到
//                null == dicConditions ? "" : "&jsonModel=" + JsonJoin.ObjectToJson(dicConditions),
                null == orderField ? "" : "&OrderField=" + orderField, // param2
                (null == param || param.trim().length() <= 0 ? "" : (param.trim().startsWith("&") ? "" : "&") + param)// param3
        );

        /**
         * 组合需要最后的 URL地址
         */
        String expectURL = String.format("%1$sParkAPI/%2$s%3$s%4$s"
                , address
                , interfaceName
                , (null == URLParam || "" == URLParam.trim() ? "" : "?")
                , URLParam);


        try
        {
            // http://192.168.2.158:9000/ParkAPI/GetOperatorsWithoutLogin
            data = HttpUtils.doGet(expectURL);
            Log.i(TAG, expectURL + data);
            CommonJsonList commonJson4List = CommonJsonList.fromJson(data, clazz);

            if (!commonJson4List.getRcode().equals("200"))
            {
                errInfo(commonJson4List.getRcode());
                return result;
            }

            result = commonJson4List.getData();
        }
        catch (Exception ex)
        {
            Log.i(TAG, expectURL + ">>> 获取数据失败");
        }

        return result;
    }

    /**
     * 异步来获取数据
     * @param interfaceName
     * @param clazz
     * @param orderField
     * @param param
     */
    public void getDataAsync(String interfaceName, Class clazz, String orderField, String param, final Callback cb)
    {
        String data;
        /**
         * 表示url需要的参数序列
         */
        final String URLParam = String.format("token=%1$s%2$s%3$s",
                Model.token, // param1
//                null == lstConditionGroup ? "" : "&jsonSearchParam=" + JsonJoin.ObjectToJson(lstConditionGroup), // 这两个参数暂时没有用到
//                null == dicConditions ? "" : "&jsonModel=" + JsonJoin.ObjectToJson(dicConditions),
                null == orderField ? "" : "&OrderField=" + orderField, // param2
                (null == param || param.trim().length() <= 0 ? "" : (param.trim().startsWith("&") ? "" : "&") + param)// param3
        );

        /**
         * 组合需要最后的 URL地址
         */
        final String expectURL = String.format("%1$sParkAPI/%2$s%3$s%4$s"
                , address
                , interfaceName
                , (null == URLParam || "" == URLParam.trim() ? "" : "?")
                , URLParam);
        HttpUtils.doGetAsyn(expectURL, new HttpUtils.CallBack()
        {
            @Override
            public void onRequestSuccessComplete(String result)
            {
                Log.i(TAG, expectURL + result);
                if (cb != null)
                {
                    cb.doDataByAsync(result);
                }
            }

            @Override
            public void onRequestFailedComplete()
            {
                Log.i(TAG, expectURL + "请求数据失败");
            }
        });
    }

    public interface Callback
    {
        void doDataByAsync(String data);
    }
}
