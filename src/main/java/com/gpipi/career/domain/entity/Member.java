/**
 * Member.java
 * @since       2025-05-13
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         jakarta.persistence.Entity
 * @see         com.gpipi.career.dao.repository.MemberRepository
 */
package com.gpipi.career.domain.entity;

import java.time.LocalDateTime;

import com.gpipi.career.web.dto.MemberSessionDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long member_id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "email", nullable = false, length = 200)
	private String email;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "signup_date", nullable = false, updatable = false)
	private LocalDateTime signupDate;
	
	@Column(name = "is_deleted", nullable = false, length = 1)
	private String isDeleted;
	
	public MemberSessionDto toSessionDto() {
		return new MemberSessionDto(this.name, this.email);
	}
	
}
