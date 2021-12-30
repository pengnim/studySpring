package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PreparePost {
	@RequestMapping("writePost")
	String requestPostWindow() {
		return "writePost";
	}
}
