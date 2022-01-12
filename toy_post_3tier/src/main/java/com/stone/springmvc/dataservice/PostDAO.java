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

	public PostDAO() {
	}

	// 입력받은 내용 db에 저장
	public void savePost(Board newBoard) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
					// URL
					"root", "1234"); // USER_NAME과 PASSWORD

			PreparedStatement pstmt = con.prepareStatement("insert into board(title,contents) values(?,?)");
			pstmt.setString(1, newBoard.getTitle());
			pstmt.setString(2, newBoard.getContents());
			pstmt.executeUpdate();

			// DB조작
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// db에 있는 게시물 목록 가져오기
	public List<Board> select(int startPageNo, int sizePerPage) throws SQLException {
		List<Board> list = new ArrayList<>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
					// URL
					"root", "1234"); // USER_NAME과 PASSWORD

			PreparedStatement pstmt = con.prepareStatement("select * from board order by no desc limit ?,?");
			pstmt.setInt(1,  startPageNo-1);
			pstmt.setInt(2, sizePerPage);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setContents(rs.getString(3));
				list.add(b);
			}
		
			con.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return list;
	}

	// 해당하는 번호의 게시물 가져오기
	public Board findContents(int no) throws SQLException {
		Board post = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
					// URL
					"root", "1234"); // USER_NAME과 PASSWORD

			String sql = "select * from board where no=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				post = new Board();
				post.setNo(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setContents(rs.getString(3));
			}
			con.close();
		} catch (SQLException | ClassNotFoundException e) {

		}
		return post;
	}

	public void changePost(Board board) {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
					// URL
					"root", "1234"); // USER_NAME과 PASSWORD
			

			PreparedStatement pstmt = con.prepareStatement("update board set title=?,contents=? where no=?");
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.setInt(3, board.getNo());
			pstmt.executeUpdate();

			// DB조작
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}

	}
	
	public void deletePost(int no) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
					// URL
					"root", "1234"); // USER_NAME과 PASSWORD

			PreparedStatement 명령자 = con.prepareStatement("delete from board where no=?");
			명령자.setInt(1, no);
			명령자.executeUpdate();

			// DB조작
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public int count() {
		int cnt = 0;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", // DB
					// URL
					"root", "1234"); // USER_NAME과 PASSWORD

			PreparedStatement pstmt = con.prepareStatement("select count(*) from board");
		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cnt = rs.getInt(1);
			}
		
			con.close();

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return cnt;
	}

}
