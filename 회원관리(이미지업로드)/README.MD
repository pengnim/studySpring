# 회원가입하기(3계층)
### With : java, jsp, spring framework, tomcat, mysql
### 간단한 설명
회원정보를 입력하면 데이터베이스에 저장되고, 조회 요청을 하면 회원조회를 할 수 있습니다.
- 2022.01.13 간단한 회원가입기능
- 2022.01.18 회원가입창 프로필사진 업로드 기능 추가하기
- 2022.01.19 프로필사진 다운로드 기능 추가하기 (현재는 주석으로 남아있음)
- 2022.01.20 회원조회기능 추가(프로필 사진은 출력하지않고 다른 정보들만 출력)
- 2022.01.21 데이터 베이스에 이미지를 저장하고, DB에서 이미지를 가져와 회원조회기능에 프로필 사진도 출력

#### 자세한 흐름은 uml을 참조해주세요
Link: [UML]

### 이미지를 출력하는 2가지 방법
```java
 
	//요청->컨트롤러에서 사진세팅->응답
  	//view에 적어주기 : <img src="data:/png;base64,${profileString }" width="200" height="300"/>
	@GetMapping("/member2/{no}")
	public ModelAndView 회원조회하다2(@PathVariable int no) {
		Member 찾은회원 = 회원관리자.회원정보를조회하다(no);
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", 찾은회원);
		//base64별도 라이브러리 사용해야함. 바이트코드를 스트링으로 인코딩해줌. pom.xml에서 의존성주입
		String 프로필사진문자열 = Base64.encodeBytes(찾은회원.getProfile());
		mv.addObject("profileString",프로필사진문자열);
		mv.setViewName("회원정보창2");
		return mv;
	}
```
```java
  //요청->프로필사진요청->컨트롤러->응답->응답 => 요청을 한번 더 하는 상황 발생
  //조회view에 적어주기 : <img src="/profile/${member.no}" width="200" height="300"/>

  //컨트롤러
  @GetMapping("/profile/{회원번호}")
	ModelAndView 프로필사진을주다(@PathVariable("회원번호") int no) {
		
		Member 회원 = 회원관리자.회원정보를조회하다(no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile");
		mv.addObject("profile", 회원.getProfile());
		return mv;
	}
  
    //profile.jsp
  <%@ page trimDirectiveWhitespaces="true" %>
<%
   //응답(response)객체에 이미지 전송하도록 설정
   byte[] 프로필=(byte[])request.getAttribute("profile"); 
   response.setContentType("image/png");
   ServletOutputStream 배송자= response.getOutputStream();
      배송자.write(프로필);
%>
```

[UML]: https://github.com/pengnim/studySpring/tree/main/%ED%9A%8C%EC%9B%90%EA%B4%80%EB%A6%AC(%EC%9D%B4%EB%AF%B8%EC%A7%80%EC%97%85%EB%A1%9C%EB%93%9C)/docu
### 간단한 회원가입기능
![simplemember](https://user-images.githubusercontent.com/90567066/150474392-80746a91-4e74-4773-bd77-322513415d69.gif)
### 공백을 입력하면 alert
![err](https://user-images.githubusercontent.com/90567066/150474412-ca9d5207-53e2-4cd8-acda-faac1d502e44.gif)
### 회원조회하면 데이터베이스에서 이미지를 가져와 출력
![memberimg](https://user-images.githubusercontent.com/90567066/150474445-4c62f4ce-2e2d-474d-bdd8-26a184716a45.gif)
