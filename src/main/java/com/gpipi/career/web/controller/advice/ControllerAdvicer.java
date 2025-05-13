/**
 * ViewControllerAdvice
 * 	
 * 
 * @since	2025/05/09
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.web.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gpipi.career.web.dto.MemberJoinForm;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice("com.gpipi.career.web.controller")
public class ControllerAdvicer {
	
	// 여긴 아마 삭제 할 듯?
	@ModelAttribute("memberForm")
	public MemberJoinForm memberForm(HttpServletRequest request) {
		String uri = request.getRequestURI();
		if(uri.endsWith("/views/join")) {
			return new MemberJoinForm();
		}
		return null;
	}
	
}
