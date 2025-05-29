/**
 * InvalidCurrentPasswordException.java
 * @since       2025-05-28
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         java.lang.RuntimeException
 */
package com.gpipi.career.exception;

public class InvalidCurrentPasswordException extends RuntimeException {
	
	public InvalidCurrentPasswordException() {
		super("현재 비밀번호가 올바르지 않습니다.");
	}
	
	public InvalidCurrentPasswordException(String message) {
		super(message);
	}

}
