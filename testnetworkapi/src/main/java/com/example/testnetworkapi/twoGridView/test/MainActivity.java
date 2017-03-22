package com.example.testnetworkapi.twoGridView.test;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import com.example.testnetworkapi.ProgressBarAsyncTask;
import com.example.testnetworkapi.R;
import com.example.testnetworkapi.twoGridView.TwoWayAdapterView;
import com.example.testnetworkapi.twoGridView.TwoWayGridView;


public class MainActivity extends Activity
{
    private static final String TAG = "MainActivity";

    private Cursor mImageCursor;
    private ImageThumbnailAdapter mAdapter;
    private TwoWayGridView mImageGrid;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initGrid();
    }


    private void initGrid()
    {
        mImageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                ImageThumbnailAdapter.IMAGE_PROJECTION, null, null,
                MediaStore.Images.ImageColumns.DISPLAY_NAME);
        mImageGrid = (TwoWayGridView) findViewById(R.id.gridview);
        mAdapter = new ImageThumbnailAdapter(this, mImageCursor);
        mImageGrid.setAdapter(mAdapter);

        mImageGrid.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener()
        {
            public void onItemClick(TwoWayAdapterView parent, View v, int position, long id)
            {
                Log.i(TAG, "showing image: " + mImageCursor.getString(ImageThumbnailAdapter.IMAGE_NAME_COLUMN));
                Uri uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mAdapter.cleanup();

        // AsyncTask 本身就显示了多线程；
//        new AsyncTask(); // 只需要再次封装即可； 把多个 url投递到线程中，并在结束的时候，更新控件即可



    }


}