package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import com.example.pmchm.ui.NinePointLineView;
import com.example.pmchm.ui.NinePointLineView.OnGestureListener;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SetGestureActivity extends BaseActivity {

	private LinearLayout nine_con;
	private NinePointLineView nv;
	private TextView showInfo;
	private static boolean is_second_error;
	private static String fristSetPwd;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture);
		nv = new NinePointLineView(SetGestureActivity.this, true);
		nv.setOnGestureListener(new OnGestureListener() {
			@Override
			public void onGesture(String pwd) {
				handlePwd(pwd);
			}
		});
		nine_con = (LinearLayout) findViewById(R.id.nine_con);
		nine_con.addView(nv);
		showInfo = (TextView) findViewById(R.id.show_set_info);
		initPrompt();
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

	private void refreshView() {
		finish();
		Intent intent = new Intent(getApplicationContext(), SetGestureActivity.class);
		startActivity(intent);
	}

	public void handlePwd(String pwd) {
		if (TextUtils.isEmpty(fristSetPwd)) {
			fristSetPwd = pwd;
			is_second_error = false;
			refreshView();
		} else {
			if (fristSetPwd.equals(pwd)) {
				PreferencesUtils.putString(getApplicationContext(), Constants.SP_PWD_NAME, Constants.SP_PWD, pwd);
				PreferencesUtils.putInt(getApplicationContext(), Constants.SP_PWD_NAME, Constants.SP_VER_MODE, 0);
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

	@Override
	public String getActionBarTitle() {
		return getResources().getString(R.string.title_input_gesture);
	}

	@Override
	public int getActivityId() {
		return Constants.AC_GESTURE;
	}
}
