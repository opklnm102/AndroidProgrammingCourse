package com.example.navermovie;

import java.util.ArrayList;

import com.begentgroup.xmlparser.SerializedName;

public class NaverMovie {
	String title;
	String link;
	int Total;
	int start;
	int display;
	@SerializedName("item")
	ArrayList<MovieItem> items;
}
