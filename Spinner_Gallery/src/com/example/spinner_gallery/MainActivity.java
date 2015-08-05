package com.example.spinner_gallery;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	int[] resIds = { R.drawable.gallery_photo_1,
			R.drawable.gallery_photo_2,
			R.drawable.gallery_photo_3,
			R.drawable.gallery_photo_4,
			R.drawable.gallery_photo_5,
			R.drawable.gallery_photo_6,
			R.drawable.gallery_photo_7,
			R.drawable.gallery_photo_8
	};
	
	Gallery gallery;
	Spinner spinner;
	ArrayAdapter<String> mAdapter;
	ImageAdapter iAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// gallery
		gallery = (Gallery)findViewById(R.id.gallery1);
		iAdapter = new ImageAdapter();
		gallery.setAdapter(iAdapter);
		initData();
		int iPosition = (Integer.MAX_VALUE/2) / resIds.length * resIds.length;
		gallery.setSelection(iPosition);
		
		// spinner
		spinner = (Spinner)findViewById(R.id.spinner1);
		String[] array = getResources().getStringArray(R.array.spinner_items);
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, array);
		spinner.setAdapter(mAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this, "position : " + position, Toast.LENGTH_SHORT).show();			
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_SHORT).show();
			}
		});
	}
	
    private void initData() {
    	for (int id : resIds) {
    		iAdapter.add(id);
    	}
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
