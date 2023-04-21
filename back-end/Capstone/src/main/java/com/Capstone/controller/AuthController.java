package com.Capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.entity.User;
import com.Capstone.payload.JWTAuthResponse;
import com.Capstone.payload.LoginDto;
import com.Capstone.payload.RegisterDto;
import com.Capstone.repository.UserRepository;
import com.Capstone.service.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    
    @Autowired
    UserRepository userRepository;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = "/login")
    public ResponseEntity<JWTAuthResponse> loginUtente(@RequestBody LoginDto loginDto){  	
    	String token = authService.loginUtente(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setEmail(loginDto.getEmail());
        jwtAuthResponse.setAccessToken(token);
        User mom=userRepository.findByEmail(loginDto.getEmail());
        jwtAuthResponse.setUsername(mom.getUsername());

System.out.println(jwtAuthResponse);
        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = "/signup")
    public ResponseEntity<String> saveUtente(@RequestBody RegisterDto registerDto){
        String response = authService.saveUtente(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
