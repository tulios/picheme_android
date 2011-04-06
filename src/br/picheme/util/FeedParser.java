package br.picheme.util;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import android.util.Log;
import android.util.Xml;

public class FeedParser {

	public static final String TAG = FeedParser.class.getName();
	
	public static <T> T parse(Class<T> xmlHandler, InputStream stream) {
		try {
			
			T handler = xmlHandler.newInstance();
			Xml.parse(stream, Xml.Encoding.UTF_8, (ContentHandler) handler);
			
			return handler;

		} catch (IllegalAccessException e) {
			Log.e(TAG, e.getMessage());
		} catch (InstantiationException e) {
			Log.e(TAG, e.getMessage());
		} catch (SAXException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
		
		return null;
	}

}
