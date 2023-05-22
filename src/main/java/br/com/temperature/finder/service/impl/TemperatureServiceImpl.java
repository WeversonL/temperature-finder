package br.com.temperature.finder.service.impl;

import br.com.temperature.finder.model.CoordinatesResponse;
import br.com.temperature.finder.model.OpenweatherResponse;
import br.com.temperature.finder.model.Response;
import br.com.temperature.finder.service.CoordinatesService;
import br.com.temperature.finder.service.OpenweatherService;
import br.com.temperature.finder.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemperatureServiceImpl implements TemperatureService {

    private final CoordinatesService coordinatesService;
    private final OpenweatherService openweatherService;

    DecimalFormat df = new DecimalFormat("#.0");

    @Override
    public Response processAndGetTemperature(String address) {

        try {

            log.info("Starting temperature search...");

            CoordinatesResponse coordinates = coordinatesService.getCoordinates(address);

            OpenweatherResponse temperature = openweatherService.getTemperature(coordinates.getLatitude(), coordinates.getLongitude());

            log.info("Sucess request. Response -> {}", temperature);

            return Response.builder()
                    .temperature(temperature.getMain().getTemp())
                    .thermalSensation(temperature.getMain().getFeelsLike())
                    .minimumTemperature(temperature.getMain().getTempMin())
                    .maximumTemperature(temperature.getMain().getTempMax())
                    .conditions(temperature.getWeather().get(0).getDescription())
                    .location(temperature.getName())
                    .build();

        } catch (Exception e) {
            log.error("Error running the service -> {0}", e);
            throw e;
        }

    }

}
