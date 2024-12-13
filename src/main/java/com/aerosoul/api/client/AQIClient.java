package com.aerosoul.api.client;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class AQIClient {
	private final OkHttpClient client;

	private final String token;

	public AQIClient(@Value("${ORG_AQICN_API_ACCESS_TOKEN:#{null}}") String token) {
		this.client = new OkHttpClient();
		this.token = token;
	}

	public JSONObject getAQIData(final String lat, final String lon) throws IOException {
		String url = String.format("https://api.waqi.info/feed/geo:%s;%s/?token=%s", lat, lon, token);

		Request request = new Request.Builder().url(url).get().build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) {
				throw new IOException("Unexpected HTTP response: " + response.code() + " " + response.message());
			}

			String responseBody = response.body().string();
			return new JSONObject(responseBody);
		}
	}
}
