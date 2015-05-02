package com.example.pmchm.view.activity;

import java.util.List;
import com.example.pmchm.R;
import com.example.pmchm.bean.MainInfo;
import com.example.pmchm.common.Constants;
import com.example.pmchm.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener {

	private ListView list_item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list_item = (ListView) findViewById(R.id.lv_main);
		View header_load = View.inflate(getApplicationContext(), R.layout.header_main_load, null);
		header_load.findViewById(R.id.ll_main_header_load).setOnClickListener(this);
		list_item.addHeaderView(header_load);
		View header_office = View.inflate(getApplicationContext(), R.layout.header_main_office, null);
		header_office.findViewById(R.id.ll_main_header_office).setOnClickListener(this);
		list_item.addHeaderView(header_office);

		list_item.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				convertView = View.inflate(appContext, R.layout.item_main, null);
				if (position == 1) {
					TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
					TextView tv_catch_time = (TextView) convertView.findViewById(R.id.tv_catch_time);
					TextView tv_pm25_value = (TextView) convertView.findViewById(R.id.tv_pm25_value);
					TextView tv_co2_value = (TextView) convertView.findViewById(R.id.tv_co2_value);
					tv_catch_time.setText("12:00");
					tv_title.setText("南广场");
					tv_pm25_value.setText("276");
					tv_co2_value.setText("65.22%");
				}
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
				return 3;
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
	protected void onStart() {
		super.onStart();
		if (isLoad) {
			// TODO 登录
		} else {
			// TODO 未登录
		}
		httpUtils.send(HttpMethod.POST, Constants.URL_DATA, new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO
				System.out.println("onSuccess =" + responseInfo.result);
				Gson json = new Gson();
				List<MainInfo> mainInfos = json.fromJson(responseInfo.result, new TypeToken<List<MainInfo>>() {
				}.getType());
				System.out.println(mainInfos);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				// TOOD
				System.out.println("onFailure =" + msg);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public String getActionBarTitle() {
		return "首页";
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		if (item.getItemId() == R.id.menu_refresh) {
			ToastUtils.showToast(getApplicationContext(), "refresh", 0);
		} else if (item.getItemId() == R.id.menu_my) {
			intent = new Intent(appContext, MyActivity.class);
			startActivity(intent);
		} else {
			intent = new Intent(appContext, SetingActivity.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public int getActivityId() {
		return Constants.AC_MAIN;
	}

	@Override
	public int getActionBarIcon() {
		return 0;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.ll_main_header_load) {
			ToastUtils.showToast(getApplicationContext(), "点击登录", 0);
			Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(intent);
		} else if (id == R.id.ll_main_header_office) {
			ToastUtils.showToast(getApplicationContext(), "点击环保局", 0);
		}
	}
}
