package com.example.compoundwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoView extends FrameLayout {

	public InfoView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public InfoView(Context context) {
		super(context);
		init();
	}
	
	ImageView iconView;
	TextView titleView, subtitleView, descView;
	InfoData mData;

	public interface OnImageClickListener {
		public void onImageClick(InfoView view, InfoData data);
	}
	OnImageClickListener mListener;
	
	public void setOnImageClickListener(OnImageClickListener listener) {
		mListener = listener;
	}
	
	private void init() {
		inflate(getContext(), R.layout.view_info, this); //XML에서 가져옴
		iconView = (ImageView)findViewById(R.id.image_icon);
		iconView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mListener != null) {
					mListener.onImageClick(InfoView.this, mData);
				}
				
			}
		});
		
		titleView = (TextView)findViewById(R.id.text_title);
		subtitleView = (TextView)findViewById(R.id.text_subtitle);
		descView = (TextView)findViewById(R.id.text_description);
	}
	
	public void setInfoData(InfoData data) {
		mData = data;
		iconView.setImageResource(data.iconID);
		titleView.setText(data.title);
		subtitleView.setText(data.subtitle);
		descView.setText(data.description);
	}
	
	public InfoData getInfoData() {
		return mData;
	}
	
	public void setTitleColor(int color) {
		titleView.setTextColor(color);
	}
}
