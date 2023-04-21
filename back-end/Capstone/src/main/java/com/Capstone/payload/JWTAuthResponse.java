package com.Capstone.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String email;
    private String accessToken;
    private String username;
    private String tokenType = "Bearer";
}
