package com.stone.springmvc.member.dataservice;

import com.stone.springmvc.member.common.Member;

public interface I회원DAO {

	public Member 찾다ById와Password(String id, String password);
	public Member 찾다By회원번호(int no);
}
