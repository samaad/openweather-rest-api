package org.assessment.test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assessment.test.client.OpenWeatherClient;
import org.assessment.test.modal.CityCounterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeatherService {

    private final OpenWeatherClient openWeatherClient;

    @Value("${openwheater.api.key}")
    String API_KEY;

    @Cacheable("cacheOpenWeather")
    public Optional<CityCounterResponse> getWeatherByCityCountry(String q ){
        log.info("city service was called");
        return openWeatherClient.getWeatherByCityCountry(q, API_KEY);
    }

    @Cacheable("cacheOpenWeather")
    public Optional<CityCounterResponse> getWeatherByLatLng(String lat, String lon) {
        log.info("coordinates service was called");
        return openWeatherClient.getWeatherByLatLng(lat, lon, API_KEY);
    }
}
