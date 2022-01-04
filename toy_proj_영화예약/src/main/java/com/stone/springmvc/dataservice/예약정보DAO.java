package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 예약정보DAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public 예약정보DAO() {
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


}
