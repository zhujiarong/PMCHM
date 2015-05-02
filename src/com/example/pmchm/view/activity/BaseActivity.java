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
	public static boolean isShow = false;
	public static int DEFAULT_OUT_TIME = 20 * 1000;
	public HttpUtils httpUtils;
	private static long startedActivityCount = 0l;

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
		int icon = getActionBarIcon();
		if (icon > 0) {
			actionBar.setIcon(icon);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		startedActivityCount++;
		if (1 == startedActivityCount && !isShow) {
			handleVerification();
		}
		isShow = false;
	}

	private void handleVerification() {
		int cookie = PreferencesUtils.getInt(appContext, Constants.SP_NAME, Constants.SP_COOKIE);
		if (cookie == 1) {
			isLoad = true;
		} else {
			isLoad = false;
		}
		if (isLoad) {
			int mode = PreferencesUtils.getInt(appContext, Constants.SP_NAME, Constants.SP_VER_MODE);
			Intent intent = null;
			if (mode >= 0) {
				if (mode == 0) {
					String pwd = PreferencesUtils.getString(appContext, Constants.SP_NAME, Constants.SP_PWD_NUM);
					if (!TextUtils.isEmpty(pwd)) {
						intent = new Intent(appContext, VerificationOfNumActivity.class);
					}
				} else if (mode == 1) {
					String pwd = PreferencesUtils.getString(appContext, Constants.SP_NAME, Constants.SP_PWD_GES);
					if (!TextUtils.isEmpty(pwd)) {
						intent = new Intent(appContext, VerificationOfNineBoxActivity.class);
					}
				}
				if (intent != null)
					startActivityForResult(intent, 0);
			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 0)
			isShow = true;
	}

	@Override
	protected void onStop() {
		super.onStop();
		startedActivityCount--;
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

	public abstract int getActionBarIcon();

}
