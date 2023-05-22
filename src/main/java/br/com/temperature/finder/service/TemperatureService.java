package br.com.temperature.finder.service;

import br.com.temperature.finder.model.Response;

public interface TemperatureService {

    Response processAndGetTemperature(String address);

}
