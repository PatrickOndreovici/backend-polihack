package com.example.backendpolihack.service;

import com.example.backendpolihack.models.User;
import com.example.backendpolihack.models.dto.JwtResponse;
import com.example.backendpolihack.models.dto.UserLoginRequest;
import com.example.backendpolihack.models.dto.UserRegisterRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthService {

    public ResponseEntity<JwtResponse> login(UserLoginRequest request);

    public ResponseEntity<JwtResponse> create(UserRegisterRequest request);

    public ResponseEntity<JwtResponse> refresh(String refreshToken);
}