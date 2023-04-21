package com.Capstone.service;

import com.Capstone.payload.LoginDto;
import com.Capstone.payload.RegisterDto;

public interface AuthService {
    
	String loginUtente(LoginDto loginDto);
    String saveUtente(RegisterDto registerDto);
    
}
