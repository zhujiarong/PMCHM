package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import com.example.pmchm.ui.NumericKeyboard;
import com.example.pmchm.ui.PasswordTextView;
import com.example.pmchm.ui.NumericKeyboard.OnNumberClick;
import com.example.pmchm.utils.ToastUtils;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;

public class VerificationOfNumActivity extends ActionBarActivity {

	private NumericKeyboard nk;
	// 密码框
	private PasswordTextView et_pwd1, et_pwd2, et_pwd3, et_pwd4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_num);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle(R.string.title_input_secret);
		et_pwd1 = (PasswordTextView) findViewById(R.id.et_pwd1);
		et_pwd2 = (PasswordTextView) findViewById(R.id.et_pwd2);
		et_pwd3 = (PasswordTextView) findViewById(R.id.et_pwd3);
		et_pwd4 = (PasswordTextView) findViewById(R.id.et_pwd4);
		nk = (NumericKeyboard) findViewById(R.id.nk);// 数字键盘
		// 监听最后一个密码框的文本改变事件回调
		et_pwd4.setOnTextChangedListener(new PasswordTextView.OnTextChangedListener() {
			@Override
			public void textChanged(String content) {
				String input = et_pwd1.getTextContent() + et_pwd2.getTextContent() + et_pwd3.getTextContent()
						+ et_pwd4.getTextContent();
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
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(false);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void handlePwd(String pwd) {
		if (TextUtils.isEmpty(pwd)) {
			ToastUtils.showToast(getApplicationContext(), "请输入数字密码！", 0);
		} else {
			String sp_pwd = PreferencesUtils
					.getString(getApplicationContext(), Constants.SP_NAME, Constants.SP_PWD_NUM);
			if (pwd.equals(sp_pwd)) {
				finish();
			} else {
				ToastUtils.showToast(getApplicationContext(), "密码错误请重试！", 0);
			}
		}
	}
}
