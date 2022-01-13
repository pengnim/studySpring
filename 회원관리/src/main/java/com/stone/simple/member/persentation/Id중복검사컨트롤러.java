package com.stone.simple.member.persentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Id중복검사컨트롤러 {
	
	//RequestMapping : get, post 둘다 가능
	//GetMapping : get만 가능
	//PostMapping : post만 가능
	//localhost:8080/id 형식으로 들어와야함 -> localhost:8080/simple X
	//root에서 바로 부를경우 server에 path "/"로 설정 
	@GetMapping("/id")  
	public String id중복확인준비하다() {
		return "아이디중복확인창";
	}
	
	@PostMapping("/id")
	public String id중복확인하다() {
		return null;
	}
	
	
}
