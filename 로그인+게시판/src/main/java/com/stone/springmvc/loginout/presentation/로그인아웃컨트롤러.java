package com.stone.springmvc.loginout.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stone.springmvc.loginout.service.로그인아웃업무자;
import com.stone.springmvc.member.common.Member;
@Controller
public class 로그인아웃컨트롤러 {
	
	@Autowired 로그인아웃업무자 로그인아웃업무자;
	
	@GetMapping("/login")
	public String 로그인준비하다() {
		if(로그인아웃업무자.로그인준비가능한가()) {
			return "로그인창";
		}		
		return null;
	}
	/*@PostMapping("/login")
	public String 로그인하다(String id, String password, HttpSession session) {
		//로그인 성공시
		if(로그인아웃업무자.로그인이가능한가(id, password)) {
			//로그인정보 저장
			session.setAttribute("id", id);
			//메인 페이지로
			return "redirect:/main";
		}
		//로그인 실패시 다시 로그인 페이지
		return "에러로그인창";		
	}*/
	
	
	@PostMapping("/login")
	public String 로그인하다(String id, String password, HttpSession session) {
		//로그인 성공시
		Member 로그인한회원 = 로그인아웃업무자.로그인조회하다(id, password);
		if(로그인한회원!=null) {
			//로그인정보 저장
			session.setAttribute("id", id);
			session.setAttribute("회원번호", 로그인한회원.getNo());
			session.setAttribute("회원성명", 로그인한회원.getName());
			//메인 페이지로
			return "redirect:/main";
		}
		//로그인 실패시 다시 로그인 페이지
		return "에러로그인창";		
	}
	
	
	
	
	@GetMapping("/logOut")
	public String 로그아웃하다(HttpSession session) {
		
		//만약 로그인되어 있었다면.
		if(session!=null && session.getAttribute("id")!=null) {
			//세션 객체를 무효화 시킴
			session.invalidate();
		}
		return "redirect:/main";
	}

}
