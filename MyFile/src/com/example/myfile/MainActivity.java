package com.example.myfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	ImageView imageView1, imageView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		imageView1 = (ImageView)findViewById(R.id.imageView1);
		imageView2 = (ImageView)findViewById(R.id.imageView2);
		Button btn = (Button)findViewById(R.id.btn_save);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
				File dir = getExternalFilesDir(null);	// if application deleted, also delete files
				if(!dir.exists()) {
					dir.mkdir();
				}
								
				File path = new File(dir, "phto1.jpg");
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(path);
					Bitmap bm = ((BitmapDrawable)imageView1.getDrawable()).getBitmap();
					bm.compress(CompressFormat.JPEG, 100, fos);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});		
		btn = (Button)findViewById(R.id.btn_load);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
				File dir = getExternalFilesDir(null);	// if application deleted, also delete files
				if(!dir.exists()) {
					dir.mkdir();
				}
								
				File path = new File(dir, "phto1.jpg");
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(path);
					Bitmap bm = BitmapFactory.decodeStream(fis);
					imageView2.setImageBitmap(bm);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
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
