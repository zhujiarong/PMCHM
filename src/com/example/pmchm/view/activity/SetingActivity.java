package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.common.PreferencesUtils;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SetingActivity extends BaseActivity {

	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seting);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		listView = (ListView) findViewById(R.id.lv_seting);
		listView.setAdapter(new BaseAdapter() {
			@Override
			public View getView(final int position, View convertView, ViewGroup parent) {
				if (convertView == null)
					convertView = View.inflate(appContext, R.layout.item_seting, null);
				final ImageView view = (ImageView) convertView.findViewById(R.id.iv_swith);
				TextView textView = (TextView) convertView.findViewById(R.id.tv_name);
				boolean isOpen = true;
				if(position==0){
					textView.setText("环保局每日数据通知");
					isOpen = PreferencesUtils.getBoolean(appContext,Constants.SP_HUANBAOJU, true);
				}else if(position ==1){
					textView.setText("美国大使馆每日数据通知");
					isOpen = PreferencesUtils.getBoolean(appContext,Constants.SP_US_EMBASSY, true);
				}else{
					textView.setText("设备数据超标报警通知");
					isOpen = PreferencesUtils.getBoolean(appContext,Constants.SP_ALARM, true);
				}
				if(!isOpen){
					view.setImageResource(R.drawable.icon_setting_switcher_off);
				}
				view.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						boolean bl;
						if(position==0){
							bl = PreferencesUtils.getBoolean(appContext,Constants.SP_HUANBAOJU, true);
							if(!bl){
								PreferencesUtils.putBoolean(appContext, Constants.SP_HUANBAOJU, true);
							}else{
								PreferencesUtils.putBoolean(appContext, Constants.SP_HUANBAOJU, false);
							}
						}else if(position ==1){
							bl = PreferencesUtils.getBoolean(appContext,Constants.SP_US_EMBASSY, true);
							if(!bl){
								PreferencesUtils.putBoolean(appContext, Constants.SP_US_EMBASSY, true);
							}else{
								PreferencesUtils.putBoolean(appContext, Constants.SP_US_EMBASSY, false);
							}
						}else{
							bl = PreferencesUtils.getBoolean(appContext,Constants.SP_ALARM, true);
							if(!bl){
								PreferencesUtils.putBoolean(appContext, Constants.SP_ALARM, true);
							}else{
								PreferencesUtils.putBoolean(appContext, Constants.SP_ALARM, false);
							}
						}
						if(!bl){
							view.setImageResource(R.drawable.icon_setting_switcher_on);
						}else{
							view.setImageResource(R.drawable.icon_setting_switcher_off);
						}
					}
				});
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public int getCount() {
				return 3;
			}
		});
	}

	@Override
	public String getActionBarTitle() {
		return "设置";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_SET;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
