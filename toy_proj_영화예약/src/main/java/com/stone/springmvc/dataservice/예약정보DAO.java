package com.stone.springmvc.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stone.springmvc.common.Movie;
import com.stone.springmvc.common.예약정보;

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

	public void 예약정보입력(String mvname, int[] seatList) {


		try {
			for (int i = 0; i < seatList.length; i++) {
				pstmt = con.prepareStatement("insert into resistermv(mvname, sno) values(?,?)");
				pstmt.setString(1, mvname);
				pstmt.setInt(2, seatList[i]);
				pstmt.executeUpdate();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<예약정보> 예약좌석정보가져오기(String mvname) {
		List<예약정보> 좌석리스트 = new ArrayList<예약정보>();
		try {
			if (mvname != null) {
				pstmt = con.prepareStatement("select * from resistermv where mvname=?");
				pstmt.setString(1, mvname);

			} else {
				pstmt = con.prepareStatement("select * from resistermv");
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				예약정보 tmp = new 예약정보();
				tmp.setNo(rs.getInt(1));
				tmp.setMvname(rs.getString(2));
				tmp.setSno(rs.getInt(3));
				좌석리스트.add(tmp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 좌석리스트;
	}
	
	//이상없음
	public Map<String, Integer> 영화별예약좌석정보가져오기() {
		Map<String, Integer> maps = new HashMap<>();
		try {
			
			pstmt= con.prepareStatement("select mvname, count(*) from resistermv group by mvname");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				maps.put(rs.getString(1), rs.getInt(2));
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}
	
	
	public void 예약취소(int no) throws SQLException {
		pstmt = con.prepareStatement("delete from resistermv where no=?");
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
	}

}
