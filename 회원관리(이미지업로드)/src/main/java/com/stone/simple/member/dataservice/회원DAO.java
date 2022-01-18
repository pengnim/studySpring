package com.stone.simple.member.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	        PreparedStatement 명령자=con.prepareStatement("insert into member(name, tel, post, address, detailaddress, id, password, email, state) values(?,?,?,?,?,?,?,?,?)");
	        명령자.setString(1, 새회원.getName());
	        //명령자.set(2, 새회원.getProfileFile());
	        명령자.setString(3, 새회원.getTel());
	        명령자.setString(4, 새회원.getPost().trim());
	        명령자.setString(5, 새회원.getAddress());
	        명령자.setString(6, 새회원.getDetailAddress());
	        명령자.setString(7, 새회원.getId());
	        명령자.setString(8, 새회원.getPassword());
	        명령자.setString(9, 새회원.getEmail());
	        명령자.setString(10, String.valueOf(새회원.getState()));
	        명령자.executeUpdate();
	       
	       
	       con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	}
}
