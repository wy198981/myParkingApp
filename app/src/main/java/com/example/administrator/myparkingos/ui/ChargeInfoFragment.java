package com.example.administrator.myparkingos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.util.L;

import java.util.List;

/**
 * Created by Administrator on 2017-03-06.
 */
public class ChargeInfoFragment extends Fragment
{
    private TextView tvPersonNo;
    private TextView personName;
    private TextView tvCarNo;
    private TextView tvDeptName;
    private TextView tvCarType;
    private TextView tvFreeMoney;
    private TextView tvInTime;
    private TextView tvOutTime;
    private TextView tvPayMoney;
    private TextView tvAmountMoney;
    private TextView tvRemainerMoney;
    private LinearLayout llChargeInfoItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.parkmonitor_chargeinfo_item, container, false);
        initView(root);
        return root;

    }

    private void initView(View root)
    {
        tvPersonNo = (TextView) root.findViewById(R.id.etUserNo);
        personName = (TextView) root.findViewById(R.id.personName);
        tvCarNo = (TextView) root.findViewById(R.id.tvCarNo);
        tvDeptName = (TextView) root.findViewById(R.id.tvDeptName);
        tvCarType = (TextView) root.findViewById(R.id.tvCarType);
        tvFreeMoney = (TextView) root.findViewById(R.id.tvFreeMoney);
        tvInTime = (TextView) root.findViewById(R.id.tvInTime);
        tvOutTime = (TextView) root.findViewById(R.id.tvOutTime);
        tvPayMoney = (TextView) root.findViewById(R.id.tvPayMoney);
        tvAmountMoney = (TextView) root.findViewById(R.id.tvAmountMoney);
        tvRemainerMoney = (TextView) root.findViewById(R.id.tvRemainerMoney); // 11
        llChargeInfoItem = (LinearLayout) root.findViewById(R.id.llChargeInfoItem);

        tvPersonNo.setText("");
        personName.setText("");
        tvCarNo.setText("");
        tvDeptName.setText("");
        tvCarType.setText("");
        tvFreeMoney.setText("0000.00");
        tvInTime.setText("");
        tvOutTime.setText("");
        tvPayMoney.setText("");
        tvAmountMoney.setText("0000.00");
        tvRemainerMoney.setText("");
    }

    /**
     * 设置界面的数据，数据应该是拼接出来的
     */
    public void setData(List<String> inList)
    {
        if (inList == null || inList.size() != 11) // 11个标签数据
        {
            L.i("inList == null || inList.size() != 11" + "inList.size():" + inList.size());
            return ;
        }
        tvPersonNo.setText(inList.get(0));
        personName.setText(inList.get(1));
        tvCarNo.setText(inList.get(2));
        tvDeptName.setText(inList.get(3));
        tvCarType.setText(inList.get(4));
        tvFreeMoney.setText(inList.get(5));
        tvInTime.setText(inList.get(6));
        tvOutTime.setText(inList.get(7));
        tvPayMoney.setText(inList.get(8));
        tvAmountMoney.setText(inList.get(9));
        tvRemainerMoney.setText(inList.get(10));
    }
}
