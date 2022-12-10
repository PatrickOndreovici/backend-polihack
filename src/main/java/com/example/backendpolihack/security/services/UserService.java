package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.User;
import com.example.backendpolihack.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
