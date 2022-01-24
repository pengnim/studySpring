# 로그인아웃 기능
### With : java, jsp, spring framework, tomcat, mysql
### 간단한 설명
로그인, 로그아웃을 할 수 있습니다. 로그인을 하면 본인 정보 페이지를 볼 수 있고, 로그인을 하지 않은 상태에서 접근하면 로그인 페이지로 이동합니다.
- 2022.01.21 로그인기능 전체적인 흐름 작성
- 2022.01.24 로그인 정보를 받아와 DB를 확인하고 ID세션 생성, 로그인을 했을 경우에만 갈 수 있는 페이지 생성 기능 추가

#### 자세한 흐름은 uml, 흐름내용.txt를 참조해주세요
Link: [click]
[click]: https://github.com/pengnim/studySpring/tree/main/%EB%A1%9C%EA%B7%B8%EC%9D%B8%EA%B4%80%EB%A6%AC/docu

### 인터셉터 부분
```java
//MvcConfig.java일부
@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new 로그인확인자())
		        .addPathPatterns("/**") //모든 패턴 확인
		        .excludePathPatterns("/main") // 단 /main, /login은 제외
		        .excludePathPatterns("/login");		
		//Test 할 것 -로그인 없이 /member 요청하면 -> 로그인 창이 뜨며 로그인을 요청함  
	}
```
```
  //로그인확인자.java
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

```
