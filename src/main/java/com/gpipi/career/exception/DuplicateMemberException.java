/**
 * DuplicateMemberException.java
 * @since       2025-05-13
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         java.lang.RuntimeException
 */
package com.gpipi.career.exception;

public class DuplicateMemberException extends RuntimeException {
	
	public DuplicateMemberException(String email) {
		super("既に登録されたE-mailです");
	}
	
}
