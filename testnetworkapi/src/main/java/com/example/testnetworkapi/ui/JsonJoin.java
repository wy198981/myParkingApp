package com.example.testnetworkapi.ui;

import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017-03-01.
 */
public class JsonJoin
{
    /// <summary>
    /// 查询带条件的
    /// </summary>
    /// <param name="dic"></param>
    /// <param name="isExclude">默认为and,为true时</param>
    /// <returns></returns>
//    public static string toJsonSearchParam(Dictionary<string, object> dic, bool isExclude = false, bool isLike = false)
    public static String ToJson(Map<String, String> dic, boolean isExclude, boolean isLike)
    {
        if (dic == null)
        {
            return null;
        }

        SelectModel selectModel = new SelectModel();
        Set<String> set = dic.keySet();
        for (String tempStr : set)
        {
            SelectModel.conditions conditions = selectModel.new conditions();
            conditions.setFieldName(tempStr);
            conditions.setOperator(isLike ? (isExclude ? "not like" : "like") : (isExclude ? "<>" : "="));
            conditions.setFieldValue(dic.get(tempStr));
            conditions.setCombinator("and");
            selectModel.getConditions().add(conditions);
        }
        selectModel.setCombinator("and");
        ArrayList<SelectModel> selectList = new ArrayList<>();
        selectList.add(selectModel);

        Gson gson = new Gson();
        String s = gson.toJson(selectList); // 转换成String
        return s;
    }
}
