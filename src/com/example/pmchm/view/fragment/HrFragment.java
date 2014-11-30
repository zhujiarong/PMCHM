package com.example.pmchm.view.fragment;

import com.example.pmchm.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class HrFragment extends Fragment {
	public static Fragment getInstance() {
		Fragment fragment = new HrFragment();
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_description, null);
		RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.rl_line_chart);

		GraphViewSeries exampleSeries = new GraphViewSeries(new GraphViewData[] { new GraphViewData(1, 2.0d),
				new GraphViewData(2, 1.5d), new GraphViewData(2.5, 3.0d) // another
																			// frequency
				, new GraphViewData(3, 2.5d), new GraphViewData(4, 1.0d), new GraphViewData(5, 3.0d) });

		GraphView graphView = new LineGraphView(getActivity() // context
				, "GraphViewDemo" // heading
		);
		((LineGraphView) graphView).setDrawDataPoints(true);
		((LineGraphView) graphView).setDataPointsRadius(15f);
		graphView.addSeries(exampleSeries); // data

		layout.addView(graphView);
		
		ListView lv_item = (ListView) view.findViewById(R.id.lv_item);
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
