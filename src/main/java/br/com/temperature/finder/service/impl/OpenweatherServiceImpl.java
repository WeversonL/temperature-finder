package br.com.temperature.finder.service.impl;

import br.com.temperature.finder.client.OpenweatherClient;
import br.com.temperature.finder.model.OpenweatherResponse;
import br.com.temperature.finder.service.OpenweatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenweatherServiceImpl implements OpenweatherService {

    private final OpenweatherClient openweatherClient;

    @Override
    public OpenweatherResponse getTemperature(Double latitude, Double longitude) {

        try {
            return openweatherClient.getTemperature(latitude, longitude);
        } catch (Exception e) {
            log.error("Error running the service OpenweatherService -> ", e);
            throw e;
        }
    }

}
