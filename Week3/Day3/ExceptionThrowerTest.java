package com.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    ExceptionThrower obj = new ExceptionThrower();

    @Test
    void testException(){

        assertThrows(

                IllegalArgumentException.class,

                ()->obj.throwException()

        );

    }

}