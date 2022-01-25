package com.stone.springmvc.board.service;

import com.stone.springmvc.board.common.Board;

public interface I게시물업무자 {
	public boolean 게시물작성이가능한가();
	public void 게시물을등록하다(Board 새게시물);
}
