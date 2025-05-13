/**
 * PageTemplateResolverImpl
 * 	説明なし
 * @see		PageTemplateResolver.java
 * @since	2025/05/01
 * @version	1.0.0
 * @author	Kwon Yujin
 */

package com.gpipi.career.page.implement;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.gpipi.career.config.PageTemplate;
import com.gpipi.career.page.PageTemplateResolver;

@Component
public class PageTemplateResolverImpl implements PageTemplateResolver {
	
	@Override
	public String resolve(String pageKey) {
		return PageTemplate
				.ofKey(pageKey)
				.map(PageTemplate::getViewPath)
				.orElseThrow(
						() -> new ResponseStatusException(
								HttpStatus.NOT_FOUND,
								"Unsupported page key : " + pageKey
								)
						);
	}
}
