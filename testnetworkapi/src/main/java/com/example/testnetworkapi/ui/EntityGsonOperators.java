package com.example.testnetworkapi.ui;

import java.util.List;

/**
 * Created by Administrator on 2017-02-28.
 */
public class EntityGsonOperators
{
    /**
     * Conditions : [{"FieldName":"UserNO","Operator":"=","FieldValue":"888888","Combinator":"and"}]
     * Combinator : and
     */

    private String Combinator;
    private List<ConditionsBean> Conditions;

    public String getCombinator()
    {
        return Combinator;
    }

    public void setCombinator(String Combinator)
    {
        this.Combinator = Combinator;
    }

    public List<ConditionsBean> getConditions()
    {
        return Conditions;
    }

    public void setConditions(List<ConditionsBean> Conditions)
    {
        this.Conditions = Conditions;
    }

    public static class ConditionsBean
    {
        /**
         * FieldName : UserNO
         * Operator : =
         * FieldValue : 888888
         * Combinator : and
         */

        private String FieldName;
        private String Operator;
        private String FieldValue;
        private String Combinator;

        public String getFieldName()
        {
            return FieldName;
        }

        public void setFieldName(String FieldName)
        {
            this.FieldName = FieldName;
        }

        public String getOperator()
        {
            return Operator;
        }

        public void setOperator(String Operator)
        {
            this.Operator = Operator;
        }

        public String getFieldValue()
        {
            return FieldValue;
        }

        public void setFieldValue(String FieldValue)
        {
            this.FieldValue = FieldValue;
        }

        public String getCombinator()
        {
            return Combinator;
        }

        public void setCombinator(String Combinator)
        {
            this.Combinator = Combinator;
        }
    }
}
