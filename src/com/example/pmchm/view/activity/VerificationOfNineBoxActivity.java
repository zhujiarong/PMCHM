package com.example.pmchm.view.activity;

import com.example.pmchm.R;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class VerificationOfNineBoxActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ver_box);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(R.string.title_input_gesture);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_add, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
			finish();
		return super.onOptionsItemSelected(item);
	}
}
