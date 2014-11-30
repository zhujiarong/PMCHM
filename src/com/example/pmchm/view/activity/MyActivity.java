package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
	}

	public void click1(View v) {
		Intent intent = new Intent(appContext, DevicesManagerActivity.class);
		startActivity(intent);
	}

	public void click2(View v) {
		//TODO 检查更新
	}

	public void click3(View v) {
		Intent intent = new Intent(appContext, AboutActivity.class);
		startActivity(intent);
	}

	public void click4(View v) {
		Intent intent = new Intent(appContext, UpdatePwdActivity.class);
		startActivity(intent);
	}
	public void click5(View v) {
		Intent intent = new Intent(appContext, SecretManagerActivity.class);
		startActivity(intent);
	}

	@Override
	public String getActionBarTitle() {
		return "我的";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_MY;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
