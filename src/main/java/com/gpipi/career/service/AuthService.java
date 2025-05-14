/**
 * AuthService
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.service;

import com.gpipi.career.service.dto.MemberJoinRequestDto;

public interface AuthService {
	// 신규 회원 등록
	void registerMember(MemberJoinRequestDto requestDto);

}
