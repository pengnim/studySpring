package com.stone.springmvc.member.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test회원컨트롤러 {
	
	@GetMapping("/member")
	public ModelAndView 회원자신의정보를보다() {		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/Test본인정보창");
		return mv;
	}
}
