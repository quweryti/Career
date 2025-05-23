/**
 * CustomUserDetailsService.java
 * @since       2025-05-23
 * @version     1.0.0
 * @author      Kwon Yujin
 */
package com.gpipi.career.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gpipi.career.dao.repository.MemberRepository;
import com.gpipi.career.domain.entity.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("会員情報が見つかりません" + email));
		
		List<SimpleGrantedAuthority> auth = List.of(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new CustomUserDetails(member, auth);
	}

}
