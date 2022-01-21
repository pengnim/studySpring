package com.stone.simple.member.persentation;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.service.회원관리자;

import net.iharder.Base64;

@Controller
public class 회원컨트롤러 {

	@Autowired
	회원관리자 회원관리자;

	// RequestMapping : get, post 둘다 가능
	// GetMapping : get만 가능
	// PostMapping : post만 가능
	// localhost:8080/id 형식으로 들어와야함 -> localhost:8080/simple X
	// root에서 바로 부를경우 server에 path "/"로 설정
	@GetMapping("/id")
	public String id중복확인준비하다() {
		return "아이디중복확인창";
	}

	@PostMapping("/id")
	public ModelAndView id중복확인하다(String id) {
		boolean 아이디사용가능여부 = 회원관리자.아이디사용가능여부를판단하다(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("아이디중복확인창");
		mv.addObject("id", id);
		mv.addObject("usable", 아이디사용가능여부);
		return mv;
	}

	// 업로드에서 multipart가 있는 경우 @ModelAttribute사용해야함
	//Member 새회원, HttpServletRequest request
	@PostMapping("/member")
	public ModelAndView 회원등록하다(Member 새회원, HttpServletRequest request) {

		//		 파일에 저장함(대용량 가능), 경로 고정된 점 아쉬움
		//		  저장처리를 컨트롤이 직접한다는게 아쉬움 -> DAO로 넘기기
		//		  스레드 걸어서 파일처리해서 빨리 이 부분을 지나쳐야함.
		// 실행하면 오류가 뜰건데 탐색기에 가서 해당하는 위치에 upload폴더를 만들어준다
//		pom.xml설정 필요
//
//		try {
//			// 서버의 경로을 실시간으로 알아오기
//			String  절대경로 =request.getSession().getServletContext().getRealPath("/");
//			System.out.println(절대경로);
//			
//			//경로에 파일 저장
//			MultipartFile 프로필파일 =새회원.getProfileFile();
//			String 파일명= 프로필파일.getOriginalFilename();			
//			File 파일=new File(절대경로+"\\"+파일명);
//			프로필파일.transferTo(파일);//파일 저장
//		}
//		catch(Exception ex) {ex.printStackTrace();}

		회원관리자.회원등록하다(새회원);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", 새회원.getName());
		mv.setViewName("회원등록알림창");
		return mv;
	}
	
	//만약 getmapping이 GetMaipping("/member/{no})라면 
	//@PathVariable("no") int zzz 해야함 근데 int no라면 굳이 안써도됨
	@GetMapping("/member/{no}")
	public ModelAndView 회원조회하다(@PathVariable int no) {
		Member 찾은회원 = 회원관리자.회원정보를조회하다(no);
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", 찾은회원);
		mv.setViewName("회원정보창");
		return mv;
	}
	
	//html에서 바로 사진 뿌려주기
	//기존 : 요청->프로필사진요청->컨트롤러->응답->응답 순
	//지금 : 요청->컨트롤러에서 사진세팅->응답
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

}
