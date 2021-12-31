package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;

@Controller //메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class PostController {
	@RequestMapping("list")
	ModelAndView printPost(    ) {
		
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("postList");
		return mv;
	}
	
	
	@RequestMapping("add")
		ModelAndView addPost(Board board) {
		
		System.out.println(board.getTitle());
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("forward:/list");
		return mv;
	}
	
	@RequestMapping("prepare")
	ModelAndView preparePost() {
		ModelAndView  mv =new ModelAndView();
		mv.setViewName("writePost");
		return mv;
	}
}
