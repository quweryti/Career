/**
 * AuthDao
 * 	
 * 
 * @since	2025/05/14
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.dao;

import org.apache.ibatis.annotations.Mapper;

import com.gpipi.career.domain.entity.Member;

@Mapper
public interface AuthDao {

	void insertMember(Member member);

}
