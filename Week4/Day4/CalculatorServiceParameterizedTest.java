
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceParameterizedTest {

    CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,5,15",
            "7,8,15",
            "0,5,5",
            "-2,2,0"
    })
    void testAdd(int a, int b, int expected) {

        assertEquals(expected, service.add(a, b));
    }
}