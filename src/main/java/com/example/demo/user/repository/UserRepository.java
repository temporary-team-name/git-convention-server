package com.example.demo.user.repository;

import com.example.demo.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private final Map<String, User> userStore = new HashMap<>();

    public UserRepository() {
        User mockUser = new User();
        mockUser.setId("test");
        mockUser.setUsername("김윤미");
        mockUser.setPassword("1234");
        userStore.put(mockUser.getId(), mockUser);
    }

    public Optional<User> findById(String username) {
        return Optional.ofNullable(userStore.get(username));
    }
}
