package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.dataservice.MovieDAO;
import com.stone.springmvc.dataservice.예약정보DAO;
import com.stone.springmvc.presentation.MovieController;
import com.stone.springmvc.service.MovieService;

@Configuration
public class BeanConfig {

	@Bean
	public MovieController movieController() {
		return new MovieController();
	}
	
	
	@Bean
	public MovieService movieService() {
		return new MovieService();
	}


	@Bean
	public 예약정보DAO 예약DAO() {
		return new 예약정보DAO();
	}
	
	@Bean
	public MovieDAO movieDAO() {
		return new MovieDAO();
	}
	
	
	
}
