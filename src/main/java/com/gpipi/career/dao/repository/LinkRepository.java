/**
 * LinkRepository.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         org.springframework
 */
package com.gpipi.career.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpipi.career.domain.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

	List<String> findUrlByMemberEmail(Long member_id);

}
