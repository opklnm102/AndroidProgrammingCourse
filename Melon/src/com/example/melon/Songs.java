package com.example.melon;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Songs {
	@SerializedName("song")
	ArrayList<Song> songlist;
}
