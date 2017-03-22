package com.vz.monitor.util;

import java.io.File;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;

public class Utility {
	/**
	 * 获取AndroidManifest.xml文件中的android:versionName字段的版本名
	 * @param context 上下文
	 * @return	版本名
     */
    public static final String getVersionName(Context context) {
    	try {
			PackageManager manager = context.getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
			return info.versionName;
    	} catch (Exception e) {
			return "";
		}
    }

    /**
     * 是否有SDCard
     * @return 有，true  没有，false
     */
    public static final boolean hasSDCard() {
    	if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
    		return true;
    	}
    	return false;
    }

    /**
     * 获取SDCard的可用空间
     * @return 可用空间，单位为MB
     */
    public static final long getSDCardAvailableSize(){
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long freeBlocks = sf.getAvailableBlocks();
        //return freeBlocks * blockSize;  //单位Byte
        //return (freeBlocks * blockSize)/1024;   //单位KB
        return (freeBlocks * blockSize) /1024 /1024; //单位MB
    }  
}
