package com.stone.springmvc.board.dataservice;

import java.util.List;

import com.stone.springmvc.board.common.Board;

public interface I게시물DAO {

	public void 저장하다(Board 새게시물);
	public List<Board> 모든게시물을수집하다();
	public Board 게시물을조회하다And조회수증가하다(int 게시물번호);
	public Board 게시물조회하다(int 게시물번호);
	public void 게시물수정하다(Board 수정한게시물);
	public void 게시물삭제하다(int 게시물번호);
}
