package com.example.backendpolihack.service;

import com.example.backendpolihack.models.ERole;
import com.example.backendpolihack.models.Student;
import com.example.backendpolihack.models.User;
import com.example.backendpolihack.models.dto.JwtResponse;
import com.example.backendpolihack.models.dto.UserDTO;
import com.example.backendpolihack.models.dto.UserLoginRequest;
import com.example.backendpolihack.models.dto.UserRegisterRequest;
import com.example.backendpolihack.repository.StudentRepository;
import com.example.backendpolihack.repository.UserRepository;
import com.example.backendpolihack.security.jwt.JwtTokenUtil;
import com.example.backendpolihack.security.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService{
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl myUserDetailsService;
    private final UserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<JwtResponse> login(UserLoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getEmail());
            final String token = jwtTokenUtil.generateAccessToken(userDetails.getUsername(), Date.from(ZonedDateTime.now()
                    .plusMinutes(6000)
                    .toInstant()));
            final String refreshToken = jwtTokenUtil.generateAccessToken(userDetails.getUsername(), Date.from(ZonedDateTime.now()
                    .plusDays(7)
                    .toInstant()));
            return ResponseEntity.ok()
                    .body(new JwtResponse(token, refreshToken, applicationUserRepository.findByEmail(userDetails.getUsername()).orElse(null).getRole()));
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("Bad credentials");
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public ResponseEntity<JwtResponse> create(UserRegisterRequest request) {
        if (applicationUserRepository.findByEmail(request.getEmail()).orElse(null) != null) {
            throw new RuntimeException("User already exists");
        }

        request.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        System.out.println(request);
        User user = new User(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(),
                ERole.STUDENT);
        user = applicationUserRepository.save(user);
        System.out.println(user.getRole());
        Student student = new Student(user.getId());
        studentRepository.save(student);

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(request.getEmail());
        final String token = jwtTokenUtil.generateAccessToken(userDetails.getUsername(), Date.from(ZonedDateTime.now()
                .plusMinutes(6000)
                .toInstant()));
        final String refreshToken = jwtTokenUtil.generateAccessToken(userDetails.getUsername(), Date.from(ZonedDateTime.now()
                .plusDays(7)
                .toInstant()));

        return ResponseEntity.ok()
                .body(new JwtResponse(token, refreshToken, applicationUserRepository.findByEmail(userDetails.getUsername()).orElse(null).getRole()));

    }

    @Override
    public ResponseEntity<JwtResponse> refresh(String refreshToken) {
        String email = jwtTokenUtil.getUsername(refreshToken);
        String token = jwtTokenUtil.generateAccessToken(email, Date.from(ZonedDateTime.now()
                .plusMinutes(6000)
                .toInstant()));
        JwtResponse jwtResponse = new JwtResponse(token, refreshToken, applicationUserRepository.findByEmail(email).orElse(null).getRole());
        return ResponseEntity.ok()
                .body(jwtResponse);
    }
}
