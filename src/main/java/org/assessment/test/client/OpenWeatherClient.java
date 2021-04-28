package org.assessment.test.client;

import org.assessment.test.modal.CityCounterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "open-weather-api", url = "${openwheater.api.url}")
public interface OpenWeatherClient {

    @GetMapping()
    Optional<CityCounterResponse> getWeatherByCityCountry(@RequestParam("q") String q, @RequestParam("appid") String appid);

}
