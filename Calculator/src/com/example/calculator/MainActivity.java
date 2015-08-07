package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	TextView windowView; 
	String first, second;
	double operation1, operation2, result;
	int operator ;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		windowView = (TextView)findViewById(R.id.text_window);
		Button btn0 = (Button)findViewById(R.id.button0);
		Button btn1 = (Button)findViewById(R.id.button1);
		Button btn2 = (Button)findViewById(R.id.button2);
		Button btn3 = (Button)findViewById(R.id.button3);
		Button btn4 = (Button)findViewById(R.id.button4);
		Button btn5 = (Button)findViewById(R.id.button5);
		Button btn6 = (Button)findViewById(R.id.button6);
		Button btn7 = (Button)findViewById(R.id.button7);
		Button btn8 = (Button)findViewById(R.id.button8);
		Button btn9 = (Button)findViewById(R.id.button9);
		Button btnAdd = (Button)findViewById(R.id.buttonAdd);
		Button btnSub = (Button)findViewById(R.id.buttonSub);
		Button btnMul = (Button)findViewById(R.id.buttonMul);
		Button btnDiv = (Button)findViewById(R.id.buttonDiv);
		Button btnClear = (Button)findViewById(R.id.buttonClear);
		Button btnEqual = (Button)findViewById(R.id.buttonEqual);
		
		btn0.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(0+"");
			}
		});
		btn1.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(1+"");
			}
		});
		btn2.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(2+"");
			}
		});
		btn3.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(3+"");
			}
		});
		btn4.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(4+"");
			}
		});
		btn5.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(5+"");
			}
		});
		btn6.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(6+"");
			}
		});
		btn7.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(7+"");
			}
		});
		btn8.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(8+"");
			}
		});
		btn9.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.append(9+"");
			}
		});
		btnAdd.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				first = windowView.getText().toString();
				operation1 = Double.parseDouble(first);
				operator = 1;
				windowView.setText("");
				windowView.setHint("Add");
			}
		});
		btnSub.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				first = windowView.getText().toString();
				operation1 = Double.parseDouble(first);
				operator = 2;
				windowView.setText("");
				windowView.setHint("Subtract");
			}
		});
		btnMul.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				first = windowView.getText().toString();
				operation1 = Double.parseDouble(first);
				operator = 3;
				windowView.setText("");
				windowView.setHint("Multiply");
			}
		});
		btnDiv.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				first = windowView.getText().toString();
				operation1 = Double.parseDouble(first);
				operator = 4;
				windowView.setText("");
				windowView.setHint("Divide");
			}
		});
		btnClear.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				windowView.setText("");
			}
		});
		btnEqual.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				second = windowView.getText().toString();
				operation2 = Double.parseDouble(second);
				switch(operator) {
				case 1: result = operation1 + operation2;
					break;
				case 2: result = operation1 - operation2;
					break;
				case 3: result = operation1 * operation2;
					break;
				case 4: result = operation1 / operation2;
					break;
				}
				windowView.setText(""+result);
				windowView.setHint("");
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
