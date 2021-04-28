package org.assessment.test.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityCounterResponse {

    private Coordinates coord;
    private List<Weather> weather;
    private String base;
    private MainWeather main;
    private Long visibility;
    private Long dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
}
