package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.presentation.SpringForwardEx;

@Configuration
public class BeanConfig {
	
	//클래스 갯수만큼 저장
	@Bean
	public SpringForwardEx forwardss( ) {
		return new SpringForwardEx( );
	}
	
	
	
}
