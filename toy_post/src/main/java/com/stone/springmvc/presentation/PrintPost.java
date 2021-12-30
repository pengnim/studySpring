package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintPost {


	@RequestMapping("print")
	ModelAndView resisterPost(Board board) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", board);
		mv.setViewName("printPost");
		return mv;
	}
}
