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
public class ChargeSpaceFragment extends Fragment
{
    private TextView tvMonCarNum;
    private TextView tvFreeCarNum;
    private TextView tvTempCarNum;
    private TextView tvStoreCarNum;
    private TextView tvManualNum;
    private LinearLayout llChargeSpaceItem;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.parkmonitor_chargespace_item, container, false);
        initView(root);
        return root;
    }

    private void initView(View root)
    {
        tvMonCarNum = (TextView) root.findViewById(R.id.tvMonCarNum);
        tvFreeCarNum = (TextView) root.findViewById(R.id.tvFreeCarNum);
        tvTempCarNum = (TextView) root.findViewById(R.id.tvTempCarNum);
        tvStoreCarNum = (TextView) root.findViewById(R.id.tvStoreCarNum);
        tvManualNum = (TextView) root.findViewById(R.id.tvManualNum);
        llChargeSpaceItem = (LinearLayout) root.findViewById(R.id.llChargeSpaceItem);
    }

    public void setData(List<String> inList)
    {
        if (inList == null || inList.size() != 5) // 5表示只有5段数据显示
        {
            L.i("inList == null || inList.size() != 5" + "inList.size():" + inList.size());
            return ;
        }

        tvMonCarNum.setText(inList.get(0));
        tvFreeCarNum.setText(inList.get(1));
        tvTempCarNum.setText(inList.get(2));
        tvStoreCarNum.setText(inList.get(3));
        tvManualNum.setText(inList.get(4));
    }
}
