/**
 * AuthServiceImpl
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.service.implement;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpipi.career.dao.AuthDao;
import com.gpipi.career.dao.MemberRepository;
import com.gpipi.career.domain.entity.Member;
import com.gpipi.career.service.AuthService;
import com.gpipi.career.service.dto.MemberJoinRequestDto;
import com.gpipi.career.service.exception.DuplicateMemberException;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	private final MemberRepository memberRepository;
	private final AuthDao authDao;
	private final PasswordEncoder passwordEncoder;
	
	public AuthServiceImpl(MemberRepository memberRepository,
						   AuthDao authDao,
						   PasswordEncoder passwordEncoder) {
		this.memberRepository = memberRepository;
		this.authDao = authDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void registerMember(MemberJoinRequestDto requestDto) {
		String name = requestDto.getMemberName();
		String email = requestDto.getMemberEmail();
		String password = requestDto.getMemberPassword();
		String encodedPassword = passwordEncoder.encode(password);
		
		// 중복 검사(JPA)
		if(memberRepository.existsByEmail(email)) {
			throw new DuplicateMemberException(email);
		}
		
		// Service.Dto -> Entity 변환
		Member member = Member.builder()
							  .name(name)
							  .email(email)
							  .password(encodedPassword)
							  .build();
		
		// DB에 저장
		authDao.insertMember(member);
	}

}
