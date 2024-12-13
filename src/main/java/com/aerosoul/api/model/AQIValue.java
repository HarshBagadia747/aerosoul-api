package com.aerosoul.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AQIValue {
	@JsonProperty("v")
	private double v;

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}
}
