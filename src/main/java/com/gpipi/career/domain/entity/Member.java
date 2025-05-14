/**
 * Member
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.domain.entity;

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
	private Long id;
	@Column(name="name", nullable = false, length = 100)
	private String name;
	@Column(name="email", nullable = false, length = 200)
	private String email;
	@Column(name="password", nullable = false, length = 255)
	private String password;
	
}
