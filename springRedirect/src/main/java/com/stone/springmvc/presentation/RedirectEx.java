package com.stone.springmvc.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller라고 알려줌
@Controller
public class RedirectEx {

	//aaa를 치면 B()로 이동해서 bbb출력, 브라우저도 bbb로 바뀜
	@RequestMapping("aaa")
	String A() {
		return "redirect:/bbb";
	}

	@RequestMapping("bbb")
	void B() {
		System.out.println("bbb");
	}
}
