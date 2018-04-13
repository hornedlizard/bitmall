package com.cafe24.bitmall.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

@Controller("userAPIController")
@RequestMapping("/api/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@ResponseBody
	@RequestMapping("/checkId")
	public JSONResult checkEmail(
			@RequestParam(value="id", required=true, defaultValue="") String id) {
		int result = memberService.checkId(id);
		return JSONResult.success(result == 0 ? "not exist" : "exist");
	}
	
}
