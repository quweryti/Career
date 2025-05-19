/**
 * AuthMapper.java
 * @since       2025-05-14
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         @link com.gpipi.career.dao.mapper.AuthMapper
 */
package com.gpipi.career.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.gpipi.career.domain.entity.Member;

@Mapper
public interface AuthMapper {
	void insertMember(Member member);
}
