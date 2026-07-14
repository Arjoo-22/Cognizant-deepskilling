import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Entity
class User {

    @Id
    private Long id;
    private String name;

    public User() {}

    public User(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

@Service
class UserService {
    public User getUserById(Long id){
        return null;
    }
}

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
}

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService service;

    @Test
    void testGetUser() throws Exception {

        when(service.getUserById(1L))
                .thenReturn(new User(1L,"Arjoo"));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arjoo"));
    }
}