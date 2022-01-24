package env;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class 로그인확인자 extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			                 HttpServletResponse response, 
			                 Object handler)throws Exception {
		//요청이  컨트롤러 닿기전이다.
		//이때 로그인 여부를 확인하자
		HttpSession session = request.getSession(false);
		boolean 로그인중 =false;
		//만약 로그인되었다면
		if(session!=null&& session.getAttribute("id")!=null) {
			로그인중=true;
		}
		//로그인이 안되어 있었다면
		if(로그인중!=true) {
			
			//로그인으로  리다이렉트
			response.sendRedirect("/login");
			return false;
		}
		//true 종료면  요청이  컨트롤러에 도달한다.
		return true;
	}
}
