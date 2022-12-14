package com.example.backendpolihack.security.services;

import com.example.backendpolihack.models.User;
import com.example.backendpolihack.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User applicationUser = userRepository.findByEmail(email).orElse(null);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(email);
        }
        System.out.println("Sunt in loadUserByUsername" + applicationUser.toString());
        return new org.springframework.security.core.userdetails.User(applicationUser.getEmail(), applicationUser.getPassword(), Arrays.asList(new SimpleGrantedAuthority(applicationUser.getRole()
                .name())));
    }

}
