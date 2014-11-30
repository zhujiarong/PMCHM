package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import com.example.pmchm.ui.NumericKeyboard;
import com.example.pmchm.ui.NumericKeyboard.OnNumberClick;
import com.example.pmchm.ui.PasswordTextView;
import com.example.pmchm.utils.ToastUtils;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class SetNumActivity extends BaseActivity {

	private TextView showInfo;
	private static boolean is_second_error;
	private static String fristSetPwd;
	NumericKeyboard nk;
	// 密码框
	private PasswordTextView et_pwd1, et_pwd2, et_pwd3, et_pwd4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_num);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		showInfo = (TextView) findViewById(R.id.tv_prompt);
		et_pwd1 = (PasswordTextView) findViewById(R.id.et_pwd1);
		et_pwd2 = (PasswordTextView) findViewById(R.id.et_pwd2);
		et_pwd3 = (PasswordTextView) findViewById(R.id.et_pwd3);
		et_pwd4 = (PasswordTextView) findViewById(R.id.et_pwd4);
		nk = (NumericKeyboard) findViewById(R.id.nk);// 数字键盘
		// 监听最后一个密码框的文本改变事件回调
		et_pwd4.setOnTextChangedListener(new PasswordTextView.OnTextChangedListener() {
			@Override
			public void textChanged(String content) {
				String input = et_pwd1.getTextContent() + et_pwd2.getTextContent()+
						et_pwd3.getTextContent() + et_pwd4.getTextContent();
				handlePwd(input);
			}
		});
		// 设置点击的按钮回调事件
		nk.setOnNumberClick(new OnNumberClick() {
			@Override
			public void onNumberReturn(int number) {
				// 设置显示密码
				setText(number + "");
			}
		});
		initPrompt();
	}

	/**
	 * 设置显示的密码
	 * 
	 * @param text
	 */
	private void setText(String text) {
		// 从左往右依次显示
		if (TextUtils.isEmpty(et_pwd1.getTextContent())) {
			et_pwd1.setTextContent(text);
		} else if (TextUtils.isEmpty(et_pwd2.getTextContent())) {
			et_pwd2.setTextContent(text);
		} else if (TextUtils.isEmpty(et_pwd3.getTextContent())) {
			et_pwd3.setTextContent(text);
		} else if (TextUtils.isEmpty(et_pwd4.getTextContent())) {
			et_pwd4.setTextContent(text);
		}
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
			showInfo.setText("和第一次输入的密码不一致，重新输入");
			return;
		}
		if (TextUtils.isEmpty(fristSetPwd)) {
			showInfo.setText("请输入密码");
		} else {
			showInfo.setText("请再次确认密码");
		}
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
				PreferencesUtils.putString(getApplicationContext(), Constants.SP_NAME, Constants.SP_PWD_NUM, pwd);
				is_second_error = false;
				ToastUtils.showToast(appContext, "设置成功", 0);
				finish();
			} else {
				is_second_error = true;
				refreshView();
			}
			fristSetPwd = null;
		}
	}

	@Override
	public String getActionBarTitle() {
		return getResources().getString(R.string.title_input_secret);
	}

	@Override
	public int getActivityId() {
		return Constants.AC_SET_NUMBER;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
