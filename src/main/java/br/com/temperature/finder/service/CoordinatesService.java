package br.com.temperature.finder.service;

import br.com.temperature.finder.model.CoordinatesResponse;

public interface CoordinatesService {

    CoordinatesResponse getCoordinates(String address);

}
