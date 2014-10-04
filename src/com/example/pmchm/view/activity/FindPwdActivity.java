package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;

import android.os.Bundle;
import android.view.View;

public class FindPwdActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		setContentView(R.layout.activity_find_pwd);
	}

	@Override
	public String getActionBarTitle() {
		return "找回密码";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_FIND_PWD;
	}

	public void click(View v) {
		// TODO 提交邮箱 找回密码
	}

}
