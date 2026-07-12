import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    static class CalculatorService {
        public int add(int a, int b) {
            return a + b;
        }
    }

    @Test
    void testAdd() {
        CalculatorService service = new CalculatorService();

        int result = service.add(10, 20);

        assertEquals(30, result);
    }
}