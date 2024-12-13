package com.aerosoul.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("ISO3166-2-lvl4")
	private String iso3166Lvl4;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("country")
	private String country;

	@JsonProperty("country_code")
	private String countryCode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIso3166Lvl4() {
		return iso3166Lvl4;
	}

	public void setIso3166Lvl4(String iso3166Lvl4) {
		this.iso3166Lvl4 = iso3166Lvl4;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}