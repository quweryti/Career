/**
 * ControllerAdvisor.java
 * @since       2025-05-09
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         org.springframework.web.bind.annotation.ControllerAdvice
 * @see         com.gpipi.career.web.dto.LoginForm
 * @see         com.gpipi.career.web.dto.MemberJoinForm
 */
package com.gpipi.career.web.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gpipi.career.web.form.LoginForm;
import com.gpipi.career.web.form.MemberJoinForm;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice("com.gpipi.career.web.controller")
public class ControllerAdvisor {
	
	@ModelAttribute("memberForm")
	public MemberJoinForm memberForm(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if(uri.endsWith("/views/join") || uri.endsWith("/auth/join")) {
			return new MemberJoinForm();
		}
		return null;
	}
	
	@ModelAttribute("loginForm")
	public LoginForm loginForm(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if(uri.endsWith("/views/login") || uri.endsWith("/auth/login")) {
			return new LoginForm();
		}
		return null;
	}

}
