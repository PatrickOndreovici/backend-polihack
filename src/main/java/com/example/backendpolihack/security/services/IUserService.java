package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.User;

public interface IUserService {
    User getUser(long userId);
}
