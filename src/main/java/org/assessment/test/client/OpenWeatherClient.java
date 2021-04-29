package org.assessment.test.client;

import org.assessment.test.modal.CityCounterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "open-weather-api", url = "${openwheater.api.url}")
public interface OpenWeatherClient {

    @GetMapping()
    Optional<CityCounterResponse> getWeatherByCityCountry(@RequestParam("q") String q,
                                                          @RequestParam("appid") String appid);

    @GetMapping()
    Optional<CityCounterResponse> getWeatherByLatLng(@RequestParam("lat") String lat,
                                                     @RequestParam("lon") String lon,
                                                     @RequestParam("appid") String appid);

}
