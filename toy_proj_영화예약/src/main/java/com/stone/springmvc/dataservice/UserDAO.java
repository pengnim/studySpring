package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import com.stone.springmvc.common.Users;

public class UserDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public UserDAO() {
		// jdbc

		try {
			// localhost:3306/스키마이름?user...
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
																													// URL
					"root", "1234"); // USER_NAME과 PASSWORD

		}

		catch (Exception ex) {

			ex.printStackTrace();
		}
	}


	//db에 있는 유저정보 가져오기
	public Users 일치하는유저확인하기(String id, String pw) throws SQLException {
		Users user = null;

		try {

			pstmt = con.prepareStatement("select * from user_table where id=? and pw=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new Users();
				user.setId(rs.getString(1));
				user.setPw(rs.getString(2));
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} 
		return user;
	}
	
	//디비에 유저정보 입력
	public void insert(String id, String pw) {
		try {

			pstmt = con.prepareStatement("insert into user_table values(?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			int count = pstmt.executeUpdate();
			if(count > 0) System.out.println("success");
			else System.out.println("fail");

		} catch (Exception ex) {

			ex.printStackTrace();
		} 
	}


}
