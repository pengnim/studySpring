package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.springmvc.common.Board;

@Repository
public class PostDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public PostDAO() {
		// jdbc

		try {
			// localhost:3306/스키마이름?user...
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
																													// URL
					"root", "1234"); // USER_NAME과 PASSWORD

		}

		catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	
	//입력받은 내용 db에 저장
	public void savePost(Board newBoard) throws SQLException {
		try {
			pstmt = con.prepareStatement("insert into board(title, contents) values (?,?)");
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getContents());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
	//db에 있는 게시물 목록 가져오기
	public List<Board> select() throws SQLException {
		List<Board> list = new ArrayList<>();

		try {

			pstmt = con.prepareStatement("select * from board");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setContents(rs.getString(3));
				list.add(b);
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} 
		return list;
	}

	//해당하는 번호의 게시물 가져오기
	public Board findContents(int no) throws SQLException {
		Board post = null;
		try {
			String sql = "select * from board where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				post = new Board();
				post.setNo(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setContents(rs.getString(3));
			}

		} catch (SQLException e) {

		} 
		return post;
	}

}
