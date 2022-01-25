package com.stone.springmvc.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import org.springframework.stereotype.Repository;

import com.stone.springmvc.board.common.Board;

import config.DBConfig;

@Repository
public class 게시물DAO implements I게시물DAO{

	@Override
	public void 저장하다(Board 새게시물) {
		
	
			Connection con = null;		 
		    try{
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);        
		        PreparedStatement 명령자=con.prepareStatement("insert into board(title, contents, writer) values(?,?,?)");
		        명령자.setString(1, 새게시물.getTitle());
		        명령자.setString(2, 새게시물.getContents());
		        명령자.setInt(3, 새게시물.getNo());
		        명령자.executeUpdate();
		       
		        con.close();
		   }
		   catch(Exception ex){ ex.printStackTrace(); }
	}



	
}
