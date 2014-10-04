package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import com.lidroid.xutils.HttpUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;

public abstract class BaseActivity extends ActionBarActivity {

	public Context appContext;
	public Activity activity;
	public ActionBar actionBar;
	public static boolean isLoad = false;
	public static int DEFAULT_OUT_TIME = 20 * 1000;
	public HttpUtils httpUtils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appContext = getApplicationContext();
		activity = this;
		httpUtils = new HttpUtils(DEFAULT_OUT_TIME);
		actionBar = getSupportActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		setContentView(R.layout.activity_main);
		String title = getActionBarTitle();
		if (!TextUtils.isEmpty(title)) {
			actionBar.setTitle(title);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		int cookie = PreferencesUtils.getInt(appContext, Constants.SP_PWD_NAME, Constants.SP_COOKIE);
		if (cookie == 1) {
			isLoad = true;
		} else {
			isLoad = false;
		}
		if (isLoad) {
			String mode = PreferencesUtils.getString(appContext, Constants.SP_PWD_NAME, Constants.SP_PWD);
			Intent intent = null;
			if (!TextUtils.isEmpty(mode)) {
				if (mode.equals("0")) {
					intent = new Intent(appContext, SetGestureActivity.class);
				} else if (mode.equals("1")) {
					intent = new Intent(appContext, SetNumActivity.class);
				}
				startActivity(intent);
			}
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	public abstract String getActionBarTitle();

	public abstract int getActivityId();

}
