package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller라고 알려줌
@Controller
public class ResisterPost {

	@RequestMapping("add")
	ModelAndView resisterPost(Board board) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("member",board);
		mv.setViewName("forward:/print");
		return mv;
	}
}
