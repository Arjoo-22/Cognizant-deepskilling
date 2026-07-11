import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// Repository Interface
interface Repository {
    String getData();
}

// Service Class
class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        return "Processed " + repository.getData();
    }
}

// Test Class
public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {

        Repository mockRepository = mock(Repository.class);

        when(mockRepository.getData()).thenReturn("Mock Data");

        Service service = new Service(mockRepository);

        String result = service.processData();

        assertEquals("Processed Mock Data", result);

        verify(mockRepository).getData();
    }
}