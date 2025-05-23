/**
 * MemberServiceImpl.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.service.MemberService
 */
package com.gpipi.career.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpipi.career.dao.repository.MemberRepository;
import com.gpipi.career.dao.repository.ProfileImageRepository;
import com.gpipi.career.dao.repository.FollowRepository;
import com.gpipi.career.dao.repository.LinkRepository;
import com.gpipi.career.domain.entity.Member;
import com.gpipi.career.service.MemberService;
import com.gpipi.career.web.dto.MemberSessionDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	private final LinkRepository linkRepository;
	private final FollowRepository followRepository;
	private final ProfileImageRepository profileImageRepository;
	
	@Override
	public MemberSessionDto getDto(Long memberId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() ->
				new IllegalArgumentException("会員情報がございません" + memberId));
		
		List<String> links = linkRepository.findUrlByMember_MemberId(member.getMemberId());
		List<Long> follows = followRepository.findFolloweeIdByMember_MemberId(member.getMemberId());
		String profileImageUrl = profileImageRepository
								 .findByMember_MemberId(memberId)
								 .map(pi -> pi.getResolveUrl())
								 .orElse("/images/profile/default.png");
		
		return MemberSessionDto.fromEntity(member, links, follows, profileImageUrl);
	}
	
};
