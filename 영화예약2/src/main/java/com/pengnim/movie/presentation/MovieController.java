package com.pengnim.movie.presentation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pengnim.movie.common.Movie;
import com.pengnim.movie.common.예약정보;
import com.pengnim.movie.service.MovieService;

import config.MvcConfig;

@Controller // 메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class MovieController {

	@Autowired
	MovieService ms = new MovieService();

	@RequestMapping("callmain")
	ModelAndView 영화선택하기() throws SQLException {
		List<Movie> movies = ms.영화목록가져오기();
		ModelAndView mv = new ModelAndView();
		mv.addObject("movies", movies);
		mv.setViewName("main");
		return mv;
	}
	
	
	@RequestMapping("selectseat")
	ModelAndView 좌석선택하기(String mvname) throws SQLException {
	
		//예약DAO좌석 리스트 받아서 좌석선택창에 넘겨주기, 해당하는 좌석 비활성화
		List<예약정보> 좌석리스트 = ms.예약좌석정보가져오기(mvname);
		ModelAndView mv = new ModelAndView();
		mv.addObject("mv",mvname);
		mv.addObject("list",좌석리스트);
		mv.setViewName("좌석선택창");
		return mv;
	}
	
	@RequestMapping("resister")
	ModelAndView 예약하기(String mvname, @RequestParam(value="seatList") int[] seatList) throws SQLException {

		
		ms.예약정보저장하기(mvname, seatList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("seatList",seatList);
		mv.addObject("mvname",mvname);
		mv.setViewName("예약완료창");
		return mv;
		
		
	}
	
	
	@RequestMapping("checkresi")
	ModelAndView 예약목록출력하기() {
		List<예약정보> resilist = ms.예약좌석정보가져오기();
		ModelAndView mv = new ModelAndView();
		mv.addObject("resiList", resilist);
		mv.setViewName("예약확인창");
		return mv;
	}
	
	
	@RequestMapping("selectcancel")
	ModelAndView 취소할예약선택하기() throws SQLException {
	
		List<예약정보> 취소리스트 = ms.예약좌석정보가져오기();
		ModelAndView mv = new ModelAndView();
		mv.addObject("cancellist",취소리스트);
		mv.setViewName("취소목록창");
		return mv;
	}
	
	@RequestMapping("cancel")
	ModelAndView 취소하기(@RequestParam(value="no") List<Integer> nos) throws SQLException {		
		ms.예약취소하기(nos);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("취소완료창");
		return mv;
	}

	@RequestMapping("updateseat")
	ModelAndView 좌석업데이트하기() throws SQLException {
	
		List<Movie> 전체영화목록 = ms.영화목록가져오기(); //한 영화가 예약된 좌석이 없을 경우 업데이트 되지 않는 경우 발생, 무조건 해줘야함
		Map<String, Integer> movies = ms.영화별예약좌석정보가져오기();
		ms.좌석업데이트하기(movies, 전체영화목록);
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:/callmain");
		return mv;
	}

	
	
	
	

}
