package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("User not found");
    }
}

@RestController
class UserController {

    @GetMapping("/user")
    public String getUser() {

        throw new NoSuchElementException();
    }
}

@WebMvcTest(UserController.class)
@Import(GlobalExceptionHandler.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testExceptionHandler() throws Exception {

        mockMvc.perform(get("/user"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}