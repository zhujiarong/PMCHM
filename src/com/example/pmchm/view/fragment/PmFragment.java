package com.example.pmchm.view.fragment;

import com.example.pmchm.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PmFragment extends ListFragment {

	public static Fragment getInstance() {
		PmFragment fragment = new PmFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_description, null);
		return view;
	}
}
