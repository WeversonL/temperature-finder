package br.com.temperature.finder.client;

import br.com.temperature.finder.model.OpenweatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Openweather", url = "${app.openweather-api}?appid=${app.openweather-key}&lang=pt_br&units=metric")
public interface OpenweatherClient {

    @GetMapping
    OpenweatherResponse getTemperature(
            @RequestParam("lat") Double lat,
            @RequestParam("lon") Double lon
    );

}
