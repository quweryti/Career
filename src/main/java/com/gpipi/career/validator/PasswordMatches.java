/**
 * PasswordMatches.java
 * @since       2025-05-08
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.validator.PasswordMatchesValidator
 */
package com.gpipi.career.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {
	
	String message() default "パスワードが一致しません";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
}
