

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testFindByName() {

        User user = new User();
        user.setName("Arjoo");
        repository.save(user);

        List<User> users = repository.findByName("Arjoo");

        assertEquals(1, users.size());
        assertEquals("Arjoo", users.get(0).getName());
    }
}