package com.example.testnetworkapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-02-24.
 */
public class TestViewAttrsActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView textView;
    private Button button;
    private String TAG = "TestViewAttrsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()
    {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);


        // 怎么让view滑动
        button.setOnClickListener(this);
        button.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    Log.i(TAG, "MotionEvent.ACTION_DOWN:");
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button:

                int height = v.getHeight();
                int width = v.getWidth();

                Log.i(TAG, "height:" + height + ",width:" + width);

                int top = v.getTop();
                int left = v.getLeft();
                int right = v.getRight();
                int bottom = v.getBottom();

                Log.i(TAG, "top:" + top + ",left:" + left);
                Log.i(TAG, "right:" + right + ",bottom:" + bottom);


                float x = v.getX();
                float y = v.getY();
                Log.i(TAG, "x:" + x + ",y:" + y);


                Log.i(TAG, "TouchSlop:" + ViewConfiguration.get(this).getScaledDoubleTapSlop());
                break;
        }
    }
}
