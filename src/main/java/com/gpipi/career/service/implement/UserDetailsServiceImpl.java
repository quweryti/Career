/**
 * UserDetailsServiceImpl.java
 * @since       2025-05-13
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see			 
 */
package com.gpipi.career.service.implement;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gpipi.career.dao.repository.MemberRepository;
import com.gpipi.career.domain.entity.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("user definded : " + email));
		if(member.isDeleted()) {
			throw new UsernameNotFoundException("user deleted : " + email);
		}
		List<GrantedAuthority> authorities = List.of(
				new SimpleGrantedAuthority("USER")
				);
		return User.builder()
				.username(member.getEmail())
				.password(member.getPassword())
				.authorities(authorities)
				.disabled(member.isDeleted())
				.build();
	}

}
