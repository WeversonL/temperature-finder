package br.com.temperature.finder.client;

import br.com.temperature.finder.model.CoordinatesResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoordinatesFinderClientTest {

    @Mock
    private CoordinatesFinderClient coordinatesFinderClient;

    @Test
    public void testGetCoordinates() {

        CoordinatesResponse coordinatesResponse = new CoordinatesResponse();

        when(coordinatesFinderClient.getCoordinates(anyString())).thenReturn(coordinatesResponse);

        CoordinatesResponse result = coordinatesFinderClient.getCoordinates(anyString());

        assertEquals(coordinatesResponse, result);
    }
}
