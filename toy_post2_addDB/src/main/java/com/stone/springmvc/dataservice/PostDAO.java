package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.springmvc.common.Board;

public class PostDAO {
	public void savePost(Board newBoard) {
		// jdbc
		Connection con = null;

		try {
			//localhost:3306/스키마이름?user...
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
																													// URL
					"root", "1234"); // USER_NAME과 PASSWORD
			PreparedStatement pstmt = con.prepareStatement("insert into board(title, contents) values (?,?)");
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getContents());
			pstmt.executeUpdate();
			con.close();
		}

		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	public List<Board> select() {
		List<Board> list = new ArrayList<>();
		Connection con = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
																													// URL
					"root", "1234"); // USER_NAME과 PASSWORD
			PreparedStatement pstmt = con.prepareStatement("select * from board");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board b = new Board();
				b.setNo(rs.getLong(1));
				b.setTitle(rs.getString(2));
				b.setContents(rs.getString(3));
				list.add(b);
			}
			con.close();
		}

		catch (Exception ex) {

			ex.printStackTrace();
		}
		return list;
	}
}
