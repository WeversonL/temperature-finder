package br.com.temperature.finder.service;

import br.com.temperature.finder.model.*;
import br.com.temperature.finder.service.impl.TemperatureServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureServiceTest {
    @Mock
    private CoordinatesService coordinatesService;

    @Mock
    private OpenweatherService openweatherService;

    @InjectMocks
    private TemperatureServiceImpl temperatureService;

    @Test
    public void testProcessAndGetTemperature_Success() {

        CoordinatesResponse coordinatesResponse = new CoordinatesResponse("A", 40.7128, -74.0060);
        OpenweatherResponse openweatherResponse = OpenweatherResponse.builder()
                .main(new Main(1.0, 1.0, 1.0, 1.0))
                .name("New York City")
                .weather(List.of(new Weather("A")))
                .build();

        when(coordinatesService.getCoordinates(anyString())).thenReturn(coordinatesResponse);
        when(openweatherService.getTemperature(anyDouble(), anyDouble())).thenReturn(openweatherResponse);

        Response result = temperatureService.processAndGetTemperature(anyString());

        assertEquals(openweatherResponse.getMain().getTemp(), result.getTemperature(), 1.0);
        assertEquals(openweatherResponse.getMain().getFeelsLike(), result.getThermalSensation(), 1.0);
        assertEquals(openweatherResponse.getMain().getTempMin(), result.getMinimumTemperature(), 1.0);
        assertEquals(openweatherResponse.getMain().getTempMax(), result.getMaximumTemperature(), 1.0);
        assertEquals(openweatherResponse.getWeather().get(0).getDescription(), result.getConditions());
        assertEquals(openweatherResponse.getName(), result.getLocation());

    }

    @Test(expected = RuntimeException.class)
    public void testProcessAndGetTemperature_Exception() {
        when(coordinatesService.getCoordinates(anyString())).thenThrow(new RuntimeException("Error"));

        temperatureService.processAndGetTemperature(anyString());
    }
}