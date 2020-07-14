package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqExamVO;
import com.simple.command.ReqVO;

@Controller		//component스캔이 해당 어노테이션을 읽어서 빈으로 생성
@RequestMapping("/request")
public class RequestController {

	// 모든 요청은 컨트롤러로 들어오게 되는데, 이 메서드를 실행시키고 싶다면
	//	/request/req_ex01 요청을 화면에서 호출합니다.
	// 폴더명을 맞춰서 요청경로를 기술하는 편이 좋습니다.
	// void형이라면 호출된 url과 동일한 페이지로 연결.

	//	//req_ex01화면 요청
	//	@RequestMapping("/req_ex01")
	//	public void req_ex01() {
	//	
	//	}

	//req_ex01화면 요청
	@RequestMapping("/req_ex01")
	public String req_ex01() {
		return "request/req_ex01";
	}

	//basic1 요청 처리 (Get요청만 처리 - method를 기술하지 않으면 자동으로 모두 처리)
	@RequestMapping(value="/basic1", method = RequestMethod.GET)
	public void basic1() {
		System.out.println("basic1 요청");
	}

	//basic2 요청 처리 (Post요청만 처리)
	@RequestMapping(value="/basic2", method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2 요청");
	}

	//basic3 요청 처리 (getMapping)
	@GetMapping("/basic3")
	public void basic3() {
		System.out.println("basic3 요청");
	}

	//basic4 요청 처리 (postMapping)
	@PostMapping("/basic4")
	public void basic4() {
		System.out.println("basic4 요청");
	}


	//	//동일 요청을 맵핑하나로 처리하고 싶다면 {} 경로를 묶어주면 됩니다.
	//	@RequestMapping({"/basic1","/basic2","/basic3"})
	//	public void view() {
	//		System.out.println("실행됨");
	//		
	//	}
	
	
	// -----------------요청 파라미터 받기-----------------
	//req_ex02 화면처리
	
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "request/req_ex02";		//"보여줄 화면"
	}
	
//	//param1 요청 처리
//	@RequestMapping(value="/param1", method = RequestMethod.POST)
//	public String param1(HttpServletRequest request) {
//		
//		String id = request.getParameter("id");
//		System.out.println(id);
//		
//		return "request/req_ex02_result";
//	}
	
	
	
	
	
	//2nd
	@RequestMapping("/param1")
	public String param1(@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							@RequestParam("name") String name,
							@RequestParam("age") String age,
							@RequestParam(value="inter", required = false, defaultValue = "") ArrayList<String> inter) {
		System.out.println(id);
		//필수가 아닌 파라미터는 required = false속성을 지정하면 됩니다.
		//필수가 아닌 파라미터일 경우 null값을 지정하게 되는데
		//기본값의 설정으로 defaultValue옵션을 사용하면 됩니다.
		System.out.println(inter.toString());
		
		return "request/req_ex02_result";
	}
	
	
	
	
	
	
	
//	//3rd
//	@RequestMapping("/param1")
//	public String param1(ReqVO vo) {
//		
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());
//		System.out.println(vo.getName());
//		System.out.println(vo.getAge());
//		System.out.println(vo.getInter().toString());
//		
//		return "request/req_ex02_result";
//	}
	
	
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
		
	}
	
	
	@RequestMapping("/login")
	public String login(ReqExamVO vo) {
		String id = vo.getId();
		String pw = vo.getPw();
		
		if(id.equals("abc123") && pw.equals("xxx123")) {
			return "request/req_quiz01_ok";
		} else {
			return "request/req_quiz01_no";
		}
	}
	
	




}
