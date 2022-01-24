package com.stone.springmvc.member.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import config.DBConfig;

@Repository
public class 회원DAO {
	public boolean 있는가(String id, String password) {
		boolean 있다=  false;
		Connection con = null;		 
	    try{
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
	        PreparedStatement 명령자=con.prepareStatement("select count(*) from member where id=? and password=?");
	        명령자.setString(1, id);
	        명령자.setString(2, password);
	        ResultSet 있냐표 =명령자.executeQuery();
	        if(있냐표.next()) {
	        	if(있냐표.getInt(1)==1) {
	        		있다=true;
	        	}
	        }
	        있냐표.close();
	        con.close();
	   }
	   catch(Exception ex){ ex.printStackTrace(); }
	    return 있다;
	}

}
