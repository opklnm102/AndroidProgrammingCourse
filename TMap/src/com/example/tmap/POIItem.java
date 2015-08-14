package com.example.tmap;

import com.skp.Tmap.TMapPOIItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class POIItem {
	TMapPOIItem poi;
	
	@Override
	public String toString() {
		return poi.getPOIName();
	}
}
