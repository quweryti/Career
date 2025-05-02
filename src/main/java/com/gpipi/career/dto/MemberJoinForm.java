package com.gpipi.career.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberJoinForm {
	
	@NotBlank(message = "名前を入力してください")
	private String memberName;
	
	@NotBlank(message = "E-mailを入力してください")
	@Email(message = "有効なE-mailを入力してください")
	private String memberEmail;
	
	@NotBlank(message = "")
	@Size(min = 8, max = 24, message = "パスワードは8文字以上24文字以内で設定してください")
	private String memberPassword;
	
	@NotBlank(message = "確認用パスワードを入力してください")
	private String confirmMemberPassword;
	
}
