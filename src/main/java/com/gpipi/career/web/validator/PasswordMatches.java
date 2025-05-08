/**
 * PasswordMatches
 * 	入力されたパスワードと確認用パスワードが一致しているかを検証します。
 * @see		AuthController.java
 * @since	2025/05/08
 * @version	1.0.0
 * @author	Kwon Yujin
 */

package com.gpipi.career.web.validator;
// 1. 표준 메타 애노테이션 imports
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
// 2. Bean Validation 애노테이션 imports
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
/**
 * 3. @Target       : 이 애노테이션을 클래스(Type) 레벨에만 허용
 * 4. @Retention    : 런타임까지 애노테이션 정보 유지
 * 5. @Documented   : Javadoc에 이 애노테이션 문서화를 포함
 * 6. @Constraint   : 이 애노테이션은 PasswordMatchesValidator 로 검증
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {
	// 7. 검증 실패 시 기본 메시지
	String message() default "パスワードが一致しません";
	// 8. Validation 그룹 기능
	Class<?>[] groups() default {};
	// 9. 부가 정보(payload) 기능
	Class<? extends Payload>[] payload() default {};
	
}
