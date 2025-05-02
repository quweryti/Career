package com.gpipi.career.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gpipi.career.dto.MemberJoinForm;
import com.gpipi.career.page.PageTemplateResolver;
import com.gpipi.career.service.AuthService;

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
	public String processJoin(@ModelAttribute("memberForm") MemberJoinForm form,
															BindingResult br,
															Model model,
															RedirectAttributes ra) {
		
		return null;
	}
	
}
