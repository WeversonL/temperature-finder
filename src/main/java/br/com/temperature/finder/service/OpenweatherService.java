package br.com.temperature.finder.service;

import br.com.temperature.finder.model.OpenweatherResponse;

public interface OpenweatherService {

    OpenweatherResponse getTemperature(Double latitude, Double longitude);

}
