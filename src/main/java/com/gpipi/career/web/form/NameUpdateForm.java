/**
 * NameUpdateForm.java
 * @since       2025-05-26
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.service.dto.MemberJoinRequestDto
 * @see         com/gpipi.career.validator.PasswordMatches
 */
package com.gpipi.career.web.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NameUpdateForm {
	
	@NotBlank(message = "名前を入力してください")
	@Size(min = 2, max = 16, message = "ユーザー名は2〜16文字で入力してください")
	@Pattern(regexp = "^[\\p{L}\\d]{2,16}$", message = "ユーザー名は英数字・日本語文字・漢字を含む2〜16文字で入力してください")
	private String name;
	
}
