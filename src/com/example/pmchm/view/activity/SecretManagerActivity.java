package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecretManagerActivity extends BaseActivity {

	private TextView tv_mode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appContext = getApplicationContext();
		setContentView(R.layout.activity_secret_manager);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		tv_mode = (TextView) findViewById(R.id.tv_mode);
	}

	public void click1(View v) {
		new AlertDialog.Builder(this).setTitle("选择锁定方式")
				.setSingleChoiceItems(new String[] { "数字短密码", "划屏密码", }, -1, new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (which == 0) {
							PreferencesUtils.putInt(getApplicationContext(), Constants.SP_NAME,
									Constants.SP_VER_MODE, Constants.VERIFICATION_NUM);
							tv_mode.setText("数字短密码");
							dialog.dismiss();
						} else {
							PreferencesUtils.putInt(getApplicationContext(), Constants.SP_NAME,
									Constants.SP_VER_MODE, Constants.VERIFICATION_GES);
							tv_mode.setText("划屏密码");
							dialog.dismiss();
						}
					}
				}).show();
	}

	public void click2(View v) {
		Intent intent = new Intent(appContext, SetNumActivity.class);
		startActivity(intent);
	}

	public void click3(View v) {
		Intent intent = new Intent(appContext, SetGestureActivity.class);
		startActivity(intent);
	}

	@Override
	public String getActionBarTitle() {
		return "APP密码管理";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_SECRET_MANAGER;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
