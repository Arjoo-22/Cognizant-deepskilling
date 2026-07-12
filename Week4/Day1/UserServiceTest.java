import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

public class UserServiceTest {

    static class User {
        private Long id;
        private String name;

        public User() {}

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    interface UserRepository {
        Optional<User> findById(Long id);
    }

    static class UserService {
        private UserRepository repository;

        UserService(UserRepository repository) {
            this.repository = repository;
        }

        public User getUserById(Long id) {
            return repository.findById(id).orElse(null);
        }
    }

    @Test
    void testGetUserById() {

        UserRepository repository = mock(UserRepository.class);

        User user = new User(1L, "Arjoo");

        when(repository.findById(1L)).thenReturn(Optional.of(user));

        UserService service = new UserService(repository);

        User result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals("Arjoo", result.getName());

        verify(repository).findById(1L);
    }
}