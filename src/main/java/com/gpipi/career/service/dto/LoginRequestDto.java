/**
 * LoginRequestDto.java
 * @since       2025-05-15
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.web.dto.LoginForm
 * @see         com.gpipi.career.service.AuthService
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
