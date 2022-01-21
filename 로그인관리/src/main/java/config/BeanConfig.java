package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.simple.loginout.persentation.로그인아웃컨트롤러;
import com.stone.simple.loginout.service.로그인아웃업무자;

@Configuration
public class BeanConfig {
	@Bean
	public 로그인아웃업무자 로그인아웃업무자() {
		return new 로그인아웃업무자();
	}
	@Bean
	public 로그인아웃컨트롤러 로그인아웃컨트롤러() {
		return new 로그인아웃컨트롤러();
	}
}
