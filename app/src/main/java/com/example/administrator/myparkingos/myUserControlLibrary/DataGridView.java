package com.example.administrator.myparkingos.myUserControlLibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.myUserControlLibrary.interfaces.DataGridListener;
import com.example.administrator.myparkingos.myUserControlLibrary.interfaces.ScrollViewListener;
import com.example.administrator.myparkingos.myUserControlLibrary.view.CustomDataGridView;
import com.example.administrator.myparkingos.myUserControlLibrary.view.HeaderView;
import com.example.administrator.myparkingos.myUserControlLibrary.view.MyHorizontalScrollView;
import com.example.administrator.myparkingos.myUserControlLibrary.view.MyScrollView;

import java.util.List;


/**
 * Created by pscj on 2016/11/24.
 */

public class DataGridView extends LinearLayout
{
    private static final String TAG = "DataGridView";
    private MyHorizontalScrollView hScrollView;
    private MyScrollView scrollView;
    private CustomDataGridView dataView;
    private HeaderView headerView;
    private InnerListener listener = new InnerListener();

    public DataGridView(Context context)
    {
        super(context);
        init(context);
    }

    public DataGridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
        Log.i(TAG, "public DataGridView(Context context, AttributeSet attrs)");
    }

    public DataGridView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context);
        Log.i(TAG, "public DataGridView(Context context, AttributeSet attrs, int defStyleAttr)");
    }

//    public DataGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
//    {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        Log.i(TAG, "11 ublic DataGridView(Context context, AttributeSet attrs, int defStyleAttr)");
//        init(context);
//        Log.i(TAG, "public DataGridView(Context context, AttributeSet attrs, int defStyleAttr)");
//    }


    private void init(Context context)
    {
        View.inflate(context, R.layout.datagrid_view, this);
        hScrollView = (MyHorizontalScrollView) findViewById(R.id.hScrollView);
        hScrollView.setScrollViewListener(new ScrollViewListener()
        {
            @Override
            public void onScrollChanged(View scrollView, int x, int y, int oldx, int oldy)
            {
                dataView.invalidate();
                headerView.invalidate();
            }
        });
        scrollView = (MyScrollView) findViewById(R.id.scrollView);
        scrollView.setScrollViewListener(new ScrollViewListener()
        {
            @Override
            public void onScrollChanged(View scrollView, int x, int y, int oldx, int oldy)
            {
                dataView.invalidate();
                headerView.invalidate();
            }
        });
        dataView = (CustomDataGridView) findViewById(R.id.custom_datagridview);
        headerView = (HeaderView) findViewById(R.id.headerView);
    }

    public void setData(List<List<String>> mData, boolean showHeader)
    {
        dataView.setData(mData, showHeader, listener);
    }


    private class InnerListener implements DataGridListener
    {
        @Override
        public void showHeader(List<String> mData, List<Integer> widthList)
        {
            headerView.setVisibility(VISIBLE);
            headerView.setData(mData, widthList);
        }

        @Override
        public void hideHeader()
        {
            //add paddingTop
            int padding = scrollView.getPaddingBottom();
            scrollView.setPadding(padding, padding, padding, padding);
            headerView.setVisibility(GONE);
        }

        @Override
        public int getScrollPosY()
        {
            return scrollView.getScrollY() - scrollView.getPaddingTop();

        }

        @Override
        public int getScrollPosX()
        {
            return hScrollView.getScrollX() - hScrollView.getPaddingLeft();
        }
    }
}
