/**
 * MemberRepository.java
 * @since       2025-05-13
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         org.springframework.data.jpa.repository.JpaRepository
 * @see         com.gpipi.career.domain.entity.Member
 */
package com.gpipi.career.dao.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gpipi.career.domain.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	boolean existsByEmail(String email);

	Optional<Member> findByEmail(String email);

}
