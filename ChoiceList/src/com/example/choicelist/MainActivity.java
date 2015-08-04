package com.example.choicelist;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity {
	EditText inputView;
	ListView listView;
	ArrayAdapter<String> mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listView1);
		
		mAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_multiple_choice,new ArrayList<String>());
		listView.setAdapter(mAdapter);
		listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
				
		Button btn_check = (Button)findViewById(R.id.button1);
		btn_check.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(listView.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
					int position = listView.getCheckedItemPosition();
					String text = (String) listView.getItemAtPosition(position);
					Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
				} else if(listView.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
					SparseBooleanArray array = listView.getCheckedItemPositions();
					StringBuilder sb = new StringBuilder();
					for(int index=0; index < array.size(); index++) {
						int position = array.keyAt(index);
						if(array.get(position)) {
							String text = (String)listView.getItemAtPosition(position);
							sb.append(text).append("\n");
						}
					}
					Toast.makeText(MainActivity.this, sb, Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		Button btn_insert = (Button)findViewById(R.id.button_insert);
		btn_insert.setOnClickListener(new View.OnClickListener() {
			
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
