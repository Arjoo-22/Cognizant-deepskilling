import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    void testIntegration() {

        User user = new User();
        user.setName("Arjoo");

        User savedUser = userService.saveUser(user);

        User fetchedUser = userService.getUserById(savedUser.getId());

        assertNotNull(fetchedUser);
        assertEquals("Arjoo", fetchedUser.getName());
    }
}