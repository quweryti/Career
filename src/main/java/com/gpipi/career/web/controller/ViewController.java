/**
 * ViewController
 * 	表示するメインページをビューに返します。
 * 
 * @since	2025/04/23
 * @version	1.0.0
 * @author	Kwon Yujin
 */
package com.gpipi.career.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.gpipi.career.page.PageTemplateResolver;
import com.gpipi.career.web.dto.MemberJoinForm;

@Controller
@RequestMapping("/views")
public class ViewController {

	private final PageTemplateResolver resolver;
	
	public ViewController(PageTemplateResolver resolver) {
		this.resolver = resolver;
	}
	
	// -> view main
	@GetMapping(value = {"/", ""})
	public String mainRedirect() {
		return "redirect:/views/main";
	}
	
	// -> view {pageKey}
	@GetMapping("/{pageKey}")
	public String viewPage(@PathVariable String pageKey,
										 Model model) {
		try {
			String viewPath = resolver.resolve(pageKey);
			model.addAttribute("content", viewPath);
			// controller advicer에 객체 생성 부분 넣기
			return "index";
		} catch (IllegalArgumentException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Page not found : " + pageKey);
		}
	}
	
}
