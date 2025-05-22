/**
 * MemberSessionDto.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.service.MemberService
 */
package com.gpipi.career.web.dto;

import java.util.List;

import com.gpipi.career.domain.entity.Member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberSessionDto {
	private String name;
	private String email;
	private List<String> links;
	private List<Long> followIds;
	
	public static MemberSessionDto fromEntity(Member member,
											  List<String> links,
											  List<Long> follows) {
		return MemberSessionDto.builder()
				.name(member.getName())
				.email(member.getEmail())
				.links(links)
				.followIds(follows)
				.build();
	}

}
