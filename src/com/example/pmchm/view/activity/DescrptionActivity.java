package com.example.pmchm.view.activity;

import com.example.pmchm.R;
import com.example.pmchm.common.Constants;
import com.example.pmchm.view.MainOptionAdapter;
import com.example.pmchm.view.fragment.HrFragment;
import com.example.pmchm.view.fragment.CoFragment;
import com.example.pmchm.view.fragment.PmFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;

public class DescrptionActivity extends BaseActivity implements TabListener {

	private Fragment[] fragments = null;
	private ViewPager pager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		setContentView(R.layout.activity_dec);
		pager = (ViewPager) findViewById(R.id.pager);
		initData();
		initTab();
		setListener();
	}

	/**
	 * 初始数据
	 */
	private void initData() {
		fragments = new Fragment[] { CoFragment.getInstance(), PmFragment.getInstance(), HrFragment.getInstance() };
		MainOptionAdapter adaptr = new MainOptionAdapter(getSupportFragmentManager(), fragments);
		pager.setAdapter(adaptr);
	}

	/**
	 * 设置事件监听
	 */
	private void setListener() {
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.selectTab(actionBar.getTabAt(position));
			}

			@Override
			public void onPageScrolled(int position, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int position) {
			}
		});
	}

	/**
	 * 初始化头部导航
	 * 
	 * @return
	 */
	private void initTab() {
		String[] titles = getResources().getStringArray(R.array.option_name);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// 初始化tab
		for (String title : titles) {
			Tab tab = actionBar.newTab().setText(title);
			tab.setTabListener(this);
			actionBar.addTab(tab);
		}
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public String getActionBarTitle() {
		return "总裁办公室";
	}

	@Override
	public int getActivityId() {
		return Constants.AC_PRESIDEN;
	}
}
