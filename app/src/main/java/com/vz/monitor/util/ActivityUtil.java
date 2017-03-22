package com.vz.monitor.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ActivityUtil {
	

	public static final void invoke(Activity activity, Class<?> clazz) {
		Intent intent = new Intent(activity, clazz);
		activity.startActivity(intent);
	}

	public static final void invokeWithArgs(Activity activity, Class<?> clazz, Bundle bundle) {
		Intent intent = new Intent(activity, clazz);
		intent.putExtra("bundle", bundle);
		activity.startActivity(intent);
	}

}
