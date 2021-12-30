package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringForwardEx {

	@RequestMapping("ccc")
	ModelAndView C() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/aaa");
		return mv;
	}
	
	//내부적으로 요청이 바뀐것이라 브라우저에는 ccc표시
	@RequestMapping("aaa")
	void A() {
		System.out.println("forward A()");
	}
	
}
