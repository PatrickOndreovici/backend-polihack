package com.example.backendpolihack.service;

import com.example.backendpolihack.models.User;

public interface IUserService {
    User getUserByEmail(String email);
}
