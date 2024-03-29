package com.example.androidcomponent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends ActionBarActivity {

	TextView messageView;
	EditText editView;
	
	public static final String EXTRA_MESSAGE = "message";
	public static final String RESULT_MESSAGE = "result";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other);
		messageView = (TextView)findViewById(R.id.text_message);
		editView = (EditText)findViewById(R.id.editText1);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(EXTRA_MESSAGE);
		messageView.setText("message : " + message);
			
		Button btn = (Button)findViewById(R.id.btn_finish);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String input = editView.getText().toString();
				Intent data = new Intent();
				data.putExtra(RESULT_MESSAGE, input);
				setResult(Activity.RESULT_OK, data);
				
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other, menu);
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
