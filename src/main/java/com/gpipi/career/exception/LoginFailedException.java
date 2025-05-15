/**
 * LoginFailedException
 * 	
 * 
 * @since	2025/05/15
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.exception;

public class LoginFailedException extends RuntimeException {
	
	public LoginFailedException(String logs) {
		super("メールアドレスまたはパスワードが正しくありません");
	}
	
}
