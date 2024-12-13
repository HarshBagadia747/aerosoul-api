package com.aerosoul.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Daily {
	@JsonProperty("o3")
	private List<ForecastItem> o3;

	@JsonProperty("pm10")
	private List<ForecastItem> pm10;

	@JsonProperty("pm25")
	private List<ForecastItem> pm25;

	@JsonProperty("uvi")
	private List<ForecastItem> uvi;

	public List<ForecastItem> getO3() {
		return o3;
	}

	public void setO3(List<ForecastItem> o3) {
		this.o3 = o3;
	}

	public List<ForecastItem> getPm10() {
		return pm10;
	}

	public void setPm10(List<ForecastItem> pm10) {
		this.pm10 = pm10;
	}

	public List<ForecastItem> getPm25() {
		return pm25;
	}

	public void setPm25(List<ForecastItem> pm25) {
		this.pm25 = pm25;
	}

	public List<ForecastItem> getUvi() {
		return uvi;
	}

	public void setUvi(List<ForecastItem> uvi) {
		this.uvi = uvi;
	}

}
