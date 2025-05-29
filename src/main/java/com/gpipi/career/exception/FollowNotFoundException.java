/**
 * FollowNotFoundException.java
 * @since       2025-05-28
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         java.lang.RuntimeException
 */
package com.gpipi.career.exception;

public class FollowNotFoundException extends RuntimeException{
	
	public FollowNotFoundException(Long memberId, Long followeeId) {
		super("[" + memberId + "]이/가 [" + followeeId + "]를 팔로우한 기록이 없습니다.");
	}
	
}
