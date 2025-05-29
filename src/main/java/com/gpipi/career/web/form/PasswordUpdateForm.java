/**
 * PasswordUpdateForm.java
 * @since       2025-05-26
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.
 */
package com.gpipi.career.web.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordUpdateForm {
	
	@NotBlank(message = "現在設定しているパスワードを入力してください")
	private String currentPassword;
	
	@NotBlank(message = "新しいパスワードを入力してください")
	@Size(min = 8, max = 24, message = "パスワードは8文字以上24文字以内で設定してください")
	@Pattern(regexp = "^[A-Za-z0-9!@#$%^&*]{8,24}$", message = "パスワードに許可されない文字が含まれています")
	private String newPassword;
	
	@NotBlank(message = "パスワードの確認を入力してください")
	private String confirmPassword;
	
	@AssertTrue(message = "新しいパスワードとパスワードの確認が一致しません")
	public boolean isPasswordConfirmed() {
		if(newPassword == null || confirmPassword == null) {
			return false;
		}
		
		return newPassword.equals(confirmPassword);
	}
	
}
