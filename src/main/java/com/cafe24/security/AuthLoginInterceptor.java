package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.MemberService;
import com.cafe24.bitmall.vo.MemberVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 모든 컨테이너는 ApplicationContext를 구현하고 있음
		// 어디서든 container에 접근하는 클래스 (servletContext -> 전역)
		ApplicationContext ac = WebApplicationContextUtils
									.getWebApplicationContext(
											request.getServletContext());
		// ApplicationContext에서 userService를 받음
		MemberService memberService = ac.getBean(MemberService.class);
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setPassword(password);
		MemberVo authUser = memberService.getByIdPassword(id, password);
		
		if (authUser == null) {
			response.sendRedirect(request.getContextPath()+"/member/login");
			return false;
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		response.sendRedirect(request.getContextPath()+"/main");
		
		return false;
	}

}
