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

	public List<Board> collectPost() throws SQLException {
		//(업무)
		//현재 업무 규칙 없음
		//(DB)
		return dao.select();
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
			
}
