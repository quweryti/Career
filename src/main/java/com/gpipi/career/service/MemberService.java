/**
 * MemberService.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.service.implement.MemberServiceImpl
 */
package com.gpipi.career.service;

import com.gpipi.career.web.dto.MemberSessionDto;

public interface MemberService {
	
	public MemberSessionDto getDto(Long memberId);

	void updateName(String name, Long id);

	void updateLink(Long linkId, Long memberId, String newUrl);
	
	void deleteAccount(Long id);
	
}
