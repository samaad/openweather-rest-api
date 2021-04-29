package org.assessment.test.router;

import lombok.RequiredArgsConstructor;
import org.assessment.test.handler.WeaterHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableWebFlux
@RequiredArgsConstructor
public class ApplicationRouter {

    private final WeaterHandler weaterHandler;

    @Bean
    public RouterFunction<ServerResponse> mainFunction(){
        final String CITY_COUNTRY = "/cityCountry/{q}";
        final String LAT_LONG = "/latLng/{lat}/{lon}";

        return nest(accept(MediaType.APPLICATION_JSON),
                route(GET(CITY_COUNTRY), weaterHandler::getWeatherByCityAndCountry)
                    .andRoute(GET(LAT_LONG), weaterHandler::getWeatherLatLng));

    }
}
