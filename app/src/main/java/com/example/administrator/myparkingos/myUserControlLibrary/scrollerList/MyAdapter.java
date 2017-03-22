package com.example.administrator.myparkingos.myUserControlLibrary.scrollerList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MyAdapter like SimpleAdapter, but it has more function than SimpleAdapter, such as
 * OnItemClickListener, setColumnWidth, setItemColor.
 *
 * @author �ף��أ�
 * @version 1.0
 * @Time 2014-08-11
 */
/*
 * Warning: getView(int position, View convertView, ViewGroup parent),����viewList�е����һ����Ҫ���⴦��
 * */
public class MyAdapter extends BaseAdapter
{
    // ====================================================================
    private int[] mTo;
    private String[] mFrom;
    private List<? extends Map<String, ?>> mData;
    private int mResource;
    private LayoutInflater mInflater;
    private List<View> viewList = new ArrayList<View>();
    private Context context;
    // ====================================================================
    int id_row_layout;
    LayoutInflater layoutInflater;
    int selectedPosition = -1;
    int[] difColor = new int[2];
    public MyOnItemClickListener listener;
    private int lastViewsSize = -1;


    /**
     * Constructs a MyAdapter.This is like the constructor of SimpleAdapter.And this constructor set the background color of item.
     */
    public MyAdapter(
            Context context, List<? extends Map<String, ?>> data,
            int resource, String[] from, int[] to, int colorId, int color1Id
    )
    {
        this.context = context;
        mData = data;
        mResource = resource;
        mFrom = from;
        mTo = to;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        difColor[0] = context.getResources().getColor(colorId);
        difColor[1] = context.getResources().getColor(color1Id);
    }

    /**
     * Constructs a MyAdapter.This is like the constructor of SimpleAdapter.
     */
    public MyAdapter(
            Context context, List<? extends Map<String, ?>> data,
            int resource, String[] from, int[] to
    )
    {
        this.context = context;
        mData = data;
        mResource = resource;
        mFrom = from;
        mTo = to;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return mData.size();
    }

    @Override
    public Object getItem(int position)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    public void setSelectedPosition(int position)
    {
        this.selectedPosition = position;
    }

    /**
     * Like the function of SimpleAdapter.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        View v = createViewFromResource(position, convertView, parent, mResource);
        if (lastViewsSize == viewList.size())
        {
            if (position != 0)
            {
                if (position == parent.getChildCount() && position == viewList.size() - 1)
                {
                    setWidth(v);
                }
            }
        }
        else
        {
            lastViewsSize = viewList.size();
        }
        return v;
    }

    private View createViewFromResource(
            int position, View convertView,
            ViewGroup parent, int resource
    )
    {
        View v;
        if (convertView == null)
        {
            v = mInflater.inflate(resource, parent, false);
            viewList.add(v);
        }
        else
        {
            v = convertView;
        }
        bindView(position, v);
        v.setBackgroundColor(difColor[position % 2]);
        return v;
    }

    // �������
    private void bindView(int position, View v)
    {
        // TODO Auto-generated method stub
        for (int i = 0; i < mFrom.length; i++)
        {
            final int line = position;
            final int row = i;
            TextView txt = (TextView) v.findViewById(mTo[i]);
            txt.setText((String) mData.get(position).get(mFrom[i]));
            txt.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    // TODO Auto-generated method stub
                    if (MyAdapter.this.listener != null)
                        MyAdapter.this.listener.OnItemClickListener(v, line,
                                row, 0);
                }
            });
        }
    }

    /**
     * This function is provided for MyListView to change the width of the column.
     *
     * @param column
     * @param width
     */
    public void setColumnWidth(int column, int width)
    {
        for (int i = 0; i < viewList.size(); i++)
        {
            View v = viewList.get(i);
            TextView txt = (TextView) v.findViewById(mTo[column]);
            txt.setLayoutParams(new LinearLayout.LayoutParams(width, txt
                    .getHeight()));
        }
    }

    @SuppressLint("NewApi")
    private void setWidth(View v)
    {
        //�������һ���������Ĵ���
        View v1 = viewList.get(0);
        for (int j = 1; j < viewList.size(); j++)
        {
            View v2 = viewList.get(j);
            for (int i = 0; i < mTo.length; i++)
            {
                final TextView txt = (TextView) v2.findViewById(mTo[i]);
                final TextView txt1 = (TextView) v1.findViewById(mTo[i]);
                txt.setLayoutParams(new LinearLayout.LayoutParams(txt1.getMeasuredWidth(), txt1.getMeasuredHeight()));
            }
        }
    }

    public void setMyOnItemClickListener(MyOnItemClickListener l)
    {
        this.listener = l;
    }

    public void setItemColor(int colorId, int color1Id)
    {
        difColor[0] = context.getResources().getColor(colorId);
        difColor[1] = context.getResources().getColor(color1Id);
    }
}
