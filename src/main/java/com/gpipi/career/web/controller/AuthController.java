/**
 * AuthController.java
 * @since       2025-05-08
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.web.controller.ViewController
 * @see         com.gpipi.career.service.AuthService
 */
package com.gpipi.career.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gpipi.career.exception.DuplicateMemberException;
import com.gpipi.career.page.TemplateResolver;
import com.gpipi.career.service.AuthService;
import com.gpipi.career.web.form.MemberJoinForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private final TemplateResolver resolver;
	private final AuthService authService;

	public AuthController(TemplateResolver resolver, AuthService authService) {
		this.resolver = resolver;
		this.authService = authService;
	}
	
	@PostMapping("/join")
	public String processJoin(@Valid
							  @ModelAttribute("memberForm") MemberJoinForm form,
															BindingResult br,
															Model model,
															RedirectAttributes ra) {
		String viewPath = resolver.pageResolve("join");
		// 데이터 입력값 유효성 검사
		if(br.hasErrors()) {
			model.addAttribute("content", viewPath);
			return "index";
		}
		// 회원 등록
		try {
			authService.register(form.toRequestDto());
		} catch(DuplicateMemberException ex) {
			br.rejectValue("memberEmail", "duplicate", ex.getMessage());
			model.addAttribute("content", viewPath);
			return "index";
		}
		// 등록 성공 메시지
		ra.addFlashAttribute("success", "会員登録完了");
		return resolver.redirectView("success");
	}

}
