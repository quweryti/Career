/**
 * MemberPrincipal
 * 	
 * 
 * @since	2025/05/15
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gpipi.career.domain.entity.Member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberPrincipal implements UserDetails {
	
	private final Member member;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { return List.of(() -> "member"); }
	@Override
	public String getPassword() 								   { return member.getPassword(); }
	@Override
	public String getUsername() 								   { return member.getName(); }
	@Override
	public boolean isAccountNonExpired() 						   { return true; }
	@Override
	public boolean isAccountNonLocked() 						   { return !"1".equals(member.getIsDeleted()); }
	@Override
	public boolean isCredentialsNonExpired() 					   { return true; }
	@Override
	public boolean isEnabled() 									   { return !"1".equals(member.getIsDeleted()); }
	
}
