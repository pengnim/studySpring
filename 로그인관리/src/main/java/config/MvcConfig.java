package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import env.로그인확인자;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.stone")
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/",".jsp");
	
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new 로그인확인자())
		        .addPathPatterns("/**") //모든 패턴 확인
		        .excludePathPatterns("/main") // 단 /main, /login은 제외
		        .excludePathPatterns("/login");		
		//Test 할 것 -로그인 없이 /member 요청하면 -> 로그인 창이 뜨며 로그인을 요청함  
		
	}
	
}
