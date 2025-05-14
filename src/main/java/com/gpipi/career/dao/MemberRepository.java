/**
 * MemberRepository
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpipi.career.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	boolean existsByEmail(String email);

}
