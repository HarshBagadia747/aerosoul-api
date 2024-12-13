package com.aerosoul.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Time {
	@JsonProperty("s")
	private String s;

	@JsonProperty("tz")
	private String tz;

	@JsonProperty("v")
	private long v;

	@JsonProperty("iso")
	private String iso;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public long getV() {
		return v;
	}

	public void setV(long v) {
		this.v = v;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

}
