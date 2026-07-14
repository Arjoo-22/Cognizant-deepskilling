import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Entity
class User{

    @Id
    private Long id;
    private String name;

    public User(){}

    public User(Long id,String name){
        this.id=id;
        this.name=name;
    }

    public Long getId(){ return id; }
    public String getName(){ return name; }

    public void setId(Long id){ this.id=id; }
    public void setName(String name){ this.name=name; }
}

@Service
class UserService{

    public User saveUser(User user){
        return user;
    }
}

@RestController
@RequestMapping("/users")
class UserController{

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(service.saveUser(user));
    }
}

@WebMvcTest(UserController.class)
public class UserControllerPostTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService service;

    @Autowired
    ObjectMapper mapper;

    @Test
    void testCreateUser() throws Exception {

        User user = new User(1L,"Arjoo");

        when(service.saveUser(user)).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(mapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arjoo"));
    }
}