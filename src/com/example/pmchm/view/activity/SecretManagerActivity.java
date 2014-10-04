package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SecretManagerActivity extends ActionBarActivity {

	private static Context appContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appContext = getApplicationContext();
		setContentView(R.layout.activity_secret_manager);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("APP密码管理");
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	public void click1(View v) {
		Intent intent = new Intent(appContext, SetNumActivity.class);
		startActivity(intent);
	}

	public void click2(View v) {
		Intent intent = new Intent(appContext, SetGestureActivity.class);
		startActivity(intent);
	}
}
