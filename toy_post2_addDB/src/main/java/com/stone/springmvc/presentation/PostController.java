package com.stone.springmvc.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.PostDAO;

@Controller // 메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class PostController {

	PostDAO dao = new PostDAO();

	@RequestMapping("list")
	ModelAndView printPost() {
		//게시물 목록 dao에서 받아와서 list에 저장하기
		List<Board> list = dao.select();
		
		ModelAndView mv = new ModelAndView();
		
		//list를 mv에 저장
		mv.addObject("boards",list);
		mv.setViewName("postList");
		return mv;
	}

	@RequestMapping("add")
	ModelAndView addPost(Board board) {
		
		//게시물 저장
		dao.savePost(board);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/list");
		return mv;
	}

	@RequestMapping("prepare")
	ModelAndView preparePost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("writePost");
		return mv;
	}

}
