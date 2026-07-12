import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserControllerTest.UserController.class)
public class UserControllerTest {

    static class User {
        public Long id;
        public String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    interface UserService {
        User getUserById(Long id);
    }

    @RestController
    @RequestMapping("/users")
    static class UserController {

        @Autowired
        UserService userService;

        @GetMapping("/{id}")
        public ResponseEntity<User> getUser(@PathVariable Long id) {
            return ResponseEntity.ok(userService.getUserById(id));
        }
    }

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    void testGetUser() throws Exception {

        when(userService.getUserById(1L))
                .thenReturn(new User(1L, "Arjoo"));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arjoo"));
    }
}