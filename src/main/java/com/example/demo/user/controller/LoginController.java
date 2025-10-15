package com.example.demo.user.controller;

import com.example.demo.user.dto.LoginRequest;
import com.example.demo.user.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(
        origins = "http://192.168.1.64:5173", // 프론트 주소
        allowCredentials = "true"          // 세션/쿠키 공유 허용
)

@RestController
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request, HttpSession session) {

        Map<String, Object> response = new HashMap<>();
        boolean success = loginService.login(request, session);

        response.put("success", success);
        response.put("message", success ? "로그인 성공" : "로그인 실패");

        if (success) {
            Object loginUser = session.getAttribute("loginUser");
            response.put("user", loginUser);
        }

        return response;
    }

    @PostMapping("/logout")
    public Map<String, Object> logout(HttpSession session) {

        Map<String, Object> response = new HashMap<>();
        session.invalidate();

        return response;
    }
}
