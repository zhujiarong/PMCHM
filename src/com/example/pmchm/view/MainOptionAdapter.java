package com.example.pmchm.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainOptionAdapter extends FragmentPagerAdapter {
	
	private Fragment[] fragments = null;

	public MainOptionAdapter(FragmentManager fm, Fragment[] fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments[position];
	}

	@Override
	public int getCount() {
		return fragments.length;
	}

}
