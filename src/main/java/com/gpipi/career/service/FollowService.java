/**
 * FollowService.java
 * @since       2025-05-28
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.
 */
package com.gpipi.career.service;

public interface FollowService {

	void deleteFollow(Long followeeId, Long memberId);

}
