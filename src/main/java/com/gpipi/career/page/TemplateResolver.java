/**
 * PageTemplateResolver.java
 * @since       2025-05-01
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.page.PageTemplateResolverImpl
 */
package com.gpipi.career.page;

public interface TemplateResolver {
	
	/**
	 * @param pageKey ex) "MAIN", "JOIN"
	 * @return real thymeleaf templates root(ex: "main/main")
	 * @throws IllegalArgumentException -> ACCEPT DENIED
	 */
	String pageResolve(String pageKey);
	
	String logicResolve(String logicKey);
	
	default String forwardView(String pageKey) {
		return "forward:" + pageResolve(pageKey);
	}
	
	default String redirectView(String pageKey) {
		return "redirect:" + pageResolve(pageKey);
	}
	
	default String forwardLogic(String logicKey) {
		return "forward:" + logicResolve(logicKey);
	}
	
	default String redirectLogic(String logicKey) {
		return "redirect:" + logicResolve(logicKey);
	}

}
