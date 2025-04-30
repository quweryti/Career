/* 
 * MainPageController
 * 	send main page name
 * 
 * version
 * 	1.0.0
 * date
 * 	2025/04/23
 * 
 * create
 *  Kwon Yujin
 */
package com.gpipi.career.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/career")
public class MainPageController {

	// -> index.html
	@GetMapping("/main")
	public String mainView() {
		return "index";
	}
	
	// -> /career/main
	@GetMapping(value = {"/", ""})
	public String mainRedirect() {
		return "redirect:/career/main";
	}
	
}
