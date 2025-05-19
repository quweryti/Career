/**
 * AuthService.java
 * @since       2025-05-13
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.service.implement.AuthServiceImpl
 */
package com.gpipi.career.service;

import com.gpipi.career.service.dto.MemberJoinRequestDto;

public interface AuthService {
	
	void register(MemberJoinRequestDto requestDto);
	
}
