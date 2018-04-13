package com.cafe24.bitmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminProductController")
@RequestMapping("/admin/product")
public class ADProductController {

	@RequestMapping("")
	public String adminProduct() {
		return "/admin/product";
	}
	
	@RequestMapping("/product_new")
	public String adminProductNew() {
		return "/admin/product_new";
	}

	@RequestMapping("/product_edit")
	public String adminProductEdit() {
		return "/admin/product_edit";
	}
}
