/**
 * FollowService
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.1
 * @author	Nakamura
 */
package com.gpipi.career.service;

import com.gpipi.career.dao.FollowDao;
import org.springframework.stereotype.Service;
import com.gpipi.career.domain.vo.FollowInfoVo;
import java.util.Arrays;
import java.util.List;

// ダミーデータ(dummyData)
@Service
public class FollowService {
	public List<FollowDao> getFollowList() {

		return Arrays.asList(
			new FollowDao(1L, "たろう", "/img/taro.png"),
			new FollowDao(2L, "じろう", "/img/jiro.png"),
			new FollowDao(3L, "さぶろう", "/img/saburo.png")
		);
	}
}
