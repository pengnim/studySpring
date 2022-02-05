package com.stone.springmvc.board.presentation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.board.common.Board;
import com.stone.springmvc.board.service.I게시물업무자;
import com.stone.springmvc.member.common.Member;

@Controller
public class 게시물컨트롤러 {
	@Autowired
	I게시물업무자 게시물업무자;

	@GetMapping("/board")
	public String 게시물작성을준비하다() {
		if (게시물업무자.게시물작성이가능한가()) {
			return "board/게시물등록창";
		} else
			return null;// 실제는 작성불가하다는 알림창

	}

	@PostMapping("/board")
	public String 게시물을등록하다(Board 새게시물, HttpSession session) {
		// 로그인한 회원의 번호 구해야함-로그인 당시 회원번호를 setAttribute 했다는 것을 전제로 할때
		int 로그인한회원번호 = (int) session.getAttribute("회원번호");
		// 로그인한 회원이 작성자(writer)이므로 새게시물에 작성자를 set 해주어야함
		Member 작성한회원 = new Member();
		작성한회원.setNo(로그인한회원번호);
		새게시물.setWriter(작성한회원);

		게시물업무자.게시물을등록하다(새게시물);
		return "board/게시물등록알림창";
	}
	
	@RequestMapping("/boards")
	public ModelAndView 게시물목록을출력하다() {
		List<Board> boards = 게시물업무자.모든게시물을수집하다();
		if(boards.size() == 0 || boards == null)
			System.out.println("null");
		else System.out.println("ok");
		ModelAndView mv = new ModelAndView();
		mv.addObject("boards", boards);
		mv.setViewName("board/게시물목록창");
		return mv;
	}
	
	@GetMapping("/board/{no}")
	public ModelAndView 게시물상세출력하다(@PathVariable int no, HttpSession session) {
		Board board = 게시물업무자.게시물을조회하다And조회수증가하다(no);
		Boolean isWriter;
		System.out.println((Integer)session.getAttribute("회원번호"));
		//동일 인물 true, 다른 인물 false, 로그인 안돼있으면 null
		if(board.getWriter().getNo() == (int)session.getAttribute("회원번호")) {
			System.out.println("true");
			isWriter = true;
		}
		else if(session.getAttribute("회원번호") == null || session == null) {
			System.out.println("null");
			isWriter = null;
		}
		else isWriter = false;
		ModelAndView mv = new ModelAndView();
		mv.addObject("isWriter", isWriter);
		mv.addObject("board",board);
		mv.setViewName("board/게시물상세창");
		return mv;
	}
	
	//게시물수정준비
	@GetMapping("/board/modify/{no}")
	ModelAndView 게시물수정을준비하다(@PathVariable int no) {
		//게시물 조회 => 해당 내용 return
		Board b = 게시물업무자.게시물수정을준비하다(no);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board",b);
		mv.setViewName("board/게시물수정창");
		return mv;
		
	}
	
	@PostMapping("/board/modify")
	String 게시물을수정하다(Board 수정한게시물) {
		//게시물 업데이트하기
		게시물업무자.게시물수정하다(수정한게시물);
		//업데이트하고 게시물 리스트로 넘기기
		return "forward://boards";
	}
	//게시물삭제
	@GetMapping("/board/remove/{no}")
	String 게시물삭제(@PathVariable int no) {
		게시물업무자.게시물삭제하다(no);
		return "board/게시물삭제완료창";
	}
	
	
	
	

}
