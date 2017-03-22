package com.example.testnetworkapi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.testnetworkapi.queue.ConcurrentQueueHelper;
import com.example.testnetworkapi.queue.LinkBlockingQueueHelper;
import com.example.testnetworkapi.queue.ModelNode;

import java.util.Random;

/**
 * Created by Administrator on 2017-03-09.
 */
public class TestQueueActivity extends AppCompatActivity
{
    private int i;
    private String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler.postDelayed(postRunnable, 2000);
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    ModelNode modelNode = ConcurrentQueueHelper.getInstance().get();
                    if (modelNode != null)
                    {
                        Log.i(TAG, "获取数据" + modelNode.toString());
                    }
                    else
                    {
                        Log.i(TAG, "没有获取到数据");
                    }
                }
            }
        }).start();
    }

    private Runnable postRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            i += 10;
            ConcurrentQueueHelper.getInstance().put(new ModelNode(i, "hello", "strFile", "strFileJpg", "strCPH"));
            Log.i(TAG, "post 获取数据");
            handler.postDelayed(postRunnable, 2000);
        }
    };

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {


        }
    };
}
