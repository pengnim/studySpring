package com.stone.simple.member.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import org.springframework.stereotype.Repository;

import com.stone.simple.member.common.Member;

import config.DBConfig;

@Repository
public class 회원DAO {
	public boolean 아이디가있는가(String id) {
		boolean 아이디있다=false;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select count(*) from member where id=?");
	        명령자.setString(1, id);
	        ResultSet 아이디갯수표 =명령자.executeQuery();
	        if(아이디갯수표.next()) {
	        	if(아이디갯수표.getInt(1)>0) {아이디있다=true;}
	        	System.out.println("DB확인");//@MyTest
	        } 
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	    System.out.println(아이디있다);//@MyTest
		return 아이디있다;
	} 
	
	public void 저장하다(Member 새회원) {
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("insert into member(name,profile,tel,post,address,detailaddress,id,password,email,state) values(?,?,?,?,?,?,?,?,?,?)");
	        명령자.setString(1, 새회원.getName());
	        명령자.setBytes(2, 새회원.getProfile());
	        명령자.setString(3, 새회원.getTel());
	        명령자.setString(4, 새회원.getPost());
	        명령자.setString(5, 새회원.getAddress());
	        명령자.setString(6, 새회원.getDetailAddress());
	        명령자.setString(7, 새회원.getId());
	        명령자.setString(8, 새회원.getPassword());
	        명령자.setString(9, 새회원.getEmail());
	        명령자.setString(10, String.valueOf(새회원.getState()) );
	        명령자.executeUpdate();	         
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }	
	}
	
	public Member 찾기By번호(int no) {
		Member 찾은회원 = null;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
	        PreparedStatement 명령자=con.prepareStatement("select * from member where no=?");
	        명령자.setInt(1, no);
	        ResultSet 회원표 =명령자.executeQuery();
	        if(회원표.next()) {
	       
	        	String name = 회원표.getString("name");
	        	byte[] profile=회원표.getBytes("profile");
	        	String tel = 회원표.getString("tel");
	        	String post = 회원표.getString("post");
	        	String address = 회원표.getString("address");
	        	String detailAddress = 회원표.getString("detailAddress");
	        	String id = 회원표.getString("id");
	        	String email = 회원표.getString("email");
	        	char state = 회원표.getString("state").charAt(0);
	        	Date rdate = 회원표.getDate("rdate");
	        	
	        	찾은회원 = new Member();
	        	찾은회원.setNo(no);
	        	찾은회원.setName(name);
	        	찾은회원.setProfile(profile);
	        	찾은회원.setTel(tel);
	        	찾은회원.setPost(post);
	        	찾은회원.setAddress(address);
	        	찾은회원.setDetailAddress(detailAddress);
	        	찾은회원.setId(id);
	        	찾은회원.setEmail(email);
	        	찾은회원.setState(state);
	        	찾은회원.setRdate(rdate);	        	
	        } 
	        회원표.close();	        
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	    return 찾은회원;
	}
}
