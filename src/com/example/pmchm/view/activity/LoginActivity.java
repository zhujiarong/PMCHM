package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import com.example.pmchm.utils.PromptManager;
import com.example.pmchm.utils.ToastUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {

	private EditText et_account;
	private EditText et_passward;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		et_account = (EditText) findViewById(R.id.et_account);
		et_passward = (EditText) findViewById(R.id.et_passward);
	}

	@Override
	public String getActionBarTitle() {
		return "登录";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_LOAD;
	}

	public void on_load(View v) {
		final String account = et_account.getText().toString();
		final String passward = et_passward.getText().toString();
		if (TextUtils.isEmpty(account)) {
			ToastUtils.showToast(appContext, "账号不能为空！", 0);
			return;
		}
		if (TextUtils.isEmpty(passward)) {
			ToastUtils.showToast(appContext, "密码不能为空！", 0);
			return;
		}
		RequestParams params = new RequestParams();
		PromptManager.showProgressDialog(activity);
		httpUtils.send(HttpMethod.POST, Constants.URL_LOGIN, params, new RequestCallBack<String>() {
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				PromptManager.closeProgressDialog();
				System.out.println("onSuccess" + responseInfo.result);
				if (responseInfo.statusCode == 200) {
					PreferencesUtils.putInt(appContext, Constants.SP_NAME, Constants.SP_COOKIE, 1);
					PreferencesUtils.putString(appContext, Constants.SP_NAME, Constants.SP_ACCOUNT_NAME, account);
					ToastUtils.showToast(appContext, "登录成功!", 0);
					finish();
				} else if (responseInfo.statusCode == 1001) {
					ToastUtils.showToast(appContext, "密码错误请重试！", 0);
				} else if (responseInfo.statusCode == 1003) {
					ToastUtils.showToast(appContext, "用户名不存在！", 0);
				}
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				PreferencesUtils.putInt(appContext, Constants.SP_NAME, Constants.SP_COOKIE, 1);
				PromptManager.closeProgressDialog();
				System.out.println("onFailure  = " + msg);
				int exceptionCode = error.getExceptionCode();
				System.out.println(exceptionCode);
				if (exceptionCode == 1001) {
					ToastUtils.showToast(appContext, "密码错误请重试！", 0);
				} else if (exceptionCode == 1003) {
					ToastUtils.showToast(appContext, "用户名不存在！", 0);
				} else {
					ToastUtils.showToast(appContext, "登录失败请重试!", 0);
				}
				//TODO
				PreferencesUtils.putInt(appContext, Constants.SP_NAME, Constants.SP_COOKIE, 1);
				PreferencesUtils.putString(appContext, Constants.SP_NAME, Constants.SP_ACCOUNT_NAME, "renjianhui");
				finish();
			}
		});
	}

	public void on_wjmm(View v) {
		Intent intent = new Intent(appContext, FindPwdActivity.class);
		startActivity(intent);
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
