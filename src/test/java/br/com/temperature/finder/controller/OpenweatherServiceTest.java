package br.com.temperature.finder.controller;

import br.com.temperature.finder.client.OpenweatherClient;
import br.com.temperature.finder.model.OpenweatherResponse;
import br.com.temperature.finder.service.impl.OpenweatherServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OpenweatherServiceTest {

    @Mock
    private OpenweatherClient openweatherClient;

    @Mock
    private OpenweatherResponse openweatherResponse;

    @InjectMocks
    private OpenweatherServiceImpl openweatherService;

    @Test
    public void testGetTemperature_Success() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        when(openweatherClient.getTemperature(latitude, longitude)).thenReturn(openweatherResponse);

        OpenweatherResponse result = openweatherService.getTemperature(latitude, longitude);

        assertEquals(openweatherResponse, result);
        verify(openweatherClient, times(1)).getTemperature(latitude, longitude);
        verifyNoMoreInteractions(openweatherClient);
    }

    @Test(expected = RuntimeException.class)
    public void testGetTemperature_Exception() {
        double latitude = 40.7128;
        double longitude = -74.0060;

        when(openweatherClient.getTemperature(latitude, longitude)).thenThrow(new RuntimeException("Error"));

        openweatherService.getTemperature(latitude, longitude);
    }

}
