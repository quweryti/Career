/**
 * FollowController
 * 	
 * 
 * @since	2025/05/13
 * @version	1.0.1
 * @author	Nakamura
 */
package com.gpipi.career.web.controller;

import java.util.ArrayList;
import com.gpipi.career.service.FollowService;
import com.gpipi.career.dao.FollowDao;
import com.gpipi.career.domain.vo.FollowInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("/side")
    public String getSidebar(Model model) {
        List<FollowDao> daoList = followService.getFollowList();
        List<FollowInfoVo> followList = new ArrayList<>();

        for (FollowDao dao : daoList) {
            FollowInfoVo vo = new FollowInfoVo();
            vo.setId(dao.getId());
            vo.setUsername(dao.getUsername());
            vo.setProfileImgUrl("https://via.placeholder.com/40");  // 本来はdao.getProfileImgUrl()と書く
            followList.add(vo);
        }
        model.addAttribute("followList", followList);
        return "side";
    }
    
}
