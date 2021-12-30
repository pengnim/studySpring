package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.springmvc.presentation.PreparePost;
import com.stone.springmvc.presentation.PrintPost;
import com.stone.springmvc.presentation.ResisterPost;

@Configuration
public class BeanConfig {
	
	//클래스 갯수만큼 저장
	@Bean
	public ResisterPost rp( ) {
		return new ResisterPost( );
	}
	@Bean
	public PrintPost pp( ) {
		return new PrintPost( );
	}
	@Bean
	public PreparePost prep( ) {
		return new PreparePost( );
	}

	
	
}
