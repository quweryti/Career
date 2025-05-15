/**
 * MemberDetailsService 
 * 	
 * 
 * @since	2025/05/15
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gpipi.career.dao.repository.MemberRepository;
import com.gpipi.career.domain.entity.Member;

public class MemberDetailsService implements UserDetailsService {
	
	private final MemberRepository memberRepository;
	
	public MemberDetailsService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public MemberPrincipal loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません: " + email));
		
		return new MemberPrincipal(member);
	}
	
}
