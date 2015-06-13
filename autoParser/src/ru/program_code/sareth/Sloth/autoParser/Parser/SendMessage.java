package ru.program_code.sareth.Sloth.autoParser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;


import org.json.JSONException;
import org.json.JSONObject;

public class SendMessage {
	public static int Send(String urlString) {

		try {
			
			return doGetRequest(urlString);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}

		return -1;
	}

	private static int doGetRequest(String urlString) throws IOException,
			JSONException {
		urlString = urlString.replaceAll(" ", "%20");
		System.out.println(urlString);
		JSONObject json = readJsonFromUrl(urlString);
		System.out.print(json.get("position").toString());
		if (json.get("error").equals("Capcha")) {
			return -1;
		} else if (json.get("position").toString().equals("null")) {
			return 0;
		}
		return new Integer(json.get("position").toString()).intValue();
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			
			String jsonText = readAll(rd);
			System.out.println(jsonText);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	
}
