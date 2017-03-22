package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.myUserControlLibrary.radioBtn.MyRadioGroup;
import com.example.administrator.myparkingos.util.ScreenUtils;

/**
 * Created by Administrator on 2017-02-16.
 * 【在线监控】 -->> 【车辆入场】
 */
public class ParkingPlateNoInputActivity extends AppCompatActivity
{
    private MyRadioGroup rgSelectProvince;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_carin);
        initView();
        ScreenUtils.setWindowPositionAndSize(ParkingPlateNoInputActivity.this, 5, 1.8);
        // 注意的问题：1，不能指定RadioButton究竟能显示几列
        //           2,每一个按钮的选择是互斥的，只能选择其中一个

    }

    private void initView()
    {
//        rgSelectProvince = (MyRadioGroup) findViewById(R.id.rgSelectProvince);
//        rgSelectProvince.setSingleColumn(false);
//        rgSelectProvince.setColumnNumber(5);
//        rgSelectProvince.setColumnHeight(getResources().getDimensionPixelSize(R.dimen.radio_button_of_height));
    }
}
