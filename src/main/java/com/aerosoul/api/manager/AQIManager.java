package com.aerosoul.api.manager;

import java.io.IOException;
import java.util.List;

import com.aerosoul.api.model.AirQualityGeoPoint;

public interface AQIManager {

	List<AirQualityGeoPoint> search(String query, int limit) throws IOException;
}
