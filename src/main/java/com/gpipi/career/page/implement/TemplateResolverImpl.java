/**
 * PageTemplateResolverImpl.java
 * @since       2025-05-01
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.page.PageTemplateResolver
 */
package com.gpipi.career.page.implement;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.gpipi.career.config.LogicTemplate;
import com.gpipi.career.config.PageTemplate;
import com.gpipi.career.page.TemplateResolver;

@Component
public class TemplateResolverImpl implements TemplateResolver {
	
	@Override
	public String pageResolve(String pageKey) {
		return PageTemplate
				.ofKey(pageKey)
				.map(PageTemplate::getViewPath)
				.orElseThrow(
						() -> new ResponseStatusException(
								HttpStatus.NOT_FOUND,
								"Unsupported page key : " + pageKey
				));
	}

	@Override
	public String logicResolve(String logicKey) {
		return LogicTemplate
				.ofKey(logicKey)
				.map(LogicTemplate::getLogicUrl)
				.orElseThrow(
						() -> new ResponseStatusException(
								HttpStatus.NOT_FOUND,
								"Unsupported page key : " + logicKey
				));
	}

}
