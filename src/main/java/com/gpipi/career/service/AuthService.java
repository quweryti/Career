/**
 * AuthService
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.service;

import com.gpipi.career.domain.entity.Member;
import com.gpipi.career.service.dto.LoginRequestDto;
import com.gpipi.career.service.dto.MemberJoinRequestDto;

public interface AuthService {
	
	// 로그인
	Member login(LoginRequestDto requestDto);
	
	// 신규 회원 등록
	void register(MemberJoinRequestDto requestDto);
	
}
