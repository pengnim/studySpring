package com.stone.springmvc.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.board.common.Board;
import com.stone.springmvc.board.dataservice.I게시물DAO;

@Service
public class 게시물업무자 implements I게시물업무자 {
	@Autowired
	I게시물DAO 게시물DAO;

	@Override
	public boolean 게시물작성이가능한가() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void 게시물을등록하다(Board 새게시물) {
		
		게시물DAO.저장하다(새게시물);
	}
}
