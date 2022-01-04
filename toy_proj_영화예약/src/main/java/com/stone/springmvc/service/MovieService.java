package com.stone.springmvc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stone.springmvc.common.Movie;
import com.stone.springmvc.common.Users;
import com.stone.springmvc.dataservice.MovieDAO;
import com.stone.springmvc.dataservice.UserDAO;
import com.stone.springmvc.dataservice.예약정보DAO;


public class MovieService {
	@Autowired
	예약정보DAO 예약dao = new 예약정보DAO();
	@Autowired
	UserDAO userdao = new UserDAO();
	@Autowired
	MovieDAO mvdao = new MovieDAO();
	
	public void 로그인하기() {
		
	}
	
	
	//일치하는 유저가 있으면 true, 없으면 false (간단하게하기)
	public boolean 유저확인하기(String id, String pw) throws SQLException {
		Users user = userdao.일치하는유저확인하기(id, pw);
		if(user == null) return false;
		else return true;
	}
	
	public List<Movie> 영화목록가져오기() throws SQLException{
		List<Movie> movies = mvdao.목록가져오기();
		return movies;
	}
	
	
	
}
