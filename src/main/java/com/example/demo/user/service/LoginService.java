package com.example.demo.user.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import com.example.demo.user.dto.LoginRequest;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class LoginService {

    private final UserRepository userRepository;
    private static final String SESSION_USER_KEY = "loginUser";

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(LoginRequest request, HttpSession session) {
        return userRepository.findById(request.getUsername())
                .map(user -> {
                    if (user.getPassword().equals(request.getPassword())) {

                        User sessionUser = new User();
                        sessionUser.setId(user.getId());
                        sessionUser.setUsername(user.getUsername());
                        session.setAttribute(SESSION_USER_KEY, sessionUser);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }
}
