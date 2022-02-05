package env;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class 로그인확인자 extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		//세션이있는가, 없는가
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("id") != null)
		{
			return true;
		}
		else {
			response.sendRedirect("/login");
			return false;
		}
	
	}
}
