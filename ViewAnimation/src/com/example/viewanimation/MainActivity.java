package com.example.viewanimation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView)findViewById(R.id.imageView1);
		
		Button btn = (Button)findViewById(R.id.btn_translate);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_move);
				imageView.startAnimation(anim);
			}
		});
		btn = (Button)findViewById(R.id.btn_rotate);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_rotate);
				imageView.startAnimation(anim);
			}
		});
		btn = (Button)findViewById(R.id.btn_scale);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_scale);
				imageView.startAnimation(anim);
			}
		});
		btn = (Button)findViewById(R.id.btn_alpha);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_alpha);
				imageView.startAnimation(anim);
			}
		});
		btn = (Button)findViewById(R.id.btn_set);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_set);
				imageView.startAnimation(anim);
			}
		});
		btn = (Button)findViewById(R.id.btn_set2);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_set2);
				imageView.startAnimation(anim);
			}
		});
		
		btn = (Button)findViewById(R.id.btn_out);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_left);
				anim.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {}
					
					@Override
					public void onAnimationRepeat(Animation animation) {}
					
					@Override
					public void onAnimationEnd(Animation animation) {
						imageView.setVisibility(View.GONE);
					}
				});
				imageView.startAnimation(anim);
			}
		});
		
		btn = (Button)findViewById(R.id.btn_in);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_left);
				imageView.setVisibility(View.VISIBLE);
				imageView.startAnimation(anim);
			}
		});
		
		btn = (Button)findViewById(R.id.btn_custom);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MyAnimation anim = new MyAnimation();
				anim.setDuration(1000);
				imageView.startAnimation(anim);
			}
		});
		btn = (Button)findViewById(R.id.btn_3d);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				My3DAnimation anim = new My3DAnimation();
				anim.setDuration(1000);
				imageView.startAnimation(anim);
			}
		});
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
