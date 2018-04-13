package com.cafe24.bitmall.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
public class ADMemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("")
	public String adminMember(Model model) {
		List<MemberVo> list = memberService.getMemberList();
		model.addAttribute("list", list);
		return "/admin/member";
	}
	
	@RequestMapping("/search")
	public String getMemberList(
			@RequestParam(value="keyword", required=false, defaultValue="") String keyword,
			@RequestParam(value="keyword-option", required=false, defaultValue="") int keyOption,
			Model model) {
		List<MemberVo> list = memberService.searchMember(keyword, keyOption);
		model.addAttribute("list", list);
		return "admin/member";
	}
	
	@RequestMapping(value="/modify/{no}", method=RequestMethod.GET)
	public String modifyMember(@PathVariable("no") long no, Model model) {
		model.addAttribute("vo", memberService.getByNo(no));
		return "user/member_modify";
	}
	
}
