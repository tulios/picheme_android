package br.picheme.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Log;

public class MuroService {

	public static final String TAG = MuroService.class.getName();
	
	public static URL getFeedUrl(String muro) throws MalformedURLException {
		return new URL("http://192.168.1.103:3000/atom/" + muro);
	}

	public static InputStream getFeed(String muro) {
		try {
			return getFeedUrl(muro).openConnection().getInputStream();
		} catch (MalformedURLException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
		return null;
	}
	
}
