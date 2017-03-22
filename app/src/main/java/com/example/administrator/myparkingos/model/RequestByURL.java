package com.example.administrator.myparkingos.model;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.ArrayMap;

import com.example.administrator.myparkingos.model.beans.Model;
import com.example.administrator.myparkingos.model.beans.SelectModel;
import com.example.administrator.myparkingos.util.HttpUtils;
import com.example.administrator.myparkingos.util.L;
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
    public static String address = "http://" + Model.serverIP + ":" + Model.serverPort + "/";

    /**
     * 表示错误开始码
     */
    private static int ERROR_BASE_CODE = 40000;

    public RequestByURL()
    {

    }

    public static void setAddress(String ip, int port)
    {
        address = "http://" + ip + ":" + port + "/";
    }

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
            data = HttpUtils.doGet(expectURL);
            L.i(expectURL + data);
            CommonJsonList commonJson4List = CommonJsonList.fromJson(data, clazz);


            if (!checkRcode(Integer.parseInt(commonJson4List.getRcode())))
            {
                return result;
            }

            result = commonJson4List.getData();
        }
        catch (Exception ex)
        {
            L.i(expectURL + ">>> 获取数据失败");
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
                (null == param || param.trim().length() <= 0 ? "" : param)// param2
                , null == orderField ? "" : "&OrderField=" + orderField// param3
        ); // 拼接字符

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
            data = HttpUtils.doGet(expectURL);
            L.i(expectURL + "=>>" + data);
            CommonJsonList commonJson4List = CommonJsonList.fromJson(data, clazz);

            if (!checkRcode(Integer.parseInt(commonJson4List.getRcode())))
            {
                return result;
            }

            result = commonJson4List.getData();
        }
        catch (Exception ex)
        {
            L.i(expectURL + ">>> 获取数据失败");
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
            data = HttpUtils.doGet(expectURL);
            L.i(expectURL + data);

            CommonJson commonJson = CommonJson.fromJson(data, clazz);

            if (!checkRcode(Integer.parseInt(commonJson.getRcode())))
            {
                return result;
            }

            result = (T) commonJson.getData();
        }
        catch (Exception ex)
        {
            L.i(expectURL + ">>> 获取数据失败");
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

//        String tempParam = null;
//        if (null == param || param.trim().length() <= 0)
//        {
//            tempParam = "";
//        }
//        else
//        {
//            if (param.trim().startsWith("&"))
//            {
//                tempParam = param;
//            }
//            else
//            {
//                tempParam = "&" + param;
//            }
//        }
//        L.i("tempParam:" + tempParam);

        String URLParam = String.format("%1$s%2$s", // %3$s
                null == orderField ? "" : "&OrderField=" + orderField, // param2
//                (null == param || param.trim().length() <= 0 ? "" : (param.trim().startsWith("&") ? "" : "&") + param)// param3
                (null == param || param.trim().length() <= 0 ? "" : param)// param3
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
            data = HttpUtils.doGet(expectURL);
            L.i(expectURL + ", " + data);

            CommonJson commonJson = CommonJson.fromJson(data, clazz);

            if (!checkRcode(Integer.parseInt(commonJson.getRcode())))
            {
                return result;
            }

            result = (T) commonJson.getData();
        }
        catch (Exception ex)
        {
            L.i(expectURL + " >>> 获取数据失败 " + ex);
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
            data = HttpUtils.doGet(expectURL);
            L.i(expectURL + data);

            CommonJson commonJson = CommonJson.fromJson(data, clazz);

            if (!checkRcode(Integer.parseInt(commonJson.getRcode())))
            {
                return result;
            }

            result = (T) commonJson.getData();
        }
        catch (Exception ex)
        {
            L.i(expectURL + ">>> 获取数据失败 " + ex);
        }

        return result;
    }

    /**
     * 将object对象直接转换成json字符串
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String objectToGson(T t)
    {
        if (t == null)
        {
            return null;
        }

        String result = null;

        Gson gson = new Gson();
        result = gson.toJson(t);
        return result;
    }


    /**
     * 获取 JsonSearchParam类型的字符串
     *
     * @param inMap
     * @param isExclude
     * @param isLike
     * @return
     */
    public static String getJsonSearchParam(Map<String, String> inMap, boolean isExclude, boolean isLike) // 实例1：["UserNo"] = "888888"
    {
        String result = null;
        String s = JsonJoin.ToJson(inMap, isExclude, isLike);
        result = URLEncoder.encode(s);
        return result;
    }

    /**
     * 获取收费类的JsonSearchParam字符串
     *
     * @return
     */
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
            ("重复登陆"), // 40004
            ("重复登陆同一工作站"), // 40005
            ("权限不足"), // 6
            ("已过有效期"), // 7
            ("已过有效期"), // 8
            ("车场已满位"), // 9
            ("个人车位已满"), // 10
            ("禁止通行"), // 11
            ("余额不足"), // 12
            ("黑名单车辆"),// 13
            ("禁止开闸模式")// 14
    };

    /**
     * 获取出现错误的字符串信息
     *
     * @param code
     * @return
     */
    private static String errInfo(int code)
    {
        if (code >= ERROR_BASE_CODE)
        {
            return errInfoList[code - ERROR_BASE_CODE];
        }
        else
        {
            if (code == -1)
            {
                return "月租车因个人车位满而按临时车计费(仍然可进场)";
            }
            else if (code == -2)
            {
                return "月租车过期按临时车计费(仍然可进场)";
            }
            else if (code == -3)
            {
                return "重复入场(仍然可进场)";
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * 获取where条件的字符串
     *
     * @param inMap
     * @return
     */
    public static String getOrderField(Map<String, String> inMap)
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
//        return order;
        return URLEncoder.encode(order); //where条件都没有经过编码转换
    }

    /**
     * 显示列表数据
     *
     * @param inList
     * @param text
     * @param <T>
     */
    public static <T> void displayListInfo(List<T> inList, String text)
    {
        if (inList == null)
        {
            return;
        }

        L.i(text, "===>>");
        for (T o : inList)
        {
            L.i(o.toString());
        }
    }

    /**
     * 显示对象数据
     *
     * @param t
     * @param text
     * @param <T>
     */
    public static <T> void displaySimpleInfo(T t, String text)
    {
        if (t == null)
        {
            return;
        }

        L.i(text + "===>>");
        L.i(t.toString());
    }

    /**
     * 将map集合的字符对转换成字符串
     *
     * @param stringStringArrayMap
     * @return
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String mapConvertString(Map<String, String> stringStringArrayMap)
    {
        StringBuffer stringBuffer = new StringBuffer();
        if (stringStringArrayMap == null || stringStringArrayMap.size() <= 0)
        {
            return null;
        }

        Set<String> strings = stringStringArrayMap.keySet();

        int i = 0;
        for (String str : strings)
        {
            stringBuffer.append(str).append("=").append(stringStringArrayMap.get(str));
            if (i != strings.size() - 1)
            {
                stringBuffer.append("&");
            }
            i++;
        }

//        L.i("stringBuffer.toString():" + stringBuffer.toString());
        return stringBuffer.toString();//
    }

    /**
     * 检测请求消息码 Rcode
     *
     * @param inCode
     * @return
     */
    public static boolean checkRcode(int inCode)
    {
        boolean bResult = true;
        if (inCode != 200 && inCode >= ERROR_BASE_CODE)
        {
            L.i(errInfo(inCode));
            bResult = false;
        }
        return bResult;
    }
}
