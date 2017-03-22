package com.example.testnetworkapi.ui;

import android.util.Log;

import com.example.testnetworkapi.CommonJson;
import com.example.testnetworkapi.CommonJsonList;
import com.example.testnetworkapi.HttpUtils;
import com.example.testnetworkapi.MainActivity;
import com.example.testnetworkapi.Model;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017-02-24.
 */
public class RequestByURL
{

    private static final String TAG = "RequestByURL";
    // 请求url数据，最后返回列表数据
    private static String address = "http://" + Model.serverIP + ":" + Model.serverPort + "/";

    private static Gson mGson = new Gson();

    public RequestByURL()
    {

    }

    //请求数据
    public static <T> List<T> getDataList(String interfaceName, Class clazz, String orderField, String param)
    {
        String data;
        List<T> result = null;

        if (null == interfaceName || interfaceName.trim().length() <= 0)
        {
            return null;
        }


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

    //请求数据
    public static <T> List<T> getDataListWithoutTokenField(String interfaceName, Class clazz, String orderField, String param)
    {
        String data;
        List<T> result = null;

        if (null == interfaceName || interfaceName.trim().length() <= 0)
        {
            return null;
        }


        /**
         * 表示url需要的参数序列
         */
        String URLParam = String.format("%1$s%2$s",
//                Model.token, // param1
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


    //请求数据
    public static <T> T getData(String interfaceName, Class clazz, String orderField, String param)
    {
        String data;
        T result = null;

        if (null == interfaceName || interfaceName.trim().length() <= 0)
        {
            return null;
        }


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

            CommonJson commonJson = CommonJson.fromJson(data, clazz);

            if (!commonJson.getRcode().equals("200"))
            {
                errInfo(commonJson.getRcode());
                return result;
            }

            result = (T) commonJson.getData();
        }
        catch (Exception ex)
        {
            Log.i(TAG, expectURL + ">>> 获取数据失败");
        }

        return result;
    }

    public static <T> T getDataWithoutTokenField(String interfaceName, Class clazz, String orderField, String param)
    {
        String data;
        T result = null;

        if (null == interfaceName || interfaceName.trim().length() <= 0)
        {
            return null;
        }


        /**
         * 表示url需要的参数序列
         */
        String URLParam = String.format("%1$s%2$s", // %3$s
//                Model.token, // param1
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

            CommonJson commonJson = CommonJson.fromJson(data, clazz);

            if (!commonJson.getRcode().equals("200"))
            {
                errInfo(commonJson.getRcode());
                return result;
            }

            result = (T) commonJson.getData();
        }
        catch (Exception ex)
        {
            Log.i(TAG, expectURL + ">>> 获取数据失败 " + ex);
        }

        return result;
    }

    public static <T> T addData(String interfaceName, Class clazz, String param)
    {
        String data;
        T result = null;

        if (null == interfaceName || interfaceName.trim().length() <= 0)
        {
            return null;
        }


        /**
         * 表示url需要的参数序列
         */
        String URLParam = String.format("%1$s", // %3$s
//                Model.token, // param1
//                null == lstConditionGroup ? "" : "&jsonSearchParam=" + JsonJoin.ObjectToJson(lstConditionGroup), // 这两个参数暂时没有用到
//                null == dicConditions ? "" : "&jsonModel=" + JsonJoin.ObjectToJson(dicConditions),
//                null == orderField ? "" : "&OrderField=" + orderField, // param2
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

            CommonJson commonJson = CommonJson.fromJson(data, clazz);

            if (!commonJson.getRcode().equals("200"))
            {
                errInfo(commonJson.getRcode());
                return result;
            }

            result = (T) commonJson.getData();
        }
        catch (Exception ex)
        {
            Log.i(TAG, expectURL + ">>> 获取数据失败 " + ex);
        }

        return result;
    }



    public static <T> String objectToGson(T t)
    {
        if (t == null)
        {
            return null;
        }

        String result = null;

        Gson gson = new Gson();
        result = gson.toJson(t);

        Log.i(TAG, "gson objectToGson 字符串" + ">>> " + result);

        return result;
    }




    // 获取Gson的字符串
    public static String toJsonSearchParam(Map<String, String> inMap, boolean isExclude, boolean isLike) // 实例1：["UserNo"] = "888888"
    {
        String result = null;
        String s = JsonJoin.ToJson(inMap, isExclude, isLike);
        Log.i(TAG, "gson toJsonSearchParam 字符串" + ">>> " + s);
        result = URLEncoder.encode(s);
        return result;
    }

    // 单独来获取字符，看能否进行相应的封装
    public static String getChargeCarTypeToJsonSearchParam()
    {
        List<SelectModel> lstSM = new ArrayList<SelectModel>();
        SelectModel sm = new SelectModel();

        sm.getConditions().add(sm.new conditions("Identifying", "like", "Tmp%", "or"));
        sm.getConditions().add(sm.new conditions("Identifying", "like", "Str%", "or"));

        lstSM.add(sm);
        sm = new SelectModel();
        sm.getConditions().add(sm.new conditions("Enabled", "=", "1", "and"));
        lstSM.add(sm);

        Gson gson = new Gson(); // gson不用连续来重建
        String where = gson.toJson(lstSM);
        return URLEncoder.encode(where);
    }

    public static String[] errInfoList = new String[]{
            ("token已经失效,请重新获取"), // 40000
            ("未知异常,请联系管理员查看异常日志"), // 40001
            ("输入参数缺失或错误"), // 40002
            ("Token已过期"), // 40003
            ("重复登陆") // 40004
    };

    private static String errInfo(String code)
    {
        if (code == null || code.equals(""))
        {
            return null;
        }
        int index = Integer.parseInt(code) - 40000;
        return errInfoList[index];
    }

    public static String getWhere(Map<String, String> inMap)
    {
        if (inMap == null)
        {
            return null;
        }

        String order = "";
        int count = 0;
        Set<String> keySet = inMap.keySet();
        for (String tempStr : keySet)
        {
            count++;
            if (count == 1)
            {
                order = tempStr + " " + inMap.get(tempStr);
            }
            else
            {
                order += "," + tempStr + " " + inMap.get(tempStr);
            }
        }

        return URLEncoder.encode(order);
    }
}
