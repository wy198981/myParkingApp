package com.example.administrator.myparkingos.model.beans;

/**
 * Created by Administrator on 2017-03-21.
 */
public class JiHaoSelectInfo
{
    /**
     * 表示机号显示的文本
     */
    private String jiHaoTxt;

    /**
     * 标记当前机号是否选择
     */
    private boolean isChecked;

    public JiHaoSelectInfo()
    {
    }

    public JiHaoSelectInfo(String jiHaoTxt, boolean isChecked)
    {
        this.jiHaoTxt = jiHaoTxt;
        this.isChecked = isChecked;
    }

    public String getJiHaoTxt()
    {
        return jiHaoTxt;
    }

    public void setJiHaoTxt(String jiHaoTxt)
    {
        this.jiHaoTxt = jiHaoTxt;
    }

    public boolean isChecked()
    {
        return isChecked;
    }

    public void setChecked(boolean checked)
    {
        isChecked = checked;
    }

    @Override
    public String toString()
    {
        return "JiHaoSelectInfo{" +
                "jiHaoTxt='" + jiHaoTxt + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
