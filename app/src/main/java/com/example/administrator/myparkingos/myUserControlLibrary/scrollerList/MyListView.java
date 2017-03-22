package com.example.administrator.myparkingos.myUserControlLibrary.scrollerList;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.administrator.myparkingos.util.L;

/**
 * MyListView consists of a HorizontalScrollView, a LinearLayout which is the title of list,
 * and a ListView.
 *
 * @author �ף��أ�
 * @version 1.0
 * @Time 2014-08-11
 */
public class MyListView
{
    private Context context;
    private ListView listView;
    private int[] titles;
    private LinearLayout head;
    private HorizontalScrollView hs;
    private MyAdapter adapter;

    /**
     * constructs a MyListView. MyListView consists of a HorizontalScrollView, a LinearLayout which is the title of list,
     * and a ListView.
     */
    @SuppressLint("NewApi")
    public MyListView(Context context, View v, int[] titles, int hsId, int lvId, int hdId, MyAdapter adapter)
    {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.titles = titles;
        this.head = (LinearLayout) v.findViewById(hdId);
        this.listView = (ListView) v.findViewById(lvId);
        this.hs = (HorizontalScrollView) v.findViewById(hsId);
        this.adapter = adapter;
        setTitleTouchListener(v);
        setAdapter();
    }

    private void setAdapter()
    {
        listView.setAdapter(adapter);
    }

    /**
     * 期望设置和标题等宽的大小
     * @param scrollContainer
     */
    public void setSizeWithPost(View scrollContainer)
    {
        for (int i = 0; i < titles.length; i++)
        {
            final View viewById = scrollContainer.findViewById(titles[i]);
            final int column = i;

            viewById.post(new Runnable()
            {
                @Override
                public void run()
                {
                    int width = viewById.getMeasuredWidth();
                    adapter.setColumnWidth(column, width);
                    L.i("@@@@@@@@@@width:" + width);
                }
            });
        }
    }

    /**
     * Set TouchListener on tile ,if ACTION_MOVE is called ,the listView will change its columnWidth
     */
    private void setTitleTouchListener(View v)
    {
        // TODO Auto-generated method stub
        for (int i = 0; i < titles.length; i++)
        {
            final int column = i;
            v.findViewById(titles[i]).setOnTouchListener(new OnTouchListener()
            {
                int x = 0;
                int x1 = 0;
                int width = 0;
                boolean isMoved = false;
                int t = 20;

                @SuppressLint("NewApi")
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub
                    //two teps
                    // 1.when touch down and move, change the width of head;
                    // 2.touch up ,change the width of the columns ;

                    if (event.getAction() == MotionEvent.ACTION_DOWN)
                    {
                        x = (int) event.getX();
                        hs.requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                    if (event.getAction() == MotionEvent.ACTION_MOVE)
                    {
                        x1 = (int) event.getX();
                        width = v.getMeasuredWidth() + (x1 - x) + t;
                        if (t != 0)
                            t = 0;
                        v.setLayoutParams(new LinearLayout.LayoutParams(width, v.getMeasuredHeight()));
                        x = x1;
                        isMoved = true;
                        return true;
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP)
                    {
                        if (isMoved)
                            adapter.setColumnWidth(column, width);
                        return true;

                    }
                    if (event.getAction() == MotionEvent.ACTION_CANCEL)
                    {
                        if (isMoved)
                            adapter.setColumnWidth(column, width);
                        return true;
                    }

                    return true;
                }
            });
        }
    }

    public ListView getListView()
    {
        return listView;
    }

    public void setListView(ListView listView)
    {
        this.listView = listView;
    }

    public int[] getTitles()
    {
        return titles;
    }

    public void setTitles(int[] titles)
    {
        this.titles = titles;
    }

    /**
     * Set the color of the title
     *
     * @param colorId int, the id of the color.
     */
    @SuppressLint("NewApi")
    public void setHeadColor(int colorId)
    {
        int color = context.getResources().getColor(colorId);
        this.head.setBackgroundColor(color);
    }


}