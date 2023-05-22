package br.com.temperature.finder.client;

import br.com.temperature.finder.model.CoordinatesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CoordinatesClient", url = "${app.coordinates-api}")
public interface CoordinatesFinderClient {

    @GetMapping
    CoordinatesResponse getCoordinates(@RequestParam("address") String address);

}
