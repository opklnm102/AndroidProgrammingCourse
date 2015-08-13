package com.example.kakaotalkui;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiveView extends FrameLayout {

	public ReceiveView(Context context) {
		super(context);
		init();
	}
	
	ImageView iconView;
	TextView messageView;
	TextView dateView;
	
	private void init() {
		inflate(getContext(), R.layout.view_receive, this);
		iconView = (ImageView)findViewById(R.id.image_icon);
		messageView = (TextView)findViewById(R.id.text_receive_message);
		dateView = (TextView)findViewById(R.id.text_receive_date);		
	}
	
	public void setReceiveData(ReceiveData data) {
		messageView.setText(data.message);
		iconView.setImageResource(data.iconId);
		dateView.setText(data.date);
	}

}
