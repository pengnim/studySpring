package com.stone.simple.member.persentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.service.회원관리자;

@Controller
public class 프로필 {
	@Autowired 회원관리자 회원관리자;
	
	@GetMapping("/profile/{회원번호}")
	ModelAndView 프로필사진을주다(@PathVariable("회원번호") int no) {
		
		
		Member 회원 = 회원관리자.회원정보를조회하다(no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		mv.addObject("profile", 회원.getProfile());
		return mv;
	}
	
}
