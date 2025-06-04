/**
 * LinkRepository.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         org.springframework
 */
package com.gpipi.career.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gpipi.career.domain.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

	@Query("""
			select l.url
			from Link l
			where l.member.memberId = :memberId
			""")
	List<String> findUrlByMember_MemberId(@Param("memberId") Long member_id);

	@Query("""
			select l
			from Link l
			where l.linkId = :linkId
			and l.member.memberId = :memberId
			""")
	Optional<Link> findByLinkIdAndMember_MemberId(@Param("linkId") Long linkId,
												  @Param("memberId") Long memberId);
	
	
}
