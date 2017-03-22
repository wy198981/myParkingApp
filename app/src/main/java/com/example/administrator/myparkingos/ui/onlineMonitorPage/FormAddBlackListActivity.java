package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.mydistributedparkingos.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2017-02-16.
 * 【在线监控】 -->> 【黑名单登记】
 */
public class FormAddBlackListActivity extends AppCompatActivity implements View.OnClickListener
{


    private Spinner spinProvince;
    private EditText etInputCarPlate;
    private TextView tvStartTime;
    private TextView tvEndTime;
    private EditText etReson;
    private Button btnAdd;
    private Button btnQuery;
    private Button btnDelete;
    private Button btnDeleteAll;
    private Button btnQuit;
    private ListView listView;
    private int mYear;
    private int mMonth;
    private int mDay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_addblacklist);
        initView();
    }


    private void initView()
    {
        spinProvince = (Spinner) findViewById(R.id.spinProvince);
        etInputCarPlate = (EditText) findViewById(R.id.etInputCarPlate);
        tvStartTime = (TextView) findViewById(R.id.tvStartTime);
        tvEndTime = (TextView) findViewById(R.id.tvEndTime);
        etReson = (EditText) findViewById(R.id.etReson);
        btnAdd = (Button) findViewById(R.id.btnAddNew);
        btnQuery = (Button) findViewById(R.id.btnQuery);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDeleteAll = (Button) findViewById(R.id.btnDeleteAll);
        btnQuit = (Button) findViewById(R.id.btnQuit);
        listView = (ListView) findViewById(R.id.listView);

        btnAdd.setOnClickListener(this);
        btnQuery.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDeleteAll.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

        tvStartTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAddNew:

                break;
            case R.id.btnQuery:

                break;
            case R.id.btnDelete:

                break;
            case R.id.btnDeleteAll:

                break;
            case R.id.btnQuit:

                break;
            case R.id.tvStartTime://使用对话框的方式来选择时间
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()// 采用这种方式，可以要看看最新最好的项目；
                {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day)
                    {
                        // TODO Auto-generated method stub
                        mYear = year;
                        mMonth = month;
                        mDay = day;
                        //更新EditText控件日期 小于10加0
                        tvStartTime.setText(new StringBuilder().append(mYear).append("-")
                                .append((mMonth + 1) < 10 ? 0 + (mMonth + 1) : (mMonth + 1))
                                .append("-").append((mDay < 10) ? 0 + mDay : mDay));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }

}
