package com.example.kakaotalkui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class FriendsFragment extends Fragment {
	ListView listView;
	FriendsAdapter mAdapter;
	EditText inputView;
	
	int[] resIds = {
			R.drawable.gallery_photo_1,
			R.drawable.gallery_photo_2,
			R.drawable.gallery_photo_3,
			R.drawable.gallery_photo_4,
			R.drawable.gallery_photo_5,
			R.drawable.gallery_photo_6,
			R.drawable.gallery_photo_7,
			R.drawable.gallery_photo_8
		};
	
	String[] names = {"Peter", "Elena", "Toni", "Bernard", "John", "Helen", "Tom", "Kim"};
	String[] messages = {
			"..",
			"..",
			".",
			"..",
			"..",
			"..",
			"..",
			".."
	};

	private void initData() {
		for(int i=0; i<7; i++) {
			FriendData d = new FriendData();
			d.iconId = resIds[i % resIds.length];
			d.name = names[i];
			d.stateMessage = messages[i];
			mAdapter.add(d);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_friends, container, false);
		listView = (ListView)view.findViewById(R.id.list_friends);
		mAdapter = new FriendsAdapter();
		listView.setAdapter(mAdapter);
		inputView = (EditText)view.findViewById(R.id.edit_search);
		
		Button btn = (Button)view.findViewById(R.id.btn_search);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String input = inputView.getText().toString();
				if(!TextUtils.isEmpty(input)) {
					
				}
			}
		});
		initData();
		return view;
	}
	
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		if(isVisibleToUser) {
			if(getActivity() != null) {
				getActivity().setTitle(R.string.tab_friends);
			}
		}
	}
}
