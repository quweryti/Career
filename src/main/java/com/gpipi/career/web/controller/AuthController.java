/**
 * AuthController
 * 	アカウント認証に関連するアクションを受け付けるコントローラーです。
 * 
 * @since	2025/05/08
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gpipi.career.page.PageTemplateResolver;
import com.gpipi.career.service.AuthService;
import com.gpipi.career.web.dto.MemberJoinForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private final PageTemplateResolver resolver;
	private final AuthService authService;

	public AuthController(PageTemplateResolver resolver, AuthService authService) {
		this.resolver = resolver;
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public String processLogin() {
		return null;
	}
	
	@PostMapping("/logout")
	public String processLogout() {
		return null;
	}
	
	@PostMapping("/join")
	public String processJoin(@Valid
							  @ModelAttribute("memberForm") MemberJoinForm form,
															BindingResult br,
															Model model,
															RedirectAttributes ra) {
		// 데이터 입력값 유효성 검사
		if(br.hasErrors()) {
			String viewPath = resolver.resolve("join");
			model.addAttribute("content", viewPath);
			return "index";
		}
		// 회원 등록
		authService.registerMember(form.toRequestDto());
		// 등록 성공 메시지
		ra.addFlashAttribute("joinSuccess", "会員登録完了");
		return resolver.redirectView("main");
	}

}
