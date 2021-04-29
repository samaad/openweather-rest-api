package org.assessment.test.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assessment.test.modal.CityCounterResponse;
import org.assessment.test.service.WeatherService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeaterHandler {

    private final WeatherService weatherService;

    public Mono<ServerResponse> getWeatherByCityAndCountry(final ServerRequest serverRequest) {
        String q = serverRequest.pathVariable("q");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Optional<CityCounterResponse> cityMono = weatherService.getWeatherByCityCountry(q);
        return Mono.just(cityMono).flatMap(user -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromValue(user)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getWeatherLatLng(final ServerRequest serverRequest) {
        String lat = serverRequest.pathVariable("lat");
        String lon = serverRequest.pathVariable("lon");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Optional<CityCounterResponse> cityMono = weatherService.getWeatherByLatLng(lat, lon);
        return Mono.just(cityMono).flatMap(user -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromValue(user)))
                .switchIfEmpty(notFound);
    }
}
