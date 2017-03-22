package com.example.administrator.myparkingos.util;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.View;

/**
 * Created by Administrator on 2016/12/24.
 */
public class AppOperation
{
    public static void hideNavigationBar(Activity activity)
    {
        int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN; // hide status bar

        if (android.os.Build.VERSION.SDK_INT >= 19)
        {

            uiFlags |= 0x00001000;    //SYSTEM_UI_FLAG_IMMERSIVE_STICKY: hide navigation bars - compatibility:
            // building API level is lower thatn 19, use magic number directly for higher API target level
        }
        else
        {
            uiFlags |= View.SYSTEM_UI_FLAG_LOW_PROFILE;

        }

        activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);
    }


    public static void setOriention(Activity activity)
    {
        // 根据屏幕的尺寸大小来确定是否横竖屏显示
//        if (ScreenUtils.getScreenHeight(activity) > ScreenUtils.getScreenWidth(activity))
//        {
//            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横屏
//            L.i("widith:" + ScreenUtils.getScreenWidth(activity) + ",height:" + ScreenUtils.getScreenHeight(activity));
//        }
//        else
//        {
//            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 竖屏
//        }

//        L.i("width:" + ScreenUtils.getScreenWidth(activity) + ",height:" + ScreenUtils.getScreenHeight(activity));
        // 在平板上，width 大于 height
        if (ScreenUtils.getScreenWidth(activity) > ScreenUtils.getScreenHeight(activity))
        {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// 横屏
        }
        else
        {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏
        }
    }
}
