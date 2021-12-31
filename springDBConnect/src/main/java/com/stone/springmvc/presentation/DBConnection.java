package com.stone.springmvc.presentation;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 메소드 단위 매핑, 아래 내용은 컨트롤러 3개
public class DBConnection {

	Connection con = null;
	@RequestMapping("test")
	public void pocess() {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
																													// URL
					"root", "1234"); // USER_NAME과 PASSWORD
			System.out.println("Success!!!");
			con.close();
		}

		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

}
