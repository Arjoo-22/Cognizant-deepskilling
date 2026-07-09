import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

interface ExternalApi {
    String getData(String name);
}

class MyService {

    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData(String name) {
        return api.getData(name);
    }
}

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData(anyString())).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        String result = service.fetchData("Arjoo");

        assertEquals("Mock Data", result);

        verify(mockApi).getData(anyString());
    }
}