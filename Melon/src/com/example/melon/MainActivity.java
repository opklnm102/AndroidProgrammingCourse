package com.example.melon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends ActionBarActivity {
	ListView listView;
	ArrayAdapter<Song> mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView)findViewById(R.id.listView1);
		mAdapter = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1);
		listView.setAdapter(mAdapter);
		
		Button btn = (Button)findViewById(R.id.btn_melon);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new MelonTask().execute();
			}
		});
	}
	
	class MelonTask extends AsyncTask<String, Integer, MelonResult> {

		@Override
		protected MelonResult doInBackground(String... params) {
			try {
				URL url = new URL("http://apis.skplanetx.com/melon/charts/realtime?count=10&page=1&version=1");
				HttpURLConnection conn= (HttpURLConnection)url.openConnection();
				conn.addRequestProperty("Accept", "application/json");
				conn.addRequestProperty("appKey", "89acf2cc-ecd5-303e-803f-0aa5b4b0aa6b");
				
				int code = conn.getResponseCode();
				if(code == HttpURLConnection.HTTP_OK) {
					Gson gson = new Gson();
					MelonResult result = gson.fromJson(new InputStreamReader(conn.getInputStream()), MelonResult.class);
					return result;
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(MelonResult result) {
			super.onPostExecute(result);
			if(result != null) {
//				Toast.makeText(MainActivity.this, result , Toast.LENGTH_SHORT).show();
				for(Song s : result.melon.songs.songlist) {
					mAdapter.add(s);
					
				}
			} else {
				Toast.makeText(MainActivity.this, "fail...", Toast.LENGTH_SHORT).show();
			}
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
