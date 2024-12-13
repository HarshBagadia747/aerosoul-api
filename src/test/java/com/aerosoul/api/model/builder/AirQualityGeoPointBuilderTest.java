package com.aerosoul.api.model.builder;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.aerosoul.api.model.Address;
import com.aerosoul.api.model.AirQualityGeoPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AirQualityGeoPointBuilderTest {

	@Test
	void testFromGeocodingResponse() {
		// Create mock geocoding response JSON
		JSONObject geoJson = new JSONObject("{\r\n" + "        \"place_id\": 133979754,\r\n"
				+ "        \"licence\": \"Data © OpenStreetMap contributors, ODbL 1.0. http://osm.org/copyright\",\r\n"
				+ "        \"osm_type\": \"way\",\r\n" + "        \"osm_id\": 437595031,\r\n"
				+ "        \"lat\": \"52.54274275\",\r\n" + "        \"lon\": \"13.36690305710228\",\r\n"
				+ "        \"category\": \"shop\",\r\n" + "        \"type\": \"bakery\",\r\n"
				+ "        \"place_rank\": 30,\r\n" + "        \"importance\": -0.00010602787938077087,\r\n"
				+ "        \"addresstype\": \"shop\",\r\n" + "        \"name\": \"Ditsch\",\r\n"
				+ "        \"display_name\": \"Ditsch, Lindower Straße, Sprengelkiez, Wedding, Mitte, Berlin, 13347, Deutschland\",\r\n"
				+ "        \"address\": {\r\n" + "            \"shop\": \"Ditsch\",\r\n"
				+ "            \"road\": \"Lindower Straße\",\r\n"
				+ "            \"neighbourhood\": \"Sprengelkiez\",\r\n" + "            \"suburb\": \"Wedding\",\r\n"
				+ "            \"borough\": \"Mitte\",\r\n" + "            \"city\": \"Berlin\",\r\n"
				+ "            \"ISO3166-2-lvl4\": \"DE-BE\",\r\n" + "            \"postcode\": \"13347\",\r\n"
				+ "            \"country\": \"Deutschland\",\r\n" + "            \"country_code\": \"de\"\r\n"
				+ "        },\r\n" + "        \"boundingbox\": [\r\n" + "            \"52.5427201\",\r\n"
				+ "            \"52.5427654\",\r\n" + "            \"13.3668619\",\r\n"
				+ "            \"13.3669442\"\r\n" + "        ]\r\n" + "    }");

		// Use the builder
		AirQualityGeoPoint geoPoint = new AirQualityGeoPointBuilder().fromGeocodingResponse(geoJson).build();

		// Assert the values
		assertEquals("52.54274275", geoPoint.getLat());
		assertEquals("13.36690305710228", geoPoint.getLon());
		assertEquals("Ditsch", geoPoint.getName());
		assertEquals("shop", geoPoint.getCategory());
		assertEquals("bakery", geoPoint.getType());
		assertEquals("shop", geoPoint.getAddressType());
		assertEquals("Ditsch, Lindower Straße, Sprengelkiez, Wedding, Mitte, Berlin, 13347, Deutschland",
				geoPoint.getDisplayName());

		// Assert Address fields
		Address address = geoPoint.getAddress();
		assertNotNull(address);
		assertEquals("Berlin", address.getCity());
		assertEquals("13347", address.getPostcode());
		assertEquals("Deutschland", address.getCountry());
	}

	@Test
	void testWithAQIData() {
		// Create mock AQI response JSON
		JSONObject aqiJson = new JSONObject("{\r\n" + "        \"aqi\": 57,\r\n" + "        \"idx\": 10030,\r\n"
				+ "        \"city\": {\r\n" + "            \"geo\": [\r\n" + "                52.543041,\r\n"
				+ "                13.349326\r\n" + "            ],\r\n"
				+ "            \"name\": \"Wedding-Amrumer Str., Berlin, Germany\",\r\n"
				+ "            \"url\": \"https://aqicn.org/city/germany/berlin/wedding-amrumer-str.\"\r\n"
				+ "        },\r\n" + "        \"dominentpol\": \"pm25\",\r\n" + "        \"iaqi\": {\r\n"
				+ "            \"pm25\": { \"v\": 57 },\r\n" + "            \"pm10\": { \"v\": 16 },\r\n"
				+ "            \"o3\": { \"v\": 16.7 },\r\n" + "            \"no2\": { \"v\": 3.7 }\r\n"
				+ "        },\r\n" + "        \"time\": {\r\n" + "            \"s\": \"2024-12-12 03:00:00\",\r\n"
				+ "            \"tz\": \"+01:00\",\r\n" + "            \"iso\": \"2024-12-12T03:00:00+01:00\"\r\n"
				+ "        }\r\n" + "    }");

		// Use the builder to create AirQualityData
		AirQualityGeoPoint airQualityGeoPoint = new AirQualityGeoPointBuilder().withAQIData(aqiJson).build();

		// Assert general AQI data
		assertNotNull(airQualityGeoPoint);
		assertEquals(57, airQualityGeoPoint.getAqi(), "AQI value mismatch");
		assertEquals("pm25", airQualityGeoPoint.getDominentpol(), "Dominant pollutant mismatch");

		assertEquals("https://aqicn.org/city/germany/berlin/wedding-amrumer-str.", airQualityGeoPoint.getUrl(),
				"City URL mismatch");

		// Assert IAQI (Individual Air Quality Index)
		assertNotNull(airQualityGeoPoint.getIaqi(), "IAQI data is null");
		assertEquals(57, airQualityGeoPoint.getIaqi().getPm25().getV(), "PM2.5 mismatch");
		assertEquals(16, airQualityGeoPoint.getIaqi().getPm10().getV(), "PM10 mismatch");
		assertEquals(16.7, airQualityGeoPoint.getIaqi().getO3().getV(), 0.1, "O3 mismatch");
		assertEquals(3.7, airQualityGeoPoint.getIaqi().getNo2().getV(), 0.1, "NO2 mismatch");

		// Ensure air quality data is correctly built
		assertNotNull(airQualityGeoPoint);
	}

}
