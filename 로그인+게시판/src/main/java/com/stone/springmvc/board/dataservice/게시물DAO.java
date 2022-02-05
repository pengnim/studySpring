package com.stone.springmvc.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stone.springmvc.board.common.Board;
import com.stone.springmvc.member.common.Member;
import com.stone.springmvc.member.dataservice.I회원DAO;
import com.stone.springmvc.member.dataservice.회원DAO;

import config.DBConfig;

@Repository
public class 게시물DAO implements I게시물DAO {

	@Autowired I회원DAO 회원DAO;
	@Override
	public void 저장하다(Board 새게시물) {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			PreparedStatement 명령자 = con.prepareStatement("insert into board(title, contents, writer, views) values(?,?,?,?)");
			명령자.setString(1, 새게시물.getTitle());
			명령자.setString(2, 새게시물.getContents());
			명령자.setInt(3, 새게시물.getWriter().getNo());
			명령자.setInt(4, 0);
			명령자.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Board> 모든게시물을수집하다() {
		List<Board> 수집된게시물들 = new ArrayList<>();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			PreparedStatement 명령자 = con.prepareStatement("select no, title, writer, views from board");
			ResultSet rs = 명령자.executeQuery();
			
			while(rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				Member 작성한회원 = 회원DAO.찾다By회원번호(rs.getInt(3));
				b.setWriter(작성한회원);
				b.setViews(4);
				수집된게시물들.add(b);
			}
			rs.close();
			con.close();
		}catch(Exception e) {
			
		}
		
		return 수집된게시물들;
	}

	@Override
	public Board 게시물을조회하다And조회수증가하다(int 게시물번호) {
		Connection con = null;
		Board b = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			//조회수 증가
			PreparedStatement pstmt = con.prepareStatement("update board set views=views+1 where no=?");
			pstmt.setInt(1, 게시물번호);
			pstmt.executeUpdate();
			
			//조회할 게시물 정보
			PreparedStatement pstmt2 = con.prepareStatement("select no, title, contents, writer, views from board where no=?");
			pstmt2.setInt(1, 게시물번호);
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {
				b = new Board();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setContents(rs.getString(3));
				Member member = 회원DAO.찾다By회원번호(rs.getInt(4));
				b.setWriter(member);
				b.setViews(rs.getInt(5));
			}

		} catch (Exception e) {

		}
		return b;
	}

	public Board 게시물조회하다(int 게시물번호) {
		Connection con = null;
		Board b = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			
			//조회할 게시물 정보
			PreparedStatement pstmt2 = con.prepareStatement("select no, title, contents, writer, views from board where no=?");
			pstmt2.setInt(1, 게시물번호);
			ResultSet rs = pstmt2.executeQuery();
			while(rs.next()) {
				b = new Board();
				b.setNo(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setContents(rs.getString(3));
				Member member = 회원DAO.찾다By회원번호(rs.getInt(4));
				b.setWriter(member);
				b.setViews(rs.getInt(5));
			}

		} catch (Exception e) {

		}
		return b;
		
	}
	@Override
	public void 게시물수정하다(Board 수정한게시물) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);
			
			//조회할 게시물 정보
			PreparedStatement pstmt = con.prepareStatement("update board set title=?, contents=? where no=?");
			pstmt.setString(1, 수정한게시물.getTitle());
			pstmt.setString(2, 수정한게시물.getContents());
			pstmt.setInt(3, 수정한게시물.getNo());
			pstmt.executeUpdate();

		} catch (Exception e) {

		}
	}

	@Override
	public void 게시물삭제하다(int 게시물번호) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DBConfig.DBURL, DBConfig.ID, DBConfig.PASSWORD);

			PreparedStatement pstmt = con.prepareStatement("delete from board where no=?");
			pstmt.setInt(1, 게시물번호);
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("err");
		}
	}

}
