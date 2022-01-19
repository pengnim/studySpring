package com.stone.simple.member.persentation;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.stone.simple.member.common.Member;
import com.stone.simple.member.service.회원관리자;

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
	// 실행하면 오류가 뜰건데 탐색기에 가서 해당하는 위치에 upload폴더를 만들어준다
	@PostMapping("/member")
	public ModelAndView 회원등록하다(Member 새회원, HttpServletRequest request) {

		//		 파일에 저장함(대용량 가능), 경로 고정된 점 아쉬움
		//		  저장처리를 컨트롤이 직접한다는게 아쉬움 -> DAO로 넘기기
		//		  스레드 걸어서 파일처리해서 빨리 이 부분을 지나쳐야함.


		try {
			// 서버의 경로을 실시간으로 알아오기
			String  절대경로 =request.getSession().getServletContext().getRealPath("/");
			System.out.println(절대경로);
			
			//경로에 파일 저장
			MultipartFile 프로필파일 =새회원.getProfile();
			String 파일명= 프로필파일.getOriginalFilename();			
			File 파일=new File(절대경로+"\\"+파일명);
			프로필파일.transferTo(파일);//파일 저장
		}
		catch(Exception ex) {ex.printStackTrace();}

		// 회원관리자.회원등록하다(새회원);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", 새회원.getName());
		mv.setViewName("회원등록알림창");
		return mv;
	}

}
