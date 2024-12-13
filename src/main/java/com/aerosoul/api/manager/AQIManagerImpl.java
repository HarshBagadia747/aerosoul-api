package com.aerosoul.api.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.aerosoul.api.client.AQIClient;
import com.aerosoul.api.client.OpenStreetMapClient;
import com.aerosoul.api.model.AirQualityGeoPoint;
import com.aerosoul.api.model.builder.AirQualityGeoPointBuilder;

@Service
public class AQIManagerImpl implements AQIManager {

	@Autowired
	private OpenStreetMapClient openStreetMapClient;

	@Autowired
	private AQIClient aqiClient;

	@Override
	@Cacheable(value = "aqiSearchCache", key = "#query.concat('-').concat(#limit)")
	public List<AirQualityGeoPoint> search(final String query, final int limit)
			throws IOException {
		// Call OpenStreetMapClient to fetch search results
		JSONArray geoJsonArray = this.getOpenStreetMapClient().search(query, limit);

		List<AirQualityGeoPoint> geoPoints = new ArrayList<AirQualityGeoPoint>();

		for (int i = 0; i < geoJsonArray.length(); i++) {
			AirQualityGeoPointBuilder builder = new AirQualityGeoPointBuilder();

			JSONObject geoJson = geoJsonArray.getJSONObject(i);

			JSONObject aqiJson = this.getAqiClient().getAQIData(geoJson.getString("lat"), geoJson.getString("lon"));

			if (!"ok".equals(aqiJson.getString("status"))) {
				throw new IOException("Failed to get aqi data");
			}

			AirQualityGeoPoint geoPoint = builder.fromGeocodingResponse(geoJson)
					.withAQIData(aqiJson.getJSONObject("data")).build();

			geoPoints.add(geoPoint);
		}

		return geoPoints;
	}

	public OpenStreetMapClient getOpenStreetMapClient() {
		return openStreetMapClient;
	}

	public void setOpenStreetMapClient(OpenStreetMapClient openStreetMapClient) {
		this.openStreetMapClient = openStreetMapClient;
	}

	public AQIClient getAqiClient() {
		return aqiClient;
	}

	public void setAqiClient(AQIClient aqiClient) {
		this.aqiClient = aqiClient;
	}

}
