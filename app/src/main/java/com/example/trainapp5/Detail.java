package com.example.trainapp5;

public class Detail {
    String magnitude, location, URL;
    long time;

	public Detail(String mMagnitude, String mLocation, long mTime, String mURL) {
		magnitude = mMagnitude;
		location = mLocation;
		time = mTime;
		URL = mURL;
	}

	public String getURL() {
		return URL;
	}

	public String getMagnitude() {
		return magnitude;
	}

	public long getTime() {
		return time;
	}

	public  String getLocation() { return  location; }

}
