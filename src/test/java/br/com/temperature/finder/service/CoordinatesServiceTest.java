package br.com.temperature.finder.service;

import br.com.temperature.finder.client.CoordinatesFinderClient;
import br.com.temperature.finder.model.CoordinatesResponse;
import br.com.temperature.finder.service.impl.CoordinatesServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoordinatesServiceTest {
    @Mock
    private CoordinatesFinderClient coordinatesFinderClient;

    @Mock
    private CoordinatesResponse coordinatesResponse;

    @InjectMocks
    private CoordinatesServiceImpl coordinatesService;

    @Test
    public void testGetCoordinates_Success() {

        String address = "New York City";

        when(coordinatesFinderClient.getCoordinates(address)).thenReturn(coordinatesResponse);

        CoordinatesResponse result = coordinatesService.getCoordinates(address);

        assertEquals(coordinatesResponse, result);
        verify(coordinatesFinderClient, times(1)).getCoordinates(address);
        verifyNoMoreInteractions(coordinatesFinderClient);

    }

    @Test(expected = RuntimeException.class)
    public void testGetCoordinates_Exception() {
        String address = "Invalid Address";
        when(coordinatesFinderClient.getCoordinates(address)).thenThrow(new RuntimeException("Error"));
        coordinatesService.getCoordinates(address);
    }
}
