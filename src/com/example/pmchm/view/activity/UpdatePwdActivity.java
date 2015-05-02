package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;

import android.os.Bundle;
import android.view.View;

public class UpdatePwdActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		setContentView(R.layout.activity_update_pwd);
	}
	
	public void click(View v) {
		//TODO  修改密码
	}
	
	@Override
	public String getActionBarTitle() {
		return "修改密码";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_UPDATE_PWD;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}

}
