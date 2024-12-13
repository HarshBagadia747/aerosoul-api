package com.aerosoul.api.client;

import java.io.IOException;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class OpenStreetMapClient {

	@Value("${ORG_OPENSTREETMAP_API_BASE_URL}")
	private String baseUrl;

	private final OkHttpClient client;

	public OpenStreetMapClient() {
		client = new OkHttpClient();
	}

	public JSONArray search(final String query, final int limit) throws IOException {
		HttpUrl url = HttpUrl.parse(this.getBaseUrl() + "/search").newBuilder().addQueryParameter("q", query)
				.addQueryParameter("format", "jsonv2")
				// include a breakdown of the address into elements
				.addQueryParameter("addressdetails", "1")
				// limit the number of result set
				.addQueryParameter("limit", String.valueOf(limit)).build();

		Request request = new Request.Builder().url(url).header("User-Agent", "OkHttp OpenStreetMap Client").build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) {
				throw new IOException("Unexpected response code: " + response.code());
			}
			String responseBody = response.body().string();
			return new JSONArray(responseBody);
		}
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public OkHttpClient getClient() {
		return client;
	}

}
