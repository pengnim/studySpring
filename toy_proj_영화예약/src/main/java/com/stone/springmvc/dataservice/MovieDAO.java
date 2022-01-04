package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stone.springmvc.common.Movie;
import com.stone.springmvc.common.Users;

public class MovieDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public MovieDAO() {
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


	//db에 있는 영화리스트 가져오기
	public List<Movie> 목록가져오기() throws SQLException {
		List<Movie> list = new ArrayList<>();

		try {

			pstmt = con.prepareStatement("select * from mvtable");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setMvname(rs.getString(1));
				m.setLeftSeat(rs.getInt(2));
				list.add(m);
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} 
		return list;
	}


}
