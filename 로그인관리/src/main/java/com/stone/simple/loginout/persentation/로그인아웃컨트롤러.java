package com.stone.simple.loginout.persentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.loginout.service.로그인아웃업무자;

@Controller
public class 로그인아웃컨트롤러 {
	@Autowired 로그인아웃업무자 업무자 = new 로그인아웃업무자();
	
	@GetMapping("/login")
	public String 로그인준비하다() {
		if(업무자.로그인준비가능한가()) {
		return "로그인창";
		}
		return null;
	}
}
