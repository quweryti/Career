/**
 * MemberJoinRequestDto.java
 * @since       2025-04-23
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.web.dto.MemberJoinForm
 * @see         com.gpipi.career.service.implement.AuthServiceImpl
 */
package com.gpipi.career.service.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberJoinRequestDto {
	
	private final String memberName;
	private final String memberEmail;
	private final String memberPassword;
	
}
