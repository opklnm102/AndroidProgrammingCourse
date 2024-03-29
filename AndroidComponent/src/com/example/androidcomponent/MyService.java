package com.example.androidcomponent;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	private static final String TAG = "MyService";
	boolean isRunning;
	int mCount;
	
	public static final String ACTION_COUNT = "com.example.androidcomponent.action.COUNT";
	
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "onCreate....", Toast.LENGTH_SHORT).show();
		mCount=0;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				isRunning = true;				
				while(isRunning) {
					mCount++;
					Log.i(TAG,"count : " + mCount);
					if(mCount % 10 == 0) {
						Intent event = new Intent(ACTION_COUNT);
						event.putExtra("count", mCount);
						sendOrderedBroadcast(event, null, new BroadcastReceiver() {

							@Override
							public void onReceive(Context context, Intent intent) {
								int code = getResultCode();
								if(code == Activity.RESULT_CANCELED) {
									Toast.makeText(MyService.this, "MyService not processed", Toast.LENGTH_SHORT).show();
								}
							}
							
						}, null, Activity.RESULT_CANCELED, null, null);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
		filter.addAction(Intent.ACTION_SCREEN_ON);
		registerReceiver(mScreenOnOff, filter);
	}
	
	BroadcastReceiver mScreenOnOff = new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(intent.ACTION_SCREEN_OFF)) {
				Log.i(TAG, "Screen Off");
			} else if (intent.getAction().equals(intent.ACTION_SCREEN_ON)) {
				Log.i(TAG, "Screen On");
			}
			
		}
		
	};
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "onStartCommand....", Toast.LENGTH_SHORT).show();
		if(intent != null) {
			mCount = intent.getIntExtra("count", 0);
		}
		return Service.START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "onDestroy....", Toast.LENGTH_SHORT).show();
		isRunning = false;
		unregisterReceiver(mScreenOnOff);
	}
	
	
}
