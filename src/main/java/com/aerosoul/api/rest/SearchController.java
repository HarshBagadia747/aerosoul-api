package com.aerosoul.api.rest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerosoul.api.manager.AQIManager;
import com.aerosoul.api.model.AirQualityGeoPoint;
import com.aerosoul.api.model.ApiResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:4200", "http://example.com" }, allowedHeaders = "*", methods = {
		RequestMethod.GET, RequestMethod.POST })
public class SearchController {

	@Autowired
	private AQIManager aqiManager;

	@GetMapping("/search")
	public ApiResponse search(@RequestParam String query, @RequestParam(defaultValue = "1") int limit)
			throws IOException {

		try {
			ApiResponse response = new ApiResponse();

			List<AirQualityGeoPoint> geoPoints = this.getAqiManager().search(query, limit);
			response.setTimestamp(LocalDateTime.now());
			response.setData(geoPoints);
			response.setCode(200);

			return response;
		} catch (final Exception e) {
			throw new IOException("Failed to search", e);
		}
	}

	public AQIManager getAqiManager() {
		return aqiManager;
	}

	public void setAqiManager(AQIManager aqiManager) {
		this.aqiManager = aqiManager;
	}

}
