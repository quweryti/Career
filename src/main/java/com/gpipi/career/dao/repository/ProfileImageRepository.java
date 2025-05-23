/**
 * ProfileImageRepository.java
 * @since       2025-05-23
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         jakarta.persistence.Entity
 * @see         com.gpipi.career.dao.repository.
 */
package com.gpipi.career.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gpipi.career.domain.entity.ProfileImage;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {

	Optional<ProfileImage> findByMember_MemberId(Long memberId);

}
