package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.dataservice.PostDAO;
import com.stone.springmvc.presentation.PostController;
import com.stone.springmvc.service.ManagePost;

@Configuration
public class BeanConfig {
	
	//클래스 갯수만큼 저장
	@Bean
	public PostController postController( ) {
		return new PostController( );
	}

	@Bean
	public ManagePost managePost() {
		return new ManagePost();
	}
	
	@Bean
	public PostDAO postDAO() {
		return new PostDAO();
	}
	
}
