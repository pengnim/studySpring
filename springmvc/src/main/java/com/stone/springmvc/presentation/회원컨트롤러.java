package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class 회원컨트롤러 {
	@RequestMapping("aaa")
	void 회원등록() {
		System.out.println("회원");
	}
}
