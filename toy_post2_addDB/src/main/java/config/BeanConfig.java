package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.presentation.PostController;

@Configuration
public class BeanConfig {
	
	//클래스 갯수만큼 저장
	@Bean
	public PostController postController( ) {
		return new PostController( );
	}

	
	
}
