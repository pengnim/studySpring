package com.pengnim.movie.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.pengnim.movie.common.Movie;

@Repository
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

	// db에 있는 영화리스트 가져오기
	public List<Movie> 목록가져오기() throws SQLException {
		List<Movie> list = new ArrayList<>();

		try {

			pstmt = con.prepareStatement("select * from mvtable");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setMvname(rs.getString(1));
				m.setRemainingSeat(rs.getInt(2));
				list.add(m);
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return list;
	}

	public void 잔여좌석업데이트(Map<String, Integer> movies, List<Movie> 전체영화목록) throws SQLException {

		//movies의 keyset저장 = 이미 예약된 좌석들의 영화이름
		Set<String> moviesKey = movies.keySet();
		boolean isKeySet = false; //전체 영화들과 키셋에 있는 영화이름이 같은지 판단하는 변수
		
		for (Movie 영화 : 전체영화목록) {
			String sql = ""; //업데이트문 집어넣을 sql 초기화
			for (String ks : moviesKey) {
				if (영화.getMvname().equals(ks)) {
					sql = "update mvtable set remainingseat = 25-(" + movies.get(ks) + ") where mvname='" + ks + "'";
					isKeySet = true;
				}
			}

			if (isKeySet)
				isKeySet = false;
			else {
				sql = "update mvtable set remainingseat = 25 where mvname='" + 영화.getMvname() + "'";
			}

			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}
	}

}
