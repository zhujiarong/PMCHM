package com.example.pmchm.view.fragment;

import com.example.pmchm.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class PmFragment extends Fragment {

	public static Fragment getInstance() {
		PmFragment fragment = new PmFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_description, null);
		View header_average = inflater.inflate(R.layout.header_average, null);

		RelativeLayout layout = (RelativeLayout) header_average.findViewById(R.id.rl_line_chart);
		GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
				new GraphView.GraphViewData(1, 1.6d), new GraphView.GraphViewData(2, 2.4d),
				new GraphView.GraphViewData(3, 1.5d), new GraphView.GraphViewData(4, 3.7d),
				new GraphView.GraphViewData(5, 2.7d), new GraphView.GraphViewData(6, 3.3d), });
		GraphView graphView = new LineGraphView(getActivity(), "");
		graphView.setHorizontalLabels(new String[] { "1:00", "2:00", "3:00", "4:00", "5:00", "6:00" });
		graphView.getGraphViewStyle().setNumVerticalLabels(1);
		((LineGraphView) graphView).setDrawDataPoints(true);
		((LineGraphView) graphView).setDataPointsRadius(15f);
		((LineGraphView) graphView).setShowVerticalLabels(false);
		graphView.addSeries(exampleSeries);
		layout.addView(graphView);

		ListView lv_item = (ListView) view.findViewById(R.id.lv_item);
		lv_item.addHeaderView(header_average);
		lv_item.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				View item_description = View.inflate(getActivity(), R.layout.item_description, null);
				return item_description;
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getCount() {
				return 3;
			}
		});

		return view;
	}
}
