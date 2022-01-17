package com.stone.simple.member.persentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.service.회원관리자;


@Controller
public class 회원컨트롤러 {
	
	@Autowired
	회원관리자 회원관리자;
	
	//RequestMapping : get, post 둘다 가능
	//GetMapping : get만 가능
	//PostMapping : post만 가능
	//localhost:8080/id 형식으로 들어와야함 -> localhost:8080/simple X
	//root에서 바로 부를경우 server에 path "/"로 설정 
	@GetMapping("/id")  
	public String id중복확인준비하다() {
		return "아이디중복확인창";
	}
	
	@PostMapping("/id")
	public ModelAndView id중복확인하다(String id) {
		boolean 아이디사용가능여부 = 회원관리자.아이디사용가능여부를판단하다(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("아이디중복확인창");
		mv.addObject("id",id);
		mv.addObject("usable",아이디사용가능여부);
		return mv;
	}
	
	@PostMapping("/member")
	public ModelAndView 회원등록하다(Member 새회원) {
		회원관리자.회원등록하다(새회원);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",새회원.getName());
		mv.setViewName("회원등록알림창");
		return mv;
	}
	
}
