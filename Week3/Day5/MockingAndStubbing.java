import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MockingAndStubbingTest {

    interface WeatherService {
        String getWeather();
    }

    @Test
    void testMultipleReturns() {

        WeatherService service = mock(WeatherService.class);

        when(service.getWeather())
                .thenReturn("Sunny")
                .thenReturn("Rainy")
                .thenReturn("Cloudy");

        assertEquals("Sunny", service.getWeather());
        assertEquals("Rainy", service.getWeather());
        assertEquals("Cloudy", service.getWeather());

        verify(service, times(3)).getWeather();

        System.out.println("Multiple return values verified.");
    }
}