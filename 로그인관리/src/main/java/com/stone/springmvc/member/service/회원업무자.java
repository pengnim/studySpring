package com.stone.springmvc.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stone.springmvc.member.dataservice.*;

@Service
public class 회원업무자 {
	@Autowired 회원DAO 회원DAO; 
	
	public boolean 있는가(String id, String  password) {
		
		return 회원DAO.있는가(id, password);
	}
}
