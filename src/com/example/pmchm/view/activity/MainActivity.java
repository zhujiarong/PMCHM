package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {

	private ListView list_item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list_item = (ListView) findViewById(R.id.lv_main);
		list_item.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				convertView = View.inflate(appContext, R.layout.item_main, null);
				return convertView;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public int getCount() {
				return 2;
			}
		});
		list_item.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(appContext, DescrptionActivity.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		MenuItem menu_load = menu.findItem(R.id.menu_load);
		if (menu_load != null && isLoad) {
			menu_load.setVisible(false);
		} else {
			menu_load.setVisible(true);
		}
		return true;
	}

	@Override
	public String getActionBarTitle() {
		return "首页";
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		if (item.getItemId() == R.id.menu_load) {
			intent = new Intent(appContext, LoginActivity.class);
		} else if (item.getItemId() == R.id.menu_my) {
			intent = new Intent(appContext, MyActivity.class);
		} else {
			intent = new Intent(appContext, SetingActivity.class);
		}
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
	@Override
	public int getActivityId() {
		return Constants.AC_MAIN;
	}
}
