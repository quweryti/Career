/**
 * FollowRepository.java
 * @since       2025-05-22
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         org.springframework
 */
package com.gpipi.career.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gpipi.career.domain.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {

	@Query("""
			select f.followee.memberId
			from Follow f
			where f.member.memberId = :memberId
			""")
	List<Long> findFolloweeIdByMember_MemberId(@Param("memberId") Long member_id);

	Optional<Follow> findById(Long followId);
	
	@Query("""
			select case when count(f) > 0 then true else false end
			from Follow f
			where f.member.memberId = :memberId
			and f.followee.memberId = :followeeId
			""")
	boolean existsByMemberIdAndFolloweeId(@Param("memberId") Long memberId,
										  @Param("followeeId") Long followeeId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("""
			delete from Follow f
			where f.member.memberId = :memberId
			and f.followee.memberId = :followeeId
			""")
	void deleteByMember_MemberIdAndFollowee_FolloweeId(@Param("memberId") Long memberId,
													   @Param("followeeId") Long followeeId);
	
}
