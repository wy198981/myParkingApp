package com.example.administrator.myparkingos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.constant.ColumnName;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyAdapter;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyListView;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyOnItemClickListener;
import com.example.administrator.myparkingos.util.L;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017-03-07.
 */
public class CarChargeDetailFragment extends Fragment
{
    private int[] columns;
    private Activity mActivity;
    private HorizontalScrollView hs;
    private ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
    private MyAdapter adapter;
    private MyListView myLisView;
    private String[] from = new String[]{
            ColumnName.c1, ColumnName.c2, ColumnName.c3, ColumnName.c4, ColumnName.c5, ColumnName.c6, ColumnName.c7, ColumnName.c8
            , ColumnName.c9, ColumnName.c10, ColumnName.c11, ColumnName.c12, ColumnName.c13, ColumnName.c14, ColumnName.c15, ColumnName.c16
            , ColumnName.c17, ColumnName.c18, ColumnName.c19, ColumnName.c20, ColumnName.c21, ColumnName.c22, ColumnName.c23, ColumnName.c24
            , ColumnName.c25, ColumnName.c26, ColumnName.c27, ColumnName.c28, ColumnName.c29, ColumnName.c30, ColumnName.c31, ColumnName.c32
    };

    public CarChargeDetailFragment()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        mActivity = getActivity();

        View root = inflater.inflate(R.layout.parkmonitor_carchargedetail, container, false);
        hs = (HorizontalScrollView) root.findViewById(R.id.hs);
        columns = new int[]{
                R.id.column1, R.id.column2, R.id.column3,
                R.id.column4, R.id.column5, R.id.column6, R.id.column7,
                R.id.column8, R.id.column9, R.id.column10, R.id.column11,
                R.id.column12, R.id.column13, R.id.column14, R.id.column15, R.id.column16,

                R.id.column17, R.id.column18, R.id.column19,
                R.id.column20, R.id.column21, R.id.column22, R.id.column23,
                R.id.column24, R.id.column25, R.id.column26, R.id.column27, R.id.column28,
                R.id.column29, R.id.column30, R.id.column31, R.id.column32
        };
        adapter = new MyAdapter(mActivity, items, R.layout.carcharge_item,
                from, columns, R.color.difColor3, R.color.difColor3);
        adapter.setMyOnItemClickListener(new MyOnItemClickListener()
        {
            @Override
            public void OnItemClickListener(
                    View view, int line, int row,
                    long id
            )
            {
                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, row + 1 + "/" + line, Toast.LENGTH_SHORT).show();
                Log.i("touch", row + "/" + (line + 1));

            }
        });
        myLisView = new MyListView(mActivity, hs, columns, R.id.hs, R.id.list, R.id.head, adapter);
//        myLisView.setHeadColor(R.color.headColor);

        return root;
    }

    /**
     * 重新更新数据
     *
     * @param inItems
     */
    public void setData(ArrayList<HashMap<String, String>> inItems)
    {
        if (inItems == null || inItems.size() <= 0)
        {
            return;
        }
        items.clear();
        items.addAll(inItems);
        if (adapter == null) // adapter还没有显示出来
        {
            L.i("setJiHaoData(ArrayList<HashMap<String, String>> inItems)");
        }
        else
        {
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 设置每一列标题和内容等宽
     *
     * @param index
     * @param columnsWidth
     */
    public void setColumnsWidth(int index, int columnsWidth)
    {
        View viewById = hs.findViewById(columns[index]);
        viewById.setLayoutParams(new LinearLayout.LayoutParams(columnsWidth, viewById.getMeasuredHeight()));
        adapter.setColumnWidth(index, columnsWidth);
    }
}
