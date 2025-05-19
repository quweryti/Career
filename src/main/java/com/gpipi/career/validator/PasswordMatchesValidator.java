/**
 * PasswordMatchesValidator.java
 * @since       2025-05-08
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.validator.PasswordMatches
 */
package com.gpipi.career.validator;

import com.gpipi.career.web.form.MemberJoinForm;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/**
 * 1) ConstraintValidator<A,T>
 *    - A: 커스텀 애노테이션 클래스
 *    - T: 검증할 타입(MemberJoinForm)
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, MemberJoinForm> {
	
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(MemberJoinForm form, ConstraintValidatorContext context) {
		// 2. null 체크 + 두 필드 일치 여부 반환
		if(form.getMemberPassword() == null || form.getConfirmMemberPassword() == null) {
			return false;
		}
		return form.getMemberPassword().equals(form.getConfirmMemberPassword());
	}
	
}
