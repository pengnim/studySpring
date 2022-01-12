package com.stone.springmvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stone.springmvc.common.Board;
import com.stone.springmvc.dataservice.PostDAO;

public class ManagePost {
	@Autowired
	PostDAO dao = new PostDAO();
	
	public void preparePost() {
		//(업무)
		//현재 업무 규칙 없음
		//(DB)
	}

	public List<Board> collectPost(int startPageNo, int sizePerPage) throws SQLException {
		//(업무)
		//현재 업무 규칙 없음
		//(DB)
		return dao.select(startPageNo, sizePerPage);
	}
	
	public int countPost() {
		return dao.count();
	}
	
	public void addPost(Board newBoard) throws SQLException {
		//(업무)
		//현재 업무 규칙 없음
		//(DB)
		dao.savePost(newBoard);
	}

	public Board referPost(int no) throws SQLException {
		//(업무)
		//현재 업무 규칙 없음
		//(DB)
		return dao.findContents(no);
	}
	public Board prepareModiPost(int no) throws SQLException {
		return dao.findContents(no);
	}
	
	
	public void modiPost(Board modiBoard) throws SQLException {
		dao.changePost(modiBoard);
	}
	
	public void deletePost(int no) throws SQLException {
		dao.deletePost(no);
	}
			
}
