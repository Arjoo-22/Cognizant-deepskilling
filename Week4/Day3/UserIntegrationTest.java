import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Entity
class User {

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

interface UserRepository extends JpaRepository<User,Long>{}

@Service
class UserService{

    @Autowired
    UserRepository repository;

    public User getUserById(Long id){
        return repository.findById(id).orElse(null);
    }

    public User save(User user){
        return repository.save(user);
    }
}

@RestController
@RequestMapping("/users")
class UserController{

    @Autowired
    UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }
}

@SpringBootApplication
class TestApplication{}

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository repository;

    @Test
    void testIntegration() throws Exception {

        repository.save(new User(1L,"Arjoo"));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Arjoo"));
    }
}