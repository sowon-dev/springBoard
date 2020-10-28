package com.itwiilbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger l = LoggerFactory.getLogger(BoardController.class);
	
	//서비스객체
	@Inject
	private BoardService service;
	
	/* 글쓰기 */
	// http://localhost:8088/board/register
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		l.info("C: register 겟 메서드 ");
	}
	
	//@RequestMapping(value = "/register" 
	// ,method = {RequestMethod.POST,RequestMethod.GET})
	// -> method 속성은 배열로 지정 가능(한번에 여러가지 속성값을 사용가능)
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo/* , Model model */, RedirectAttributes rttr) throws Exception{
		l.info("C: register 포스트 메서드 "+vo);
		service.regist(vo);
		
		//정상처리일때 -> 다음페이지로 정보전달
		//model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		
		//페이지 이동 to success.jsp
		//return "/board/success"; => 새로고침하는 순간 중복글쓰기발생
		return "redirect:/board/listAll";
	}
	
	//글 전체 목록
	// http://localhost:8088/board/listAll
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(@ModelAttribute("result") String result,Model model) throws Exception{
		l.info("C: listAll 겟 메서드");
		//model.addAttribute("msg", result); => 여기서 제어할 필요가 없다 registerPOST()에서 처리하면 된다.
		
		// 서비스 <-> DAO <-> mapper <-> DB
		List<BoardVO> boardList = service.listAll();
		System.out.println(boardList);
		// 글 정보를 가지고 오기
		model.addAttribute("boardList", boardList);
		// 뷰페이지로 이동
	}

}
