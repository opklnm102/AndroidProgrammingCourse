package com.example.mydialog;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	String [] items = {"itme1","itme2", "itme3", "itme4","itme5" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button)findViewById(R.id.btn_alert);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(R.drawable.ic_launcher);
				builder.setTitle("Dialog Test");
				builder.setMessage("Alert Dialog...");
				builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "Yes Click", Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "Cancel Click", Toast.LENGTH_SHORT).show();
					}
				});
				builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "No Click", Toast.LENGTH_SHORT).show();
					}
				});
				
				builder.setCancelable(false);
				builder.setOnCancelListener(new OnCancelListener() {
					
					@Override
					public void onCancel(DialogInterface dialog) {
						Toast.makeText(MainActivity.this, "Dialog Cancel", Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();
			}
		});
        btn = (Button)findViewById(R.id.btn_list);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(android.R.drawable.ic_dialog_alert);
				builder.setTitle("dialog list");
				builder.setItems(items, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "select : " + items[which],Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();
			}
		});
        
        btn = (Button)findViewById(R.id.btn_single);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(android.R.drawable.ic_dialog_alert);
				builder.setTitle("dialog single");
				builder.setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(MainActivity.this, "choice : " + items[which], Toast.LENGTH_SHORT).show();
					}
				});
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				builder.create().show();
			}
		});
        
        
        btn = (Button)findViewById(R.id.btn_multi);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setIcon(android.R.drawable.ic_dialog_alert);
				builder.setTitle("dialog multiple");
				final boolean[] selectionlist = new boolean[items.length];
				selectionlist[1] = true;
				selectionlist[3] = true;
				builder.setMultiChoiceItems(items, selectionlist, new OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						selectionlist[which] = isChecked;
					}
				});
				builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < selectionlist.length ; i++) {
							if (selectionlist[i]) {
								sb.append(items[i]).append(",");
							}
						}
						Toast.makeText(MainActivity.this, "item : " + sb.toString(), Toast.LENGTH_SHORT).show();
					}
				});
				builder.create().show();
				
			}
		});
		
		btn = (Button)findViewById(R.id.btn_progress);
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				ProgressDialog dialog = new ProgressDialog(MainActivity.this);
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setTitle("Dialog Progress");
				dialog.setMessage("in Progress...");

				dialog.show();
			}
		});
		
		btn = (Button)findViewById(R.id.btn_progress2);
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				ProgressDialog dialog = new ProgressDialog(MainActivity.this);
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setTitle("Dialog Progress");
				dialog.setMessage("in Progress...");
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				
				dialog.setMax(100);
				dialog.show();
				dialog.setSecondaryProgress(50);
				dialog.setProgress(30);	
			}
		});
		
		btn = (Button)findViewById(R.id.btn_fragment);
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				MyDialogFragment f = new MyDialogFragment();
				f.show(getSupportFragmentManager(), "dialog");
			}
		});
		
		btn = (Button)findViewById(R.id.btn_custom);
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				CustomDialog dialog = new CustomDialog();
				dialog.show(getSupportFragmentManager(), "dialog");
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
