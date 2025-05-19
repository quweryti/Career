/**
 * SecurityConfig.java
 * @since   2025-05-13
 * @version 1.0.0
 * @author  Kwon Yujin
 * @see     org.springframework.security.config.annotation.web.builders.HttpSecurity
 * @see     org.springframework.security.web.SecurityFilterChain
 */
// com.gpipi.career.config.HashConfig.java
package com.gpipi.career.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private static final String USERNAME_PARAM = "memberEmail";
	private static final String PASSWORD_PARAM = "memberPassword";
	/**
     * PasswordEncoder 빈을 정의합니다.
     * 여기선 BCryptPasswordEncoder를 사용하여 비밀번호를 안전하게 해싱(hash)하도록 설정합니다.
     * 해싱된 비밀번호는 데이터베이스에 평문 저장을 방지하고, 동일한 입력에 대해 항상 같은 해시를 생성하지 않음으로써 보안을 강화합니다.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     * AuthenticationManager 빈을 등록합니다.
     * 서비스 레이어에서 인증Manager를 직접 주입받아 인증(authentication) 로직을 실행할 수 있습니다.
     */    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    	return authConfig.getAuthenticationManager();
    }
    /**
     * SecurityFilterChain 빈을 정의하여 HTTP 보안 필터 체인을 구성합니다.
     * - CSRF 보호 활성화 및 쿠키 기반 토큰 저장소 사용
     * - URL별 접근 제어(permitAll, authenticated)
     * - 사용자 인증(UserDetailsService) 연결
     * - 커스텀 로그인 페이지, 인증 처리 URL, 성공/실패 시 이동 경로 설정
     * - 로그아웃 URL 및 로그아웃 성공 시 이동 경로 설정
     */    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
        // CSRF 보호 활성화 (기본 설정) 및 쿠키 기반 토큰 저장소 지정
    	.csrf(csrf -> csrf
    			.csrfTokenRepository(
    					org.springframework.security.web.csrf.CookieCsrfTokenRepository.withHttpOnlyFalse()
				)
		)
        // 경로별 권한 설정
    	.authorizeHttpRequests(auth -> auth
    			.requestMatchers(
    					PageTemplate.MAIN.getViewUrl(),
    					PageTemplate.LOGIN.getViewUrl(),
    					PageTemplate.JOIN.getViewUrl(),
    					PageTemplate.JOINSUCCESS.getViewUrl(),
    					LogicTemplate.JOIN.getLogicUrl(),
    					LogicTemplate.LOGIN.getLogicUrl(),
    					LogicTemplate.LOGOUT.getLogicUrl(),
    					"/css/**",
    					"/js/**"
				)
    			.permitAll() // 인증 없이 접근 허용
    	    	.anyRequest()
    	    	.authenticated() // 그 외 모든 요청은 인증 필요
		)
        // 사용자 인증 서비스 설정
    	.userDetailsService(userDetailsService)
        // 폼 로그인 설정
    	.formLogin(form -> form
    			.loginPage(PageTemplate.LOGIN.getViewUrl()) // GET 로그인 폼 URL
    			.loginProcessingUrl(LogicTemplate.LOGIN.getLogicUrl()) // POST 인증 처리 URL
    			.usernameParameter(USERNAME_PARAM)
    			.passwordParameter(PASSWORD_PARAM)
    			.defaultSuccessUrl(PageTemplate.MAIN.getViewUrl(), true) // 로그인 성공 후 기본 이동 URL
    			.failureUrl(PageTemplate.LOGIN.getViewUrl() + "?error") // 로그인 실패 시 이동 URL
    			.permitAll()
    			)
        // 로그아웃 설정
    	.logout(logout -> logout
    			.logoutUrl(LogicTemplate.LOGOUT.getLogicUrl())
    			.logoutSuccessUrl(PageTemplate.LOGIN.getViewUrl() + "?logout")
    			.permitAll()
    			);
    	
    	return http.build();
    }

}
