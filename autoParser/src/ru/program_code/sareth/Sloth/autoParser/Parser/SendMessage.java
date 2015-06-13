package ru.program_code.sareth.Sloth.autoParser.Parser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.LinkedList;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SearchQueryesObject;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SiteQueryPosition;

public class SendMessage {
	private final static String USER_AGENT = "Mozilla/5.0";

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

	// HTTP GET request
	private static void sendGet(String urlString) throws Exception {

		String url = urlString;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}

	private static void sendPost(String urlString) throws Exception {

		String url = "http://www.program-code.ru/parse/position_parser.php";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "query=Программирование%20для%20начинающих%20и%20профессионалов&url=program-code.ru&ses=1&cnt=0&lang=0&rep=0&reg=0";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

	}
}
