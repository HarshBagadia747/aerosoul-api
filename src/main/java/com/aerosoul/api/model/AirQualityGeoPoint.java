package com.aerosoul.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirQualityGeoPoint {
	@JsonProperty("lat")
	private String lat;

	@JsonProperty("lon")
	private String lon;

	@JsonProperty("category")
	private String category;

	@JsonProperty("type")
	private String type;

	@JsonProperty("address_type")
	private String addressType;

	@JsonProperty("name")
	private String name;

	@JsonProperty("display_name")
	private String displayName;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("bounding_box")
	private List<String> boundingBox;

	@JsonProperty("aqi")
	private int aqi;

	@JsonProperty("url")
	private String url;

	@JsonProperty("dominentpol")
	private String dominentpol;

	@JsonProperty("iaqi")
	private IAQI iaqi;

	@JsonProperty("time")
	private Time time;

	@JsonProperty("forecast")
	private Forecast forecast;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(List<String> boundingBox) {
		this.boundingBox = boundingBox;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDominentpol() {
		return dominentpol;
	}

	public void setDominentpol(String dominentpol) {
		this.dominentpol = dominentpol;
	}

	public IAQI getIaqi() {
		return iaqi;
	}

	public void setIaqi(IAQI iaqi) {
		this.iaqi = iaqi;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

}
