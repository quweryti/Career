/**
 * MemberSessionDto.java
 * @since       2025-05-16
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         jakarta.persistence.Entity
 * @see         com.gpipi.career.domain.entity.Member
 */
package com.gpipi.career.web.dto;

import lombok.Getter;

@Getter
public class MemberSessionDto {
	
	private final String memberName;
	private final String memberEmail;
	
	public MemberSessionDto(String memberName, String memberEmail) {
		this.memberName = memberName;
		this.memberEmail = memberEmail;
	}
	
}
