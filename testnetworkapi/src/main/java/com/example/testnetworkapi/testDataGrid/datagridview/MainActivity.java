package com.example.testnetworkapi.testDataGrid.datagridview;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.testnetworkapi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
{
    private DataGridView dataGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainok);
        dataGridView = (DataGridView) findViewById(R.id.datagridview);
        loadData();
    }

    private void loadData()
    {
//        SQLiteDatabase db = new DBHelper(this).getWritableDatabase();
//
//        Cursor cursor = db.query("nationlist", null, null, null, null, null, null);
//
//        List<List<String>> result = null;
//        if (cursor != null && cursor.moveToFirst())
//        {
//            result = getTableRows(cursor);
//            cursor.close();
//        }
//        db.close();
        List<List<String>> result = new ArrayList<List<String>>();

        for (int i = 0; i < 100; i++)
        {
            List<String> item = new ArrayList<String>();
            if (i == 0)//第一列是标题;
            {
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
                item.add("标题" + i);
            }
            else if (i == 1)
            {
                item.add("数据" + i * 3);
                item.add("数据" + i);
                item.add("数据" + i);
                item.add("数据" + i * 12121212);
            }
            result.add(item);
        }

        dataGridView.setData(result, false);
    }

    private List<List<String>> getTableRows(Cursor cursor)
    {

        List<List<String>> rows = new ArrayList<>();
        List<String> header = new ArrayList<>();

        for (int col = 0; col < cursor.getColumnCount(); col++)
        {
            header.add(cursor.getColumnName(col));
        }
        rows.add(header);

        if (cursor.getCount() == 0)
        {
            return rows;
        }

        do
        {
            List<String> row = new ArrayList<>();
            for (int col = 0; col < cursor.getColumnCount(); col++)
            {
                String strData = cursor.getString(col);
                row.add(strData);
            }
            rows.add(row);
        }
        while (cursor.moveToNext());
        return rows;
    }
}
