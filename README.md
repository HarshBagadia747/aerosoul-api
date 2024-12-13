
# AeroSoul API

This project implements a robust Air Quality Index (AQI) API with caching and REST exception handling. It integrates with OpenStreetMap for geocoding and AQICN for retrieving AQI data, providing a seamless user experience for tracking air quality.

## Features

- **AQI Data with Caching**: 
  - Implemented caching for AQI data using the `@Cacheable` annotation and cache headers to improve performance.
  - Used **Caffeine Cache** for local environments to manage cache expiry and max entries.
  
- **Search and Geocoding**:
  - Integrated OpenStreetMap API for geocoding and AQICN API for retrieving real-time AQI data based on geographical coordinates.
  
- **AQI Data Representation**:
  - Created models such as `AirQualityGeoPoint`, `IAQI`, `Forecast`, and others to structure AQI data.
  - Used the **Builder Pattern** for modeling `AirQualityGeoPoint` for clean and flexible object construction.
  
- **AQI Manager**:
  - Developed `AQIManagerImpl` to handle AQI-related logic, including data retrieval from external APIs and cache management.
  
- **REST Exception Handling**:
  - Implemented a custom `RestExceptionHandler` to provide consistent error handling across the application.

- **Custom Cache Configuration**:
  - Added a `CacheConfig` class to manage caching behavior, including cache expiry times and maximum entries.

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/HarshBagadia747/aerosoul-api.git
   ```

2. **Install dependencies**:
   This project uses Maven for dependency management. Run the following command to install the necessary dependencies:
   ```bash
   mvn install
   ```

3. **Configuration**:
   - Update the `application.properties` and `application-dev.properties` files for environment-specific configurations.
   - Ensure you have internet access for fetching AQI and geocoding data.

4. **Run the application**:
   To run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

## Testing

Test cases for the **AirQualityGeoPointBuilder** have been added to ensure the proper construction of AQI-related objects. You can run the tests using:
```bash
mvn test
```

## Project Structure

- **com.aerosoul.api**:
  - Contains the main business logic and services, including AQI data handling and caching logic.
  
- **com.aerosoul.api.model**:
  - Contains the data models, such as `AirQualityGeoPoint`, `IAQI`, `Forecast`, etc.
  
- **com.aerosoul.api.client**:
  - Contains client integrations for the OpenStreetMap and AQICN APIs.

- **com.aerosoul.api.cache**:
  - Contains configuration for caching using Caffeine and cache management logic.

- **com.aerosoul.api.rest**:
  - Contains the REST controllers and exception handling logic.

## Additional Updates

- **.gitignore** has been updated for better project coverage, ensuring that build and IDE files are ignored.
- The project packages have been organized for better modularity and easier maintenance.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to contribute or open issues for any suggestions or bug fixes!
