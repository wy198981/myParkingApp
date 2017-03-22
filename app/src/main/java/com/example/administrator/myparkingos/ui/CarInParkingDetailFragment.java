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
public class CarInParkingDetailFragment extends Fragment
{

    private int[] columns;
    private Activity mActivity;
    private HorizontalScrollView hs;
    private ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
    private MyListView myLisView = null;
    private String[] from = new String[]{
            ColumnName.c1, ColumnName.c2, ColumnName.c3, ColumnName.c4, ColumnName.c5, ColumnName.c6, ColumnName.c7, ColumnName.c8
            , ColumnName.c9, ColumnName.c10, ColumnName.c11, ColumnName.c12, ColumnName.c13, ColumnName.c14, ColumnName.c15, ColumnName.c16
    };

    private MyAdapter adapter = null;

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

        View root = inflater.inflate(R.layout.parkmonitor_carinparkingdetail, container, false);
        hs = (HorizontalScrollView) root.findViewById(R.id.hs);

        items = new ArrayList<HashMap<String, String>>();
        columns = new int[]{
                R.id.column1, R.id.column2, R.id.column3,
                R.id.column4, R.id.column5, R.id.column6, R.id.column7,
                R.id.column8, R.id.column9, R.id.column10, R.id.column11,
                R.id.column12, R.id.column13, R.id.column14, R.id.column15, R.id.column16
        };
        adapter = new MyAdapter(mActivity, items, R.layout.carinparking_item,
                from, columns, R.color.difColor3, R.color.difColor3);
        adapter.setMyOnItemClickListener(new MyOnItemClickListener()
        {
            @Override
            public void OnItemClickListener(
                    View view, int line, int row,
                    long id
            )
            {
//                Toast.makeText(MainActivity.this, row + 1 + "/" + line, Toast.LENGTH_SHORT).show();
                Log.i("touch", row + "/" + (line + 1));

            }
        });
        myLisView = new MyListView(mActivity, hs, columns, R.id.hs, R.id.list, R.id.head, adapter);
//        myLisView.setHeadColor(R.color.headColor);
//        myLisView.setSizeWithPost(hs);
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
        adapter.notifyDataSetChanged();
    }

    /**
     * 设置每一列标题和内容等宽
     * @param index
     * @param columnsWidth
     */
    public void setColumnsWidth(int index, int columnsWidth)
    {
        View viewById = hs.findViewById(columns[index]);
        L.i("setColumnsWidth:" + columnsWidth);
        viewById.setLayoutParams(new LinearLayout.LayoutParams(columnsWidth, viewById.getMeasuredHeight()));
        adapter.setColumnWidth(index, columnsWidth);
    }
}
