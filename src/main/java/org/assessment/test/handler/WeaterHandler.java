package org.assessment.test.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assessment.test.client.OpenWeatherClient;
import org.assessment.test.modal.CityCounterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@Component
@RequiredArgsConstructor
public class WeaterHandler {

    private final OpenWeatherClient openWeatherClient;

    @Value("${openwheater.api.key}")
    String API_KEY;

    public Mono<ServerResponse> getWeatherByCityAndCountry(final ServerRequest serverRequest) {
        String q = serverRequest.pathVariable("q");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Optional<CityCounterResponse> cityMono = openWeatherClient.getWeatherByCityCountry(q, API_KEY);
        return Mono.just(cityMono).flatMap(user -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(BodyInserters.fromValue(user)))
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getWeatherLatLng(final ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON).build();
    }
}
