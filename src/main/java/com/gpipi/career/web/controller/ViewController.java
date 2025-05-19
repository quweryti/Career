/**
 * ViewController.java
 * @since       2025-04-23
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.page.PageTemplateResolver
 * @see         org.springframework.web.server.ResponseStatusException
 */
package com.gpipi.career.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.gpipi.career.config.PageTemplate;
import com.gpipi.career.page.TemplateResolver;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/views")
public class ViewController {

	private final TemplateResolver resolver;
	
	public ViewController(TemplateResolver resolver) {
		this.resolver = resolver;
	}
	
	// -> view main
	@GetMapping(value = {"/", ""})
	public String mainRedirect() {
		return resolver.redirectView("main");
	}
	
	// -> view {pageKey}
	@GetMapping("/{pageKey}")
	public String viewPage(@PathVariable String pageKey,
						   @RequestParam(value = "error", required = false) String error,
										 Model model,
										 HttpSession session) {
		PageTemplate page = PageTemplate.ofKey(pageKey)
				.orElseThrow(() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND, "Page not found : "  + pageKey
				));
		if(page == PageTemplate.LOGIN && error != null) {
			model.addAttribute("errorMessage", "E-mail又はパスワードが違います");
		}
		String viewPath = resolver.pageResolve(pageKey);
		model.addAttribute("content", viewPath);
		
		return "index";
	}
	
}
