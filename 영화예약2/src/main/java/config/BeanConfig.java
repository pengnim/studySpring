package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pengnim.movie.dataservice.MovieDAO;
import com.pengnim.movie.dataservice.예약정보DAO;
import com.pengnim.movie.presentation.MovieController;
import com.pengnim.movie.service.MovieService;

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
