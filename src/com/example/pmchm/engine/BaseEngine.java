package com.example.pmchm.engine;

import com.lidroid.xutils.HttpUtils;

public class BaseEngine {

	private static BaseEngine instance = new BaseEngine();
	public HttpUtils httpUtils;

	public BaseEngine() {
		httpUtils = new HttpUtils();
	}

	public static BaseEngine getInstance() {
		return instance;
	}
}
