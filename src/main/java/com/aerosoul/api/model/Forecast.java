package com.aerosoul.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Forecast {
	@JsonProperty("daily")
	private Daily daily;

	public Daily getDaily() {
		return daily;
	}

	public void setDaily(Daily daily) {
		this.daily = daily;
	}
}