/**
 * SecurityConfig
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gpipi.career.dao.repository.MemberRepository;
import com.gpipi.career.security.MemberDetailsService;

@Configuration
public class SecurityConfig {

	/*
	 * @Bean public UserDetailsService userDetailsService(MemberRepository
	 * memberRepository) {
	 * 
	 * return new MemberDetailsService(memberRepository); }
	 */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean public DaoAuthenticationProvider authProvider(UserDetailsService uds,
	 * BCryptPasswordEncoder encoder) {
	 * 
	 * DaoAuthenticationProvider p = new DaoAuthenticationProvider();
	 * p.setUserDetailsService(uds); p.setPasswordEncoder(encoder);
	 * 
	 * return p; }
	 */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http
                                 // DaoAuthenticationProvider authProvider
                                 ) throws Exception {
		http
        // .authenticationProvider(authProvider)
        // URL별 접근 제어 설정
        .authorizeHttpRequests(auth -> auth
        	// 인증 없이 접근을 허용할 URL 리스트
            .requestMatchers("/views/**", "/auth/**", "/css/**", "/js/**", "/images/**", "/api/object/**").permitAll()
            // 이외 모든 요청은 인증된 사용자로 제한
            .anyRequest()
            // .authenticated()
            .permitAll()
        )
		/*
		 * .formLogin(form -> form .loginPage("/views/login")
		 * .loginProcessingUrl("/auth/login") .defaultSuccessUrl("/views/main", true)
		 * .failureUrl("/views/login?error") .permitAll() ) .logout(logout -> logout
		 * .logoutUrl("/auth/logout") .logoutSuccessUrl("/views/main?logout")
		 * .invalidateHttpSession(true) .permitAll() )
		 */
        ;
		
    return http.build();
	}

}
