package com.jala_academy.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTAuthResponse {
	 private String accessToken;
     private String tokenType = "Bearer";
}
