package com.example.administrator.myparkingos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.constant.ConstantConfig;
import com.example.administrator.myparkingos.constant.ConstantSharedPrefs;
import com.example.administrator.myparkingos.util.SPUtils;
import com.example.administrator.myparkingos.util.ScreenUtils;

/**
 * Created by Administrator on 2017-02-16.
 * 【登录界面】 -->> 【服务器参数设置】
 */
public class FormServerSetActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etServerIP;
    private EditText etServerPort;
    private Button btnSave;

    private String serviceIP = ConstantConfig.ServerIP;
    private String servicePort = ConstantConfig.ServerPort;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serverset);

        ScreenUtils.setWindowPositionAndSize(this, 3, 3);
        readConfigFromFile();
        initView();
    }

    private void readConfigFromFile()
    {
        if (SPUtils.checkPathExist(getApplicationContext(), ConstantSharedPrefs.FileAppSetting))
        {
            serviceIP = (String) SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                    , ConstantSharedPrefs.ServiceIP, "");
            servicePort = (String) SPUtils.get(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                    , ConstantSharedPrefs.ServicePort, "");
        }
    }

    private void initView()
    {
        etServerIP = (EditText) findViewById(R.id.etServerIP);
        etServerPort = (EditText) findViewById(R.id.etServerPort);
        btnSave = (Button) findViewById(R.id.btnAdd);

        etServerIP.setText(serviceIP);
        etServerPort.setText(servicePort);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAdd:
                if (!submit())
                {
                    return;
                }

                SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                        , ConstantSharedPrefs.ServiceIP, etServerIP.getEditableText().toString());
                SPUtils.put(ConstantSharedPrefs.FileAppSetting, getApplicationContext()
                        , ConstantSharedPrefs.ServicePort, etServerPort.getEditableText().toString());
                finish();
                break;
        }
    }

    private boolean submit()
    {
        boolean result = true;
        // validate
        String etServerIPString = etServerIP.getText().toString().trim();
        if (TextUtils.isEmpty(etServerIPString))
        {
            Toast.makeText(this, "etServerIPString不能为空", Toast.LENGTH_SHORT).show();
            result = false;
        }

        String etServerPortString = etServerPort.getText().toString().trim();
        if (TextUtils.isEmpty(etServerPortString))
        {
            Toast.makeText(this, "etServerPortString不能为空", Toast.LENGTH_SHORT).show();
            result = false;
        }
        return result;
    }
}
