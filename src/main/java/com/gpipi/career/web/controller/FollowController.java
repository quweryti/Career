/**
 * FollowController
 * 	
 * 
 * @since	2025/05/08
 * @version	1.0.0
 * @author	Nakamura
 */
package com.gpipi.career.web.controller;

import com.gpipi.career.service.FollowService;
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
        List<FollowInfoVo> followList = followService.getFollowList();
        model.addAttribute("followList", followList);
        return "side";
    }
}
