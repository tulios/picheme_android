package br.picheme.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

public class MuroService {

	public static final String TAG = MuroService.class.getName();
	
	private URL feedUrl;
	
	public MuroService(String host, String muro) {
		try {
			feedUrl = new URL(host + "/atom/" + muro);
		} catch (MalformedURLException e) {
			Log.e(TAG, e.getMessage());
		}
	}
	
	public InputStream getFeed() {
		try {
			return feedUrl.openConnection().getInputStream();
		} catch (MalformedURLException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
		return null;
	}
	
}
