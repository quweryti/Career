/**
 * CustomUserDetails.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 */
package com.gpipi.career.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gpipi.career.domain.entity.Member;

public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private final Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}
	
	public Long getId() {
		return member.getMember_id();
	}
	
	public Member getMember() {
		return member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getEmail();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return !member.isDeleted();
	}

}
