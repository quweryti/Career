/**
 * FollowServiceImpl.java
 * @since       2025-05-28
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.
 */
package com.gpipi.career.service.implement;

import org.springframework.stereotype.Service;

import com.gpipi.career.dao.repository.FollowRepository;
import com.gpipi.career.exception.FollowNotFoundException;
import com.gpipi.career.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {
	
	private final FollowRepository followRepository;
	
	public FollowServiceImpl(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}
	
	@Override
	public void deleteFollow(Long followeeId, Long memberId) {
		boolean exists = followRepository.existsByMemberIdAndFolloweeId(memberId, followeeId);

		if(!exists) {
			throw new FollowNotFoundException(memberId, followeeId);
		}
		
		followRepository.deleteByMember_MemberIdAndFollowee_FolloweeId(memberId, followeeId);
	}
	
}
