package com.pengnim.movie.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pengnim.movie.common.Movie;
import com.pengnim.movie.common.예약정보;
import com.pengnim.movie.dataservice.MovieDAO;
import com.pengnim.movie.dataservice.예약정보DAO;

@Service
public class MovieService {
	@Autowired
	private 예약정보DAO 예약dao = new 예약정보DAO();
	@Autowired
	private MovieDAO mvdao = new MovieDAO();
	

	public List<Movie> 영화목록가져오기() throws SQLException{
		List<Movie> movies = mvdao.목록가져오기();
		return movies;
	}
	
	public List<예약정보> 예약좌석정보가져오기(String mvname){
		List<예약정보>list = 예약dao.예약좌석정보가져오기(mvname);
		return list;
	}
	
	public List<예약정보> 예약좌석정보가져오기(){
		List<예약정보>list = 예약dao.예약좌석정보가져오기(null);
		return list;
	}
	
	public void 예약정보저장하기(String mvname, int[] seatList) {
		예약dao.예약정보입력(mvname, seatList);
	}
	
	public void 예약취소하기(List<Integer> no) throws SQLException {
		for(Integer n : no) {
			예약dao.예약취소(n);
		}
	}
	
	public void 좌석업데이트하기(Map<String,Integer> movies, List<Movie> 전체영화목록) throws SQLException {
		mvdao.잔여좌석업데이트(movies, 전체영화목록);
	}
	
	public Map<String, Integer> 영화별예약좌석정보가져오기(){
		return 예약dao.영화별예약좌석정보가져오기();
	}
	
	
	
}
