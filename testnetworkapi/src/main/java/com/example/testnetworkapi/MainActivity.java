package com.example.testnetworkapi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private final String TAG = "MainActivity";
    private TextView textView;
    private Button button;
    private Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        request = new Request();


    }

    private void initView()
    {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button:

//                testAsyncTask();

                testThread();
                break;
        }
    }

    private void testThread()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    Log.i("testThread", textView.getText().toString());
                }

            }
        }).start();
    }

    private void testAsyncTask()
    {
        ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask();
        asyncTask.execute(1000);
        ProgressBarAsyncTask asyncTask1 = new ProgressBarAsyncTask();
        asyncTask1.execute(2000);

        ProgressBarAsyncTask asyncTask2 = new ProgressBarAsyncTask();
        asyncTask2.execute(3000);

        ProgressBarAsyncTask asyncTask3 = new ProgressBarAsyncTask();
        asyncTask3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, 3000); // 这里来方便并发执行
    }

    private void showDialog()
    {
//        new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")//设置对话框标题
//
//                .setMessage("请确认所有数据都保存后再推出系统！")//设置显示的内容
//
//                .setPositiveButton("确定", new DialogInterface.OnClickListener()
//                {//添加确定按钮
//
//
//                    @Override
//
//                    public void onClick(DialogInterface dialog, int which)
//                    {//确定按钮的响应事件
//
//                        // TODO Auto-generated method stub
//
//                        finish();
//
//                    }
//
//                }).setNegativeButton("返回", new DialogInterface.OnClickListener()
//        {//添加返回按钮
//
//
//            @Override
//            public void onClick(DialogInterface dialog, int which)
//            {//响应事件
//
//                // TODO Auto-generated method stub
//
//                Log.i("alertdialog", " 请保存数据！");
//
//            }
//        }).show();//在按键响应事件中显示此对话框

        new AlertDialog.Builder(this).setTitle("提示信息")
                .setMessage("配置文件丢失，请联系管理员").setPositiveButton("确认", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        }).show();
    }
}
