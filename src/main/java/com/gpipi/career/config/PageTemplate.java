/**
 * PageTemplate.java
 * @since   2025-05-01
 * @version 1.0.0
 * @author  Kwon Yujin
 * @see     @link com.gpipi.career.page.PageTemplateResolver
 */
package com.gpipi.career.config;

import java.util.Optional;

public enum PageTemplate {
	MAIN("main/main", "/views/main"),
	JOIN("main/memberjoin", "/views/join"),
	JOINSUCCESS("main/joinsuccess", "/views/joinsuccess"),
	LOGIN("main/login", "/views/login");
	
	private final String viewPath;
	private final String viewUrl;
	
	PageTemplate(String viewPath, String viewUrl) {
		this.viewPath = viewPath;
		this.viewUrl = viewUrl;
	}
	
	public String getViewPath() {
		return viewPath;
	}
	
	public String getViewUrl() {
		return viewUrl;
	}

	public static Optional<PageTemplate> ofKey(String pageKey) {
		if(pageKey == null) {
			return Optional.empty();
		}
		try {
			return Optional.of(PageTemplate.valueOf(pageKey.toUpperCase()));
		} catch(IllegalArgumentException ex) {
			return Optional.empty();
		}
	}

}
