/**
 * DuplicateMemberException
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.service.exception;

public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String email) {
		super("既に登録されたE-mailです。");
	}
}
