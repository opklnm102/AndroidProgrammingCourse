package com.example.simplelist;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	EditText inputView;
	TextView messageView;
	ListView listView;
	ArrayAdapter<String> mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inputView = (EditText)findViewById(R.id.edit_input);
		messageView = (TextView)findViewById(R.id.text_message);
		listView = (ListView)findViewById(R.id.listView1);
		mAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,new ArrayList<String>());
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String text = (String)listView.getItemAtPosition(position);
				messageView.setText(text);				
			}
		});
		
		Button btn = (Button)findViewById(R.id.button_insert);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String keyword = inputView.getText().toString();
				if(!TextUtils.isEmpty(keyword)) {
					mAdapter.add(keyword);
					listView.smoothScrollToPosition(mAdapter.getCount() - 1);
					inputView.setText("");
				}
			}
		});
		initData();
	}
	
	private void initData() {
		String[] items = getResources().getStringArray(R.array.list_item);
		for(String s: items) {
			mAdapter.add(s);
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
