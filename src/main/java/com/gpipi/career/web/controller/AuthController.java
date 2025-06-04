/**
 * AuthController.java
 * @since       2025-05-08
 * @version     1.0.0
 * @author      Kwon Yujin
 * @see         com.gpipi.career.web.controller.ViewController
 * @see         com.gpipi.career.service.AuthService
 */
package com.gpipi.career.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gpipi.career.exception.DuplicateMemberException;
import com.gpipi.career.page.TemplateResolver;
import com.gpipi.career.security.CustomUserDetails;
import com.gpipi.career.service.AuthService;
import com.gpipi.career.service.FollowService;
import com.gpipi.career.service.MemberService;
import com.gpipi.career.web.form.DeleteFollowForm;
import com.gpipi.career.web.form.MemberJoinForm;
import com.gpipi.career.web.form.NameUpdateForm;
import com.gpipi.career.web.form.PasswordUpdateForm;
import com.gpipi.career.web.form.UpdateIsDeleteForm;
import com.gpipi.career.web.form.UpdateLinkForm;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	private final TemplateResolver resolver;
	private final AuthService authService;
	private final MemberService memberService;
	private final FollowService followService;

	public AuthController(TemplateResolver resolver,
						  AuthService authService,
						  MemberService memberService,
						  FollowService followService) {
		this.resolver = resolver;
		this.authService = authService;
		this.memberService = memberService;
		this.followService = followService;
	}
	
	@PostMapping("/join")
	public String processJoin(@Valid
							  @ModelAttribute("memberForm") MemberJoinForm form,
															BindingResult br,
															Model model,
															RedirectAttributes ra) {
		String viewPath = resolver.pageResolve("join");
		// 데이터 입력값 유효성 검사
		if(br.hasErrors()) {
			model.addAttribute("content", viewPath);
			return "index";
		}
		// 회원 등록
		try {
			authService.register(form.toRequestDto());
		} catch(DuplicateMemberException ex) {
			br.rejectValue("memberEmail", "duplicate", ex.getMessage());
			model.addAttribute("content", viewPath);
			return "index";
		}
		// 등록 성공 메시지
		ra.addFlashAttribute("success", "会員登録完了");
		return resolver.redirectView("success");
	}
	
	@PostMapping("/updateName")
	public String updateName(@Valid
							 @ModelAttribute("nameUpdateForm") NameUpdateForm form,
							 @AuthenticationPrincipal CustomUserDetails user,
							 BindingResult br,
							 Model model,
							 RedirectAttributes ra) {
		if(br.hasErrors()) {
			model.addAttribute("content", resolver.pageResolve("info"));
			br.rejectValue("name", "updateName.name.error", "");
			
			return "index";
		}
		memberService.updateName(form.getName(), user.getId());
		ra.addFlashAttribute("NameUpdateResult", "名前を変更しました");
		
		return resolver.redirectView("info");
	}
	
	@PostMapping("/updatePassword")
	public String updatePassword(@Valid
								 @ModelAttribute("passwordUpdateForm") PasswordUpdateForm form,
								 @AuthenticationPrincipal CustomUserDetails user,
								 BindingResult br,
								 Model model,
								 RedirectAttributes ra) {
		if(br.hasErrors()) {
			model.addAttribute("content", resolver.pageResolve("info"));
			br.rejectValue("currentPassword", "updatePassword.currentPassword.error", "");
			br.rejectValue("newPassword", "updatePassword.newPassword.error", "");
			br.rejectValue("confirmPassword", "updatePassword.confirmPassword.error", "");
			
			return "index";
		}
		authService.updatePassword(form.getCurrentPassword(), form.getNewPassword(), user.getId());
		ra.addFlashAttribute("PasswordUpdateResult", "パスワードを変更しました");
		return resolver.redirectView("info");
	}	
	
	@PostMapping("/updateLink")
	public String updateLink(@Valid
							 @ModelAttribute("updateLinkForm") UpdateLinkForm form,
							 @AuthenticationPrincipal CustomUserDetails user,
							 BindingResult br,
							 Model model,
							 RedirectAttributes ra) {
		if(br.hasErrors()) {
			model.addAttribute("content", resolver.pageResolve("info"));
			br.rejectValue("linkId", "updateLink.linkId.error", "");
			br.rejectValue("newLink", "update.newLink.error", "");
			
			return "index";
		}
		memberService.updateLink(form.getLinkId(), user.getId(), form.getNewLink());
		ra.addFlashAttribute("UpdateLinkResult", "リンクを更新しました");
		
		return resolver.redirectView("info");
	}
	
	@PostMapping("/deleteFollow")
	public String deleteFollow(@Valid
							   @ModelAttribute("deleteFollowForm") DeleteFollowForm form,
							   @AuthenticationPrincipal CustomUserDetails user,
							   BindingResult br,
							   Model model,
							   RedirectAttributes ra) {
		if(br.hasErrors()) {
			model.addAttribute("content", resolver.pageResolve("info"));
			
			return "index";
		}
		followService.deleteFollow(form.getFollowId(), user.getId());
		ra.addFlashAttribute("DeleteFollowResult", "フォローを削除しました");
		
		return resolver.redirectView("info");
	}
	
	@PostMapping("/updateIsDelete")
	public String updateIsDelete(@Valid
								 @ModelAttribute("updateIsDeleteForm") UpdateIsDeleteForm form,
								 @AuthenticationPrincipal CustomUserDetails user,
								 RedirectAttributes ra) {
		memberService.deleteAccount(user.getId());
		ra.addFlashAttribute("UpdateIsDeleteResult", "会員を退会しました");
		
		return resolver.redirectLogic("logout");
	}
	
}
