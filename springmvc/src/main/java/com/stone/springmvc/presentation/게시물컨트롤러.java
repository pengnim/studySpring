package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller라고 알려줌
@Controller
public class 게시물컨트롤러 {
	
	//요청을 "day"라고하면 아래 수행, 요청한개당 처리메소드 1개
	@RequestMapping("list")
	void 게시물목록출력() {
		System.out.println("게시물목록출력");
	}
	@RequestMapping("add")
	void 게시물추가() {
		System.out.println("게시물추가");
	}
}
