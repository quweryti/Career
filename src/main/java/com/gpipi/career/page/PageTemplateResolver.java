/* 
 * PageTemplateResolver
 * 	return a view root
 * 
 * version
 * 	1.0.0
 * date
 * 	2025/05/01
 * 
 * create
 *  Kwon Yujin
 */

package com.gpipi.career.page;

public interface PageTemplateResolver {
	/*
	 * @param pageKey ex) "MAIN", "MEMBER_JOIN"
	 * @return real thymeleaf templates root(ex: "main/main")
	 * @throws IllegalArgumentException -> ACCEPT DENIED
	 */
	String resolve(String pageKey);
}
