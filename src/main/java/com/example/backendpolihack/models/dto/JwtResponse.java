package com.example.backendpolihack.models.dto;

import com.example.backendpolihack.models.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String accessToken;
    private String refreshToken;
    private ERole role;
}
