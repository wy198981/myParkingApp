package com.vz.monitor.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
	
	/**
	 * 网络是否已连接
	 * @param context
	 * @return 已连接：true; 未连接：false
	 */
	public static final boolean isNetworkConnected(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if(null != info) {
			return info.isConnected();
		}
		return false;
	}

	/**
	 * Wifi网络是否已连接
	 * @param context
	 * @return 已连接：true; 未连接：false
	 */
	public static final boolean isWifiConnected(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if(null != info && info.isConnected()) {
			return info.getType() == ConnectivityManager.TYPE_WIFI;
		}
		return false;
	}

	/**
	 * Mobile网络是否已连接
	 * @param context
	 * @return 已连接：true; 未连接：false
	 */
	public static final boolean isMobileConnected(Context context) {
		NetworkInfo info = getNetworkInfo(context);
		if(null != info && info.isConnected()) {
			return info.getType() == ConnectivityManager.TYPE_MOBILE;
		}
		return false;
	}

	/**
	 * 获得网络信息
	 * @param context
	 * @return 
	 */
	private static final NetworkInfo getNetworkInfo(Context context) {
		ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(null != connManager) {
			return connManager.getActiveNetworkInfo();
		}
		return null;
	}
	
}
