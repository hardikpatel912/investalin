package com.investallign.utils;

import android.util.Log;

import com.investallign.BuildConfig;


public class Logger {

	private final static boolean SHOW_LOG = BuildConfig.DEBUG;

	public static void printLog(final String TAG, final String message) {
		if (SHOW_LOG) {
			Log.d("", TAG + " :==> " + message);
		}
	}
}
