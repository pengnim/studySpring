package com.stone.springmvc.presentation;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.PostDAO;
import com.stone.springmvc.service.ManagePost;

@Controller // 메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class PostController {

	
	@Autowired
	ManagePost mp = new ManagePost();
	
	//게시물 내용 등록 준비, writePost.jsp로 이동함
	@RequestMapping("prepare")
	ModelAndView preparePost() {
		mp.preparePost();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("writePost");
		return mv;
	}
	
	
	//writePost.jsp에서 작성한 내용을 DB에 저장하고 list로 forward
	@RequestMapping("add")
	ModelAndView addPost(Board board) throws SQLException {
		
		//게시물 저장
		mp.addPost(board);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:/list");
		return mv;
	}
	
	
	//DB에 있는 정보를 불러와 list출력 
	//required=false :값이 안들어올수도 있음, defaultValue : 값이 안들어오면 해당 값으로 할당
	@RequestMapping("list")
	ModelAndView printPost(@RequestParam(value="pageno", required=false, defaultValue="1") int 페이지번호) throws SQLException {
		
		int sizePerPage = 5;
		int lastPageNo = 페이지번호 * sizePerPage;
		int startPageNo = lastPageNo - (sizePerPage-1);
	
		//게시물 목록 dao에서 받아와서 list에 저장하기
		List<Board> list = mp.collectPost(startPageNo, sizePerPage);
		int count = mp.countPost();
		
		int pages = (int) Math.ceil((double) count / (double) sizePerPage);
		
		ModelAndView mv = new ModelAndView();
		
		//list를 mv에 저장
		mv.addObject("boards",list);
		mv.setViewName("postList");
		mv.addObject("lastPageNo", 페이지번호);
		mv.addObject("pages", pages);
		return mv;
	}
	
	//해당하는 번호를 가진 게시물의 제목과 내용을 db에서 가져오기
	@RequestMapping("detail")
	ModelAndView printDetail(int no) throws SQLException {
		Board b = mp.referPost(no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("postDetail");
		mv.addObject("board",b);
		return mv;
	}
	
	@RequestMapping("prepare_update")
	ModelAndView prepareModiPost(int no) throws SQLException {
		Board board = mp.prepareModiPost(no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물변경창");
		mv.addObject("modiboard", board);
		return mv;
	}

	
	@RequestMapping("update")
	ModelAndView updatePost(Board board) throws SQLException {
		mp.modiPost(board);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물변경통보창");
		return mv;
	}
	
	@RequestMapping("delete")
	ModelAndView deletePost(int no) throws SQLException {
		mp.deletePost(no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("게시물삭제통보창");
		return mv;
	}

	

}
