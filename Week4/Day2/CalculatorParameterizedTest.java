package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// Service
class CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }
}

public class CalculatorParameterizedTest {

    CalculatorService service = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "5,5,10",
            "10,20,30",
            "0,7,7",
            "-2,2,0"
    })
    void testAdd(int a, int b, int expected) {

        assertEquals(expected, service.add(a, b));
    }
}