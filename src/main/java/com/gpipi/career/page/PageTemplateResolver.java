/**
 * PageTemplateResolver
 * 	入力されたアドレスに対応するHTMLページの実際のパスを取得して返します。
 * @see		PageTemplateResolverImpl.java
 * @since	2025/05/01
 * @version	1.0.0
 * @author	Kwon Yujin
 */

package com.gpipi.career.page;

public interface PageTemplateResolver {
	/*
	 * @param pageKey ex) "MAIN", "JOIN"
	 * @return real thymeleaf templates root(ex: "main/main")
	 * @throws IllegalArgumentException -> ACCEPT DENIED
	 */
	String resolve(String pageKey);
	
	default String forwardView(String pageKey) {
		return "forward:/views/" + pageKey;
	}
	
	default String redirectView(String pageKey) {
		return "redirect:/views/" + pageKey;
	}

}
