package com.stone.springmvc.presentation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.PostDAO;

@Controller // 메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class PostController {

	PostDAO dao = new PostDAO();

	
	//게시물 내용 등록 준비, writePost.jsp로 이동함
	@RequestMapping("prepare")
	ModelAndView preparePost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("writePost");
		return mv;
	}
	
	
	//writePost.jsp에서 작성한 내용을 DB에 저장하고 list로 forward
	@RequestMapping("add")
	ModelAndView addPost(Board board) {
		
		//게시물 저장
		try {
			dao.savePost(board);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/list");
		return mv;
	}
	
	
	//DB에 있는 정보를 불러와 list출력
	@RequestMapping("list")
	ModelAndView printPost() {
		//게시물 목록 dao에서 받아와서 list에 저장하기
		List<Board> list = null;
		try {
			list = dao.select();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView();
		
		//list를 mv에 저장
		mv.addObject("boards",list);
		mv.setViewName("postList");
		return mv;
	}
	
	//해당하는 번호를 가진 게시물의 제목과 내용을 db에서 가져오기
	@RequestMapping("detail")
	ModelAndView printDetail(int no) throws SQLException {
		Board b = dao.findContents(no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postDetail");
		mv.addObject("board",b);
		return mv;
	}

	

	

}
