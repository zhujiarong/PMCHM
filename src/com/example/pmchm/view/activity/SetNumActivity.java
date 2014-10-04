package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SetNumActivity extends ActionBarActivity {

	private TextView showInfo;
	private static boolean is_second_error;
	private static String fristSetPwd;
	private EditText et_num1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_num);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(R.string.title_input_secret);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		showInfo = (TextView) findViewById(R.id.tv_prompt);
		et_num1 = (EditText) findViewById(R.id.et_num1);
		initPrompt();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void initPrompt() {
		if (is_second_error) {
			showInfo.setText("和第一次输入手势密码不一致，重新输入");
			return;
		}
		if (TextUtils.isEmpty(fristSetPwd)) {
			showInfo.setText("请设置手势密码");
		} else {
			showInfo.setText("请再次确认手势密码");
		}
	}
	
	public void click2(View v) {
		String pwd = et_num1.getText().toString();
		handlePwd(pwd);
	}
	
	private void refreshView() {
		finish();
		Intent intent = new Intent(getApplicationContext(), SetNumActivity.class);
		startActivity(intent);
	}
	
	private void handlePwd(String pwd) {

		if (TextUtils.isEmpty(fristSetPwd)) {
			fristSetPwd = pwd;
			is_second_error = false;
			refreshView();
		} else {
			if (fristSetPwd.equals(pwd)) {
				PreferencesUtils.putString(getApplicationContext(), Constants.SP_PWD_NAME, Constants.SP_PWD, pwd);
				PreferencesUtils.putInt(getApplicationContext(), Constants.SP_PWD_NAME, Constants.SP_VER_MODE, 1);
				Intent intent = new Intent(getApplicationContext(), DescrptionActivity.class);
				startActivity(intent);
				is_second_error = false;
				finish();
			} else {
				is_second_error = true;
				refreshView();
			}
			fristSetPwd = null;
		}
	}
}
