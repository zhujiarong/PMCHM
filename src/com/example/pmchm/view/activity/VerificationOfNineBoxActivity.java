package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import com.example.pmchm.ui.NinePointLineView;
import com.example.pmchm.ui.NinePointLineView.OnGestureListener;
import com.example.pmchm.utils.ToastUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.widget.LinearLayout;

public class VerificationOfNineBoxActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setTitle(R.string.title_input_gesture);
		NinePointLineView nv = new NinePointLineView(VerificationOfNineBoxActivity.this, true);
		nv.setOnGestureListener(new OnGestureListener() {
			@Override
			public void onGesture(String pwd) {
				handlePwd(pwd);
			}
		});
		LinearLayout nine_con = (LinearLayout) findViewById(R.id.nine_con);
		nine_con.addView(nv);
	}
	

	private void refreshView() {
		finish();
		Intent intent = new Intent(getApplicationContext(), VerificationOfNineBoxActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(false); 
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	private void handlePwd(String pwd) {
		String sp_pwd = PreferencesUtils
				.getString(getApplicationContext(), Constants.SP_NAME, Constants.SP_PWD_GES);
		if (pwd.equals(sp_pwd)) {
			finish();
		} else {
			refreshView();
			ToastUtils.showToast(getApplicationContext(), "密码错误请重试！", 0);
		}
	}
}
