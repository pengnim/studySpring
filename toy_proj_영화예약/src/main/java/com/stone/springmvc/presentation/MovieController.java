package com.stone.springmvc.presentation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Movie;
import com.stone.springmvc.common.Users;
import com.stone.springmvc.service.MovieService;

import config.MvcConfig;

@Controller // 메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class MovieController {

	@Autowired
	MovieService ms = new MovieService();

	// 로그인창으로 이동
	@RequestMapping("login")
	ModelAndView 로그인하기() {
		ms.로그인하기();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("로그인창");
		return mv;
	}

	@RequestMapping("userchk")
	ModelAndView 로그인유저확인하기(Users u) throws SQLException {
		String id = u.getId();
		String pw = u.getPw();
		boolean 존재 = ms.유저확인하기(id, pw);
		ModelAndView mv = new ModelAndView();
		if (존재) {
			//세션대신 매번 유저정보 넘겨주기
			mv.addObject("id", id);
			mv.addObject("pw", pw);
			mv.setViewName("forward:/selectmv");
		} else {
			mv.setViewName("forward:/login?result=false");
		}

		return mv;
	}

//	// 회원가입창으로이동
//	@RequestMapping("signup")
//	ModelAndView 회원가입하기() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("회원가입창");
//		return mv;
//	}

	@RequestMapping("selectmv")
	ModelAndView 영화목록출력하기() throws SQLException {
		List<Movie> movies = ms.영화목록가져오기();
		ModelAndView mv = new ModelAndView();
		mv.addObject("movies", movies);
		mv.setViewName("영화선택창");
		return mv;
	}
	
	
	@RequestMapping("selectseat")
	ModelAndView 좌석선택하기() throws SQLException {
	
		ModelAndView mv = new ModelAndView();
	
		mv.setViewName("좌석선택창");
		return mv;
	}
	
	
	
	
//	
//	@RequestMapping("test")
//	ModelAndView test() throws SQLException {
//	
//		ModelAndView mv = new ModelAndView();
//	
//		mv.setViewName("테스트창");
//		return mv;
//	}
	
	

}
