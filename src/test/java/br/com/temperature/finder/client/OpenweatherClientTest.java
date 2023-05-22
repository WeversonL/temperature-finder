package br.com.temperature.finder.client;

import br.com.temperature.finder.model.OpenweatherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OpenweatherClientTest {

    @Mock
    private OpenweatherClient openweatherClient;

    @Test
    public void testGetWeather() {

        OpenweatherResponse openweatherResponse = new OpenweatherResponse();

        when(openweatherClient.getTemperature(anyDouble(), anyDouble())).thenReturn(openweatherResponse);

        OpenweatherResponse result = openweatherClient.getTemperature(anyDouble(), anyDouble());

        assertEquals(openweatherResponse, result);
    }

}
