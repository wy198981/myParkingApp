package com.example.administrator.myparkingos.model.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-01.
 */
public class SelectModel
{
    public SelectModel()
    {

    }
    public class conditions
    {
        private String FieldName;
        private String Operator;
        private String FieldValue;
        private String Combinator;
        public conditions()
        {

        }

        public conditions(String fieldName, String operator, String fieldValue, String combinator)
        {
            FieldName = fieldName;
            Operator = operator;
            FieldValue = fieldValue;
            Combinator = combinator;
        }

        public String getFieldName()
        {
            return FieldName;
        }

        public void setFieldName(String fieldName)
        {
            FieldName = fieldName;
        }

        public String getOperator()
        {
            return Operator;
        }

        public void setOperator(String operator)
        {
            Operator = operator;
        }

        public String getFieldValue()
        {
            return FieldValue;
        }

        public void setFieldValue(String fieldValue)
        {
            FieldValue = fieldValue;
        }

        public String getCombinator()
        {
            return Combinator;
        }

        public void setCombinator(String combinator)
        {
            Combinator = combinator;
        }

        @Override
        public String toString()
        {
            return "conditions{" +
                    "FieldName='" + FieldName + '\'' +
                    ", Operator='" + Operator + '\'' +
                    ", FieldValue='" + FieldValue + '\'' +
                    ", Combinator='" + Combinator + '\'' +
                    '}';
        }
    }

    private List<conditions> Conditions = new ArrayList<>();
    private String Combinator = "and";

    public List<conditions> getConditions()
    {
        return Conditions;
    }

    public void setConditions(List<conditions> conditions)
    {
        Conditions = conditions;
    }

    public String getCombinator()
    {
        return Combinator;
    }

    public void setCombinator(String combinator)
    {
        Combinator = combinator;
    }

    @Override
    public String toString()
    {
        return "SelectModel{" +
                "Conditions=" + Conditions +
                ", Combinator='" + Combinator + '\'' +
                '}';
    }
}
