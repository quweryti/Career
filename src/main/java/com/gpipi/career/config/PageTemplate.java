/**
 * PageTemplate
 * 	受け取ったアドレスを実際のHTMLページのパスにマッピングします。
 * 
 * @since	2025/05/01
 * @version	1.0.0
 * @author	Kwon Yujin
 */

package com.gpipi.career.config;

import java.util.Optional;

public enum PageTemplate {
	MAIN("main/main"),
	JOIN("main/memberjoin");
	
	private final String viewPath;
	
	PageTemplate(String viewPath) {
		this.viewPath = viewPath;
	}
	
	public String getViewPath() {
		return viewPath;
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
