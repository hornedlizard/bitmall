package com.cafe24.bitmall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(@ModelAttribute MemberVo vo) {
		return "user/member_join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@Valid MemberVo vo,
					BindingResult result, Model model,
					@RequestParam(value="admin", defaultValue="0") int admin) {
		// validation
		if (result.hasErrors()) {
			model.addAttribute("vo", vo);
			return "user/member_join";
		}
		
		// 중복 가입 시도 막기
		int insertResult = memberService.join(vo);
		if (insertResult == 0) {
			return "user/member_join";
		}
		
		// 가입성공
		return "redirect:/member/joinsuccess";		
	}
	
	@RequestMapping(value="/joinsuccess", method=RequestMethod.GET)
	public String joinsuccess() {
		return "/user/member_joinend";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/member_login";
	}
}
