package com.scribe.service;

import java.io.IOException;

import android.util.Log;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

;

public class KloutScoreService {

	public static String getAPIKey() {

		return null;
	}

	public static Integer getScore(String screenName) {
		String URL = "http://api.klout.com/1/klout.json?users=" + screenName
				+ "&key=nd9cj8hfe7f9bd5866284dwr";
		JSONObject result = request(URL);
		Integer score = null;
		try {
			score = result.getJSONArray("users").getJSONObject(0).getInt("kscore");
			Log.i("Tag Int ", score.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return score;
	}

	public static JSONObject request(String URL) {
		JSONObject result = null;
		final String tag = "Your Logcat tag: ";
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL);
		ResponseHandler<String> handler = new BasicResponseHandler();
		
		try {
			result = new JSONObject(httpclient.execute(request, handler));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (JSONException je) {
			je.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		httpclient.getConnectionManager().shutdown();
		// Log.i(tag, result);
		return result;
	}

}
