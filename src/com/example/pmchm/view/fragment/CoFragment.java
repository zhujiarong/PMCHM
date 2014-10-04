package com.example.pmchm.view.fragment;

import com.example.pmchm.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CoFragment extends Fragment {

	public static Fragment getInstance() {
		Fragment fragment = new CoFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_description, null);
		return view;
	}
}
