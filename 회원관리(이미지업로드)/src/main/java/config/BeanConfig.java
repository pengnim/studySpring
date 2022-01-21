package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.stone.simple.member.persentation.회원컨트롤러;
import com.stone.simple.member.service.회원관리자;
import com.stone.simple.member.dataservice.회원DAO;
import com.stone.simple.member.persentation.프로필;
@Configuration
public class BeanConfig {

	@Bean
	public 회원컨트롤러 회원컨트롤러() {
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
	
	@Bean
	public 프로필 프로필() {
		return new 프로필();
	}
	
	//Multipart 필요
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	
}
