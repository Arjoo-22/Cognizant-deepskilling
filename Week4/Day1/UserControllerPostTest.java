import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserControllerPostTest.UserController.class)
public class UserControllerPostTest {

    static class User {

        public Long id;
        public String name;

        public User() {}

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    interface UserService {
        User saveUser(User user);
    }

    @RestController
    @RequestMapping("/users")
    static class UserController {

        @Autowired
        UserService userService;

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            return ResponseEntity.ok(userService.saveUser(user));
        }
    }

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserService userService;

    @Test
    void testCreateUser() throws Exception {

        User user = new User(1L, "Arjoo");

        when(userService.saveUser(org.mockito.ArgumentMatchers.any(User.class)))
                .thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arjoo"));
    }
}