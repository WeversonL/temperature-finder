package br.com.temperature.finder.controller;

import br.com.temperature.finder.model.Response;
import br.com.temperature.finder.service.TemperatureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureControllerTest {

    @Mock
    private TemperatureService temperatureService;

    @InjectMocks
    private TemperatureController temperatureController;

    @Test
    public void testGetTemperature() {

        String address = "New York City";
        Response expectedResponse = new Response("New York City", "A", 25.5, 25.5, 25.5, 25.5);

        when(temperatureService.processAndGetTemperature(address)).thenReturn(expectedResponse);

        ResponseEntity<Response> responseEntity = temperatureController.getTemperature(address);
        Response actualResponse = responseEntity.getBody();

        assertEquals(expectedResponse, actualResponse);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}