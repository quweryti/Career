/**
 * MemberJoinForm
 * 	memberFormオブジェクトを受け取るDTOです。
 * @see		MemberJoinRequestDto.java
 * @since	2025/04/23
 * @version	1.0.0
 * @author	Kwon Yujin
 */

package com.gpipi.career.web.dto;

import com.gpipi.career.service.dto.MemberJoinRequestDto;
import com.gpipi.career.web.validator.PasswordMatches;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@PasswordMatches
public class MemberJoinForm {
	
	@NotBlank(message = "名前を入力してください")
	@Size(min = 2, max = 16, message = "ユーザー名は2〜16文字で入力してください")
	@Pattern(regexp = "^[\\p{L}\\d]{2,16}$", message = "ユーザー名は英数字・日本語文字・漢字を含む2〜16文字で入力してください")
	private String memberName;
	
	@NotBlank(message = "E-mailを入力してください")
	@Email(message = "有効なE-mailを入力してください")
	private String memberEmail;
	
	@NotBlank(message = "パスワードを入力してください")
	@Size(min = 8, max = 24, message = "パスワードは8文字以上24文字以内で設定してください")
	@Pattern(regexp = "^[A-Za-z0-9!@#$%^&*]{8,24}$", message = "パスワードに許可されない文字が含まれています")
	private String memberPassword;
	
	@NotBlank(message = "確認用パスワードを入力してください")
	private String confirmMemberPassword;
	
	public MemberJoinRequestDto toRequestDto() {
		return new MemberJoinRequestDto(
				this.memberName,
				this.memberEmail,
				this.memberPassword
		);
	}
	
}
