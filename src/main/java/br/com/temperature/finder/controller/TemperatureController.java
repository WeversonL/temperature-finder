package br.com.temperature.finder.controller;

import br.com.temperature.finder.model.Response;
import br.com.temperature.finder.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TemperatureController {

    private final TemperatureService temperatureService;

    @GetMapping("/find")
    public ResponseEntity<Response> getTemperature(@RequestParam("address") String address) {

        Response response = temperatureService.processAndGetTemperature(address);

        return ResponseEntity.ok(response);

    }

}
