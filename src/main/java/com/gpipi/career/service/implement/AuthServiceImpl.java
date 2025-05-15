/**
 * AuthServiceImpl
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.service.implement;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpipi.career.dao.mapper.AuthMapper;
import com.gpipi.career.dao.repository.MemberRepository;
import com.gpipi.career.domain.entity.Member;
import com.gpipi.career.exception.DuplicateMemberException;
import com.gpipi.career.exception.LoginFailedException;
import com.gpipi.career.service.AuthService;
import com.gpipi.career.service.dto.LoginRequestDto;
import com.gpipi.career.service.dto.MemberJoinRequestDto;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	private final MemberRepository memberRepository;
	private final AuthMapper authDao;
	private final PasswordEncoder passwordEncoder;
	
	public AuthServiceImpl(MemberRepository memberRepository,
						   AuthMapper authDao,
						   PasswordEncoder passwordEncoder) {
		this.memberRepository = memberRepository;
		this.authDao = authDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Member login(LoginRequestDto requestDto) {
		String email = requestDto.getMemberEmail();
		String password = requestDto.getMemberPassword();
		
		// email로 행 조회 후 Optional 객체에 담기
		Optional<Member> optionalMember = memberRepository.findByEmail(email);
		// Optional 객체에 정보 여부에 따라 exception
		if(optionalMember.isEmpty()) {
			throw new LoginFailedException("メールアドレスまたはパスワードが正しくありません");
		}
		// Optional 객체 정보를 Member 객체로 이관
		Member member = optionalMember.get();
		// Member 객체에 담긴 탈퇴 여부 검사
		if(member.getIsDeleted().equals("1")) {
			throw new LoginFailedException("既に脱退した会員です");
		}
		// Member 객체에 담긴 비밀번호와 입력된 비밀번호 대조
		if(!passwordEncoder.matches(password, member.getPassword())) {
			throw new LoginFailedException("メールアドレスまたはパスワードが正しくありません");
		}
		
		return member;
	}
	
	@Override
	public void register(MemberJoinRequestDto requestDto) {
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
