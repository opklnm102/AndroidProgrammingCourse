package com.example.frameanimation;

import android.R.animator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	ImageView imageView;
	AnimationDrawable mAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView)findViewById(R.id.imageView1);
		mAnimation = (AnimationDrawable)imageView.getDrawable();
		Button btn = (Button)findViewById(R.id.btn_start);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {		
				mAnimation.start();
			}
		});
		btn = (Button)findViewById(R.id.btn_stop);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {		
				mAnimation.stop();
			}
		});
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if(hasFocus){
			mAnimation.start();
		} else {
			mAnimation.stop();
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
