package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import jakarta.persistence.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@Entity
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<User, Long> {

    List<User> findByName(String name);
}

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void testFindByName() {

        repository.save(new User("Arjoo"));
        repository.save(new User("Rahul"));

        List<User> users = repository.findByName("Arjoo");

        assertEquals(1, users.size());
        assertEquals("Arjoo", users.get(0).getName());
    }
}