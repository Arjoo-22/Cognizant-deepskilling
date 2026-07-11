import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// REST Client Interface
interface RestClient {
    String getResponse();
}

// Service Class
class ApiService {

    private RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchData() {
        return "Fetched " + restClient.getResponse();
    }
}

// Test Class
public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {

        RestClient mockRestClient = mock(RestClient.class);

        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        ApiService apiService = new ApiService(mockRestClient);

        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);

        verify(mockRestClient).getResponse();
    }
}