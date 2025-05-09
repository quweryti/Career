package com.gpipi.career.controller;

import com.gpipi.career.service.FollowService;
import com.gpipi.career.domain.vo.FollowInfoVO;
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
        List<FollowInfoVO> followList = followService.getFollowList();
        model.addAttribute("followList", followList);
        return "side";
    }
}
