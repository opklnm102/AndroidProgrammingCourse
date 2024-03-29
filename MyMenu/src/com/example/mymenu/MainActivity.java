package com.example.mymenu;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.textView1);
        registerForContextMenu(tv);
        ImageView iv = (ImageView)findViewById(R.id.imageView1);
        registerForContextMenu(iv);

        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startSupportActionMode(new ActionMode.Callback() {
					
					@Override
					public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
						return false;
					}
					
					@Override
					public void onDestroyActionMode(ActionMode mode) {
						
					}
					
					@Override
					public boolean onCreateActionMode(ActionMode mode, Menu menu) {
						getMenuInflater().inflate(R.menu.action_mode_menu, menu);
						mode.setTitle("Mode Menu....");
						return true;
					}
					
					@Override
					public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
						switch(item.getItemId()) {
						case R.id.menu_mode_1 :
						case R.id.menu_mode_2 :
						case R.id.menu_mode_3 :
							Toast.makeText(MainActivity.this, "menu click", Toast.LENGTH_SHORT).show();
							mode.finish();
							return true;
						}
						return false;
					}
				});
			}
		});
        
        btn = (Button)findViewById(R.id.button2);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PopupMenu menu = new PopupMenu(MainActivity.this, v);
				menu.inflate(R.menu.popup_menu);
				menu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						Toast.makeText(MainActivity.this, "popup menu click", Toast.LENGTH_SHORT).show();
						return true;
					}
				});
				menu.show();
			}
		});
	}
	
	public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		switch(v.getId()){
		case R.id.textView1 : 
			getMenuInflater().inflate(R.menu.text_menu, menu);
			return;
		case R.id.imageView1:
			getMenuInflater().inflate(R.menu.image_menu, menu);
			return;
		} 
	};
	
	public boolean onContextItemSelected(MenuItem item) {
    	Toast.makeText(this, "context menu selected", Toast.LENGTH_SHORT).show();
    	return super.onContextItemSelected(item);
	};
	
	EditText inputView;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		MenuItem item = menu.findItem(R.id.menu_add);
        View view = MenuItemCompat.getActionView(item);
        inputView = (EditText)view.findViewById(R.id.editText1);
        Button btn = (Button)view.findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String message = inputView.getText().toString();
				Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
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
		if(id == R.id.menu_add) {
        	Toast.makeText(this, "add menu click", Toast.LENGTH_SHORT).show();
        	return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
