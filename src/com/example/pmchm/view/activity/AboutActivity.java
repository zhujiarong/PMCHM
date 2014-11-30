package com.example.pmchm.view.activity;

import android.os.Bundle;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;

public class AboutActivity extends BaseActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appContext = getApplicationContext();
		setContentView(R.layout.activity_about);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
	}

	@Override
	public String getActionBarTitle() {
		return "关于";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_ABOUT;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
