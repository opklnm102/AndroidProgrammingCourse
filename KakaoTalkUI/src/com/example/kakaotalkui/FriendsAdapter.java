package com.example.kakaotalkui;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FriendsAdapter extends BaseAdapter {
	List<FriendData> items = new ArrayList<FriendData>();
	
	public void add(FriendData item) {
		items.add(item);
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		FriendView view;
		if(convertView != null && convertView instanceof FriendView) {
			view = (FriendView) convertView;
		} else {
			view = new FriendView(parent.getContext());
		}
		view.setFriendData((FriendData)items.get(position));
		return view;
	}

}
