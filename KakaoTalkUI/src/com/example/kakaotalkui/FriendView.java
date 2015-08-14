package com.example.kakaotalkui;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendView extends FrameLayout {

	public FriendView(Context context) {
		super(context);
		init();
	}

	ImageView iconView;
	TextView nameView;
	TextView stateMessageView;
	
	private void init() {
		inflate(getContext(), R.layout.view_friend, this);
		iconView = (ImageView)findViewById(R.id.image_profile);
		nameView = (TextView)findViewById(R.id.text_name);
		stateMessageView = (TextView)findViewById(R.id.text_state_message);
	}
	
	public void setFriendData(FriendData data) {
		iconView.setImageResource(data.iconId);
		nameView.setText(data.name);
		stateMessageView.setText(data.stateMessage);
	}
}
