package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.simple.member.persentation.Id중복검사컨트롤러;

@Configuration
public class BeanConfig {

	@Bean
	public Id중복검사컨트롤러 id중복검사컨트롤러() {
		return new Id중복검사컨트롤러();
	}
	
}
