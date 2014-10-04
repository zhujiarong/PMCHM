package com.example.pmchm.common;

import java.util.Map;
import java.util.Set;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferencesUtils {

	private final static String DEFAULT_SPNAME = "prefrence.sp";
	private final static String DEFAULT_STR_VALUE = "";
	private final static int DEFAULT_INT_VALUE = -1;
	
	// 保存string类型数据
	public static boolean putString(Context context, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(DEFAULT_SPNAME, Context.MODE_PRIVATE);
		return sp.edit().putString(key, value).commit();
	}
	// 保存string类型数据
	public static boolean putBoolean(Context context, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(DEFAULT_SPNAME, Context.MODE_PRIVATE);
		return sp.edit().putBoolean(key, value).commit();
	}
	// 保存string类型数据
	public static boolean putBoolean(Context context,String apName, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(apName, Context.MODE_PRIVATE);
		return sp.edit().putBoolean(key, value).commit();
	}
	// 保存string类型数据
	public static boolean getBoolean(Context context,String apName, String key, boolean value) {
		SharedPreferences sp = context.getSharedPreferences(apName, Context.MODE_PRIVATE);
		return sp.getBoolean(key, value);
	}
	
	// 保存int类型数据
	public static boolean putInt(Context context, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(DEFAULT_SPNAME, Context.MODE_PRIVATE);
		return sp.edit().putInt(key, value).commit();
	}

	// 获取string类型数据
	public static String getString(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(DEFAULT_SPNAME, Context.MODE_PRIVATE);
		return sp.getString(key, DEFAULT_STR_VALUE);
	}

	// 获取int类型数据 默认值-1
	public static int getInt(Context context, String key) {
		SharedPreferences sp = context.getSharedPreferences(DEFAULT_SPNAME, Context.MODE_PRIVATE);
		return sp.getInt(key, DEFAULT_INT_VALUE);
	}

	public static boolean putString(Context context, String spName, String key, String value) {
		SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
		return sp.edit().putString(key, value).commit();
	}

	public static boolean putInt(Context context, String spName, String key, int value) {
		SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
		return sp.edit().putInt(key, value).commit();
	}

	public static String getString(Context context, String spName, String key) {
		SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
		return sp.getString(key, DEFAULT_STR_VALUE);
	}

	public static int getInt(Context context, String spName, String key) {
		SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
		return sp.getInt(key, DEFAULT_INT_VALUE);
	}

	public static boolean putMap(Context context, String spName, Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			SharedPreferences sp = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
			Editor edit = sp.edit();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				if (entry.getValue() instanceof Integer) {
					edit.putInt(entry.getKey(), (Integer) entry.getValue());
				} else {
					edit.putString(entry.getKey(), (String) entry.getValue());
				}
			}
			return edit.commit();
		}
		return false;
	}
}
