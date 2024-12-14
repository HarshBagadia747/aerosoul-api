package com.aerosoul.api.model.builder;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.aerosoul.api.model.AQIValue;
import com.aerosoul.api.model.Address;
import com.aerosoul.api.model.AirQualityGeoPoint;
import com.aerosoul.api.model.Daily;
import com.aerosoul.api.model.Forecast;
import com.aerosoul.api.model.ForecastItem;
import com.aerosoul.api.model.IAQI;
import com.aerosoul.api.model.Time;

public class AirQualityGeoPointBuilder {
	private AirQualityGeoPoint geoPoint;

	public AirQualityGeoPointBuilder() {
		this.geoPoint = new AirQualityGeoPoint();
	}

	// Populate data from geocoding response
	public AirQualityGeoPointBuilder fromGeocodingResponse(JSONObject geoJson) {
		geoPoint.setLat(geoJson.getString("lat"));
		geoPoint.setLon(geoJson.getString("lon"));
		geoPoint.setName(geoJson.optString("name", null));
		geoPoint.setCategory(geoJson.optString("category", null));
		geoPoint.setType(geoJson.optString("type", null));
		geoPoint.setAddressType(geoJson.optString("addresstype", null));
		geoPoint.setDisplayName(geoJson.optString("display_name", null));

		// Populate Address
		if (geoJson.has("address")) {
			JSONObject addressJson = geoJson.getJSONObject("address");
			Address address = new Address();
			address.setCity(addressJson.optString("city", null));
			address.setState(addressJson.optString("state", null));
			address.setPostcode(addressJson.optString("postcode", null));
			address.setCountry(addressJson.optString("country", null));
			address.setCountryCode(addressJson.optString("country_code", null));
			address.setIso3166Lvl4(addressJson.optString("ISO3166-2-lvl4", null));
			geoPoint.setAddress(address);
		}

		if (geoJson.has("boundingbox")) {
			JSONArray boundingBoxJson = geoJson.getJSONArray("boundingbox");

			List<String> boundingBoxes = new ArrayList<String>();

			boundingBoxJson.forEach((boundingBox) -> boundingBoxes.add(String.valueOf(boundingBox)));

			geoPoint.setBoundingBox(boundingBoxes);
		}

		return this;
	}

	// Patch AQI data
	public AirQualityGeoPointBuilder withAQIData(JSONObject aqiJson) {
		geoPoint.setAqi(aqiJson.optInt("aqi", -1));
		geoPoint.setUrl(aqiJson.getJSONObject("city").optString("url", null));
		geoPoint.setDominentpol(aqiJson.optString("dominentpol", null));

		Time time = new Time();
		time.setS(aqiJson.getJSONObject("time").optString("s", null));
		time.setTz(aqiJson.getJSONObject("time").optString("tz", null));
		time.setV(aqiJson.getJSONObject("time").optLong("v", 0));
		time.setIso(aqiJson.getJSONObject("time").optString("iso", null));

		geoPoint.setTime(time);

		// Populate IAQI
		if (aqiJson.has("iaqi")) {
			JSONObject iaqiJson = aqiJson.getJSONObject("iaqi");
			IAQI iaqi = new IAQI();

			if (iaqiJson.has("pm10")) {
				AQIValue pm10 = new AQIValue();
				pm10.setV(iaqiJson.getJSONObject("pm10").optDouble("v", -1));
				iaqi.setPm10(pm10);
			}

			if (iaqiJson.has("pm25")) {
				AQIValue pm25 = new AQIValue();
				pm25.setV(iaqiJson.getJSONObject("pm25").optDouble("v", -1));
				iaqi.setPm25(pm25);
			}

			if (iaqiJson.has("o3")) {
				AQIValue o3 = new AQIValue();
				o3.setV(iaqiJson.getJSONObject("o3").optDouble("v", -1));
				iaqi.setO3(o3);
			}

			if (iaqiJson.has("no2")) {
				AQIValue no2 = new AQIValue();
				no2.setV(iaqiJson.getJSONObject("no2").optDouble("v", -1));
				iaqi.setNo2(no2);
			}

			geoPoint.setIaqi(iaqi);
		}

		// Populate Forecast
		if (aqiJson.has("forecast")) {
			JSONObject forecastJson = aqiJson.getJSONObject("forecast");
			Forecast forecast = new Forecast();

			Daily daily = new Daily();
			daily.setO3(mapForecastItems(forecastJson.getJSONObject("daily").getJSONArray("o3")));
			daily.setPm10(mapForecastItems(forecastJson.getJSONObject("daily").getJSONArray("pm10")));
			daily.setPm25(mapForecastItems(forecastJson.getJSONObject("daily").getJSONArray("pm25")));
			daily.setUvi(mapForecastItems(forecastJson.getJSONObject("daily").getJSONArray("uvi")));

			forecast.setDaily(daily);
			geoPoint.setForecast(forecast);
		}

		return this;
	}

	// Helper method to map forecast items
	private List<ForecastItem> mapForecastItems(JSONArray forecastArray) {
		List<ForecastItem> forecastItemList = new ArrayList<ForecastItem>();
		for (int i = 0; i < forecastArray.length(); i++) {
			JSONObject forecastItemJson = forecastArray.getJSONObject(i);
			ForecastItem forecastItem = new ForecastItem();
			forecastItem.setAvg(forecastItemJson.optInt("avg", -1));
			forecastItem.setDay(forecastItemJson.optString("day", null));
			forecastItem.setMax(forecastItemJson.optInt("max", -1));
			forecastItem.setMin(forecastItemJson.optInt("min", -1));
			forecastItemList.add(forecastItem);
		}
		return forecastItemList;
	}

	public AirQualityGeoPoint build() {
		return this.geoPoint;
	}
}
