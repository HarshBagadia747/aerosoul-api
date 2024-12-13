package com.aerosoul.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForecastItem {
	@JsonProperty("avg")
	private int avg;

	@JsonProperty("day")
	private String day;

	@JsonProperty("max")
	private int max;

	@JsonProperty("min")
	private int min;

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

}