/**
 * AuthController
 * 	アカウント認証に関連するアクションを受け付けるコントローラーです。
 * 
 * @since	2025/05/08
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.web.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gpipi.career.domain.entity.Member;
import com.gpipi.career.exception.DuplicateMemberException;
import com.gpipi.career.exception.LoginFailedException;
import com.gpipi.career.page.PageTemplateResolver;
import com.gpipi.career.security.MemberPrincipal;
import com.gpipi.career.service.AuthService;
import com.gpipi.career.web.dto.LoginForm;
import com.gpipi.career.web.dto.MemberJoinForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
@SessionAttributes("member")
public class AuthController {
	
	private final PageTemplateResolver resolver;
	private final AuthService authService;

	public AuthController(PageTemplateResolver resolver, AuthService authService) {
		this.resolver = resolver;
		this.authService = authService;
	}
	
	@PostMapping("/logout")
	public String processLogout() {
		return null;
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid
							   @ModelAttribute("loginForm") LoginForm form,
															BindingResult br,
															Model model,
															RedirectAttributes ra) {
		String viewPath = resolver.resolve("login");
		
		if(br.hasErrors()) {
			model.addAttribute("content", viewPath);
			return "index";
		}
		
		try {
			Member member = authService.login(form.toRequestDto());
			// principal wrapping
			// MemberPrincipal principal = new MemberPrincipal(member);
			// create token
			// UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
			// restore security context
			// SecurityContextHolder.getContext().setAuthentication(auth);
			model.addAttribute("member", member);
		} catch(LoginFailedException ex) {
			br.reject("err", "メールアドレスまたはパスワードが正しくありません");
			model.addAttribute("content", viewPath);
			return "index";
		}
		return resolver.redirectView("main");
	}
	
	@PostMapping("/join")
	public String processJoin(@Valid
							  @ModelAttribute("memberForm") MemberJoinForm form,
															BindingResult br,
															Model model,
															RedirectAttributes ra) {
		String viewPath = resolver.resolve("join");
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
		ra.addFlashAttribute("joinSuccess", "会員登録完了");
		return resolver.redirectView("joinsuccess");
	}

}
