package com.stone.springmvc.loginout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.member.service.*;

@Service
public class 로그인아웃업무자 {
	@Autowired 회원업무자 회원업무자;
	
	public boolean 로그인준비가능한가() {
				
		return true;
	}
	
	/*
	public boolean  로그인이가능한가(String id, String  password) {
		
		return 회원업무자.있는가(id, password);
	}
	*/
	
	public Member 로그인조회하다(String id, String  password) {
		
		return 회원업무자.조회하다(id, password);
	}
}
