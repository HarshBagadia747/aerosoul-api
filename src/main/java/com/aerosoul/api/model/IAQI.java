package com.aerosoul.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IAQI {
	@JsonProperty("no2")
	private AQIValue no2;

	@JsonProperty("o3")
	private AQIValue o3;

	@JsonProperty("p")
	private AQIValue p;

	@JsonProperty("pm10")
	private AQIValue pm10;

	@JsonProperty("pm25")
	private AQIValue pm25;

	@JsonProperty("t")
	private AQIValue t;

	public AQIValue getNo2() {
		return no2;
	}

	public void setNo2(AQIValue no2) {
		this.no2 = no2;
	}

	public AQIValue getO3() {
		return o3;
	}

	public void setO3(AQIValue o3) {
		this.o3 = o3;
	}

	public AQIValue getP() {
		return p;
	}

	public void setP(AQIValue p) {
		this.p = p;
	}

	public AQIValue getPm10() {
		return pm10;
	}

	public void setPm10(AQIValue pm10) {
		this.pm10 = pm10;
	}

	public AQIValue getPm25() {
		return pm25;
	}

	public void setPm25(AQIValue pm25) {
		this.pm25 = pm25;
	}

	public AQIValue getT() {
		return t;
	}

	public void setT(AQIValue t) {
		this.t = t;
	}

}
