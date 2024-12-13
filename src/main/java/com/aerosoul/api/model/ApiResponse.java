package com.aerosoul.api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiResponse {

	@JsonProperty("code")
	private int code;

	@JsonProperty("data")
	private List<AirQualityGeoPoint> data;

	@JsonProperty("timestamp")
	private LocalDateTime timestamp;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<AirQualityGeoPoint> getData() {
		return data;
	}

	public void setData(List<AirQualityGeoPoint> data) {
		this.data = data;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
