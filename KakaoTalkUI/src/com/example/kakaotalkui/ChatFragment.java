package com.example.kakaotalkui;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

public class ChatFragment extends Fragment {
	ListView listView;
	ChattingAdapter mAdapter;
	RadioGroup group;
	EditText inputView;
	
	SimpleDateFormat chatDateFormat = new SimpleDateFormat("a hh:mm");
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_chat, container, false);
		listView = (ListView)view.findViewById(R.id.list_chats);
		mAdapter = new ChattingAdapter();
		listView.setAdapter(mAdapter);
		group = (RadioGroup)view.findViewById(R.id.radioGroup1);
		inputView = (EditText)view.findViewById(R.id.text_chat_message);
		
		Button btn = (Button)view.findViewById(R.id.btn_send);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String input = inputView.getText().toString();
				if(!TextUtils.isEmpty(input)) {
					switch(group.getCheckedRadioButtonId()) {
					case R.id.radio_send:
						SendData sd = new SendData();
						sd.date = chatDateFormat.format(new Date()).toString();
						sd.message = input;
						mAdapter.add(sd);
						break;
					case R.id.radio_receive:
						ReceiveData rd = new ReceiveData();
						rd.iconId = R.drawable.ic_launcher;
						rd.message = input;
						rd.date = chatDateFormat.format(new Date()).toString();
						mAdapter.add(rd);
						break;
					case R.id.radio_date:
						DateData dd = new DateData();
						dd.date = new Date().toString();
						mAdapter.add(dd);
						break;
					}
					inputView.setText("");
					listView.smoothScrollToPosition(mAdapter.getCount()-1);
				}
			}
		});
		
		return view;
	}
	
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(isVisibleToUser) {
			if(getActivity() != null) {
				getActivity().setTitle(R.string.tab_chats);
			}
		}
	}
}
