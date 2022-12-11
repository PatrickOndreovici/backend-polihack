package com.example.backendpolihack.controller;

import com.example.backendpolihack.models.dto.JwtResponse;
import com.example.backendpolihack.models.dto.UserLoginRequest;
import com.example.backendpolihack.models.dto.UserRegisterRequest;
import com.example.backendpolihack.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody UserLoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@Valid @RequestBody UserRegisterRequest userRegisterRequest) {
        return authService.create(userRegisterRequest);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<JwtResponse> refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }
}
