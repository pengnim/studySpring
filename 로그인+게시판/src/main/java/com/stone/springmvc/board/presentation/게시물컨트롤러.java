package com.stone.springmvc.board.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.board.common.Board;
import com.stone.springmvc.board.service.I게시물업무자;
import com.stone.springmvc.member.common.Member;

@Controller("/board")
public class 게시물컨트롤러 {
	@Autowired I게시물업무자 게시물업무자;
	@GetMapping
	public String 게시물작성을준비하다() {
		if(게시물업무자.게시물작성이가능한가()) {
			return "board/게시물등록창";
		}else return null;//실제는 작성불가하다는 알림창
		
	}
	@PostMapping("/board")
	public String 게시물을등록하다(Board 새게시물,HttpSession session) {
		//로그인한 회원의 번호 구해야함-로그인 당시 회원번호를   setAttribute 했다는 것을 전제로 할때
		int 로그인한회원번호 =(int) session.getAttribute("회원번호");
		//로그인한 회원이 작성자(writer)이므로 새게시물에 작성자를 set 해주어야함
		Member 작성한회원=new Member();
		작성한회원.setNo(로그인한회원번호);
		새게시물.setWriter(작성한회원);
		
		게시물업무자.게시물을등록하다(새게시물);
		return "board/게시물등록알림창";
	}
	
}
