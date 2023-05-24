package br.com.temperature.finder.service.impl;

import br.com.temperature.finder.client.CoordinatesFinderClient;
import br.com.temperature.finder.model.CoordinatesResponse;
import br.com.temperature.finder.service.CoordinatesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoordinatesServiceImpl implements CoordinatesService {

    private final CoordinatesFinderClient coordinatesFinderClient;

    @Override
    public CoordinatesResponse getCoordinates(String address) {
        try {
            return coordinatesFinderClient.getCoordinates(address);
        } catch (Exception e) {
            log.error("Error running the service CoordinatesService -> ", e);
            throw e;
        }

    }

}
