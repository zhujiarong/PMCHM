package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
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
			public View getView(int position, View convertView, ViewGroup parent) {
				if (convertView == null)
					convertView = View.inflate(appContext, R.layout.item_seting, null);
				final ImageView view = (ImageView) convertView.findViewById(R.id.iv_swith);
				TextView textView = (TextView) convertView.findViewById(R.id.tv_name);
				if(position==0){
					textView.setText("环保局每日数据通知");
				}else if(position ==1){
					textView.setText("美国大使馆每日数据通知");
				}else{
					textView.setText("设备数据超标报警通知");
				}
				view.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
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
