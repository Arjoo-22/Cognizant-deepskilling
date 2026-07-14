import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService service = new CalculatorService();

        int result = service.add(10, 20);

        assertEquals(30, result);
    }
}