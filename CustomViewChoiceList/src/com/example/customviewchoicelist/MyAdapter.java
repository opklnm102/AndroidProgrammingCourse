package com.example.customviewchoicelist;

import java.util.ArrayList;
import java.util.List;

import com.example.customviewchoicelist.ItemView.OnCmtClickListener;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter implements ItemView.OnCmtClickListener {

	List<ItemData> items = new ArrayList<ItemData>();
	
	ItemView.OnCmtClickListener mCmtListener;
	
	public void setOnCmtClickListener(OnCmtClickListener listener) {
		mCmtListener = listener;
	}
	
	public void add(ItemData item) {
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
		ItemView view;
		if(convertView == null) {
			view = new ItemView(parent.getContext());
			view.setOnCmtClickListener(this);
		} else {
			view = (ItemView) convertView;
		}
		
		view.setItemData(items.get(position));
		return view;
	}


	@Override
	public void onCommentClick(ItemView view, ItemData data) {
		if(mCmtListener != null) {
			mCmtListener.onCommentClick(view, data);
		}
		
	}

}
