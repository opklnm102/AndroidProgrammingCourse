package com.example.kakaotalkui;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SendView extends FrameLayout {

	public SendView(Context context) {
		super(context);
		init();
	}
	
	TextView messageView;
	TextView dateView;
	
	private void init() {
		inflate(getContext(), R.layout.view_send, this);
		messageView = (TextView)findViewById(R.id.text_send_message);
		dateView = (TextView)findViewById(R.id.text_send_date);
	}
	
	public void setSendData(SendData data) {
		messageView.setText(data.message);
		dateView.setText(data.date);
	}

}
