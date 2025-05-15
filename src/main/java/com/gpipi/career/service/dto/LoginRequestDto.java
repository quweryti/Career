/**
 * LoginRequestDto
 * 	
 * @see		LoginForm.java
 * 			AuthService.java
 * 			AuthDao.java
 * @since	2025/05/15
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequestDto {

	private final String memberEmail;
	private final String memberPassword;
	
}
