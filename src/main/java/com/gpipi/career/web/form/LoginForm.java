/**
 * LoginForm.java
 * @since       2025-05-15
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.service.dto.LoginRequestDto
 * @see         com.gpipi.career.web.controller.AuthController
 */
package com.gpipi.career.web.form;

import com.gpipi.career.service.dto.LoginRequestDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginForm {
	
	@NotBlank(message = "E-mailを入力してください")
	@Email(message = "有効なE-mailを入力してください")
	private String memberEmail;
	
	@NotBlank(message = "パスワードを入力してください")
	private String memberPassword;
	
	public LoginRequestDto toRequestDto() {
		return new LoginRequestDto(
				this.memberEmail,
				this.memberPassword
		);
	}
	
}
