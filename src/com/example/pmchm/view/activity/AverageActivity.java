package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.utils.DensityUtil;
import com.example.pmchm.utils.ToastUtils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;

public class AverageActivity extends BaseActivity {

	private ListView lv_average;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_average);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);

		SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.average_list,
				android.R.layout.simple_spinner_dropdown_item);
		// 将ActionBar的操作模型设置为NAVIGATION_MODE_LIST
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		// 为ActionBar设置下拉菜单和监听器
		actionBar.setListNavigationCallbacks(adapter, new DropDownListenser());

		lv_average = (ListView) findViewById(R.id.lv_average);
		lv_average.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				RelativeLayout rl = (RelativeLayout) View.inflate(appContext, R.layout.item_average, null);
				View view = new View(appContext);
				view.setBackgroundColor(Color.parseColor("#ddFEDADB"));
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(140 * (1 + arg0), DensityUtil.dip2px(
						getApplicationContext(), 80)); // , 1是可选写的
				view.setLayoutParams(lp);
				rl.addView(view);
				return rl;
			}

			@Override
			public long getItemId(int arg0) {
				return 0;
			}

			@Override
			public Object getItem(int arg0) {
				return null;
			}

			@Override
			public int getCount() {
				return 7;
			}
		});
	}

	/**
	 * 实现 ActionBar.OnNavigationListener接口
	 */
	class DropDownListenser implements OnNavigationListener {
		// 得到和SpinnerAdapter里一致的字符数组
		String[] listNames = getResources().getStringArray(R.array.limit_time);

		/* 当选择下拉菜单项的时候，将Activity中的内容置换为对应的Fragment */
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			switch (itemPosition) {
			case 0:
				ToastUtils.showToast(getApplicationContext(), "近一周平均", 0);
				break;
			case 1:
				ToastUtils.showToast(getApplicationContext(), "今日", 0);
				break;
			case 2:
				ToastUtils.showToast(getApplicationContext(), "近一个月平均", 0);
				break;
			case 3:
				ToastUtils.showToast(getApplicationContext(), "近一年平均", 0);
				break;
			}
			return true;
		}
	}

	@Override
	public String getActionBarTitle() {
		return "平均";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_AVERAGE;
	}

	@Override
	public int getActionBarIcon() {
		// TODO Auto-generated method stub
		return 0;
	}
}
