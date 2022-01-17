package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stone.simple.member.persentation.회원컨트롤러;
import com.stone.simple.member.service.회원관리자;
import com.stone.simple.member.dataservice.회원DAO;

@Configuration
public class BeanConfig {

	@Bean
	public 회원컨트롤러 id중복검사컨트롤러() {
		return new 회원컨트롤러();
	}
	@Bean
	public 회원관리자 회원관리자() {
		return new 회원관리자();
	}
	@Bean
	public 회원DAO 회원DAO() {
		return new 회원DAO();
	}
	
}
