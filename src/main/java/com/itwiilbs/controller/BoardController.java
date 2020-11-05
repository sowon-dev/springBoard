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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageMaker;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
//@SessionAttributes() : 컨트롤러의 정보를 저장하는 어노테이션
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
		System.out.println("C: register 포스트 메서드 "+vo);
		service.regist(vo);
		
		//정상처리일때 -> 다음페이지로 정보전달
		//model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		
		//글전체목록출력시 등록한 글에만 팝업창출력
		rttr.addFlashAttribute("isRegist", "true");
		
		//페이지 이동 to success.jsp
		//return "/board/success"; => 새로고침하는 순간 중복글쓰기발생
		return "redirect:/board/listAll";
	}
	
	//글 전체 목록
	// http://localhost:8088/board/listAll
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(@ModelAttribute("result") String result,Model model) throws Exception{
		//model.addAttribute("msg", result); => 여기서 제어할 필요가 없다 registerPOST()에서 처리하면 된다.
		
		// 서비스 <-> DAO <-> mapper <-> DB
		List<BoardVO> boardList = service.listAll();
		l.info("C: listAll 겟 메서드"+boardList);
		// 글 정보를 가지고 오기
		model.addAttribute("boardList", boardList);
		// 뷰페이지로 이동
	}

	//글번호에 해당하는 게시글 상세 보기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	//@ModelAttribute 와 @RequestParam 둘 다 동일한 결과
	//public void readGET(@ModelAttribute("bno") int bno) throws Exception{ //0출력
	public void readGET(@RequestParam("bno") int bno, Model model) throws Exception{ //0출력
		l.info("C: read 겟 메서드, 글번호: "+(bno*0));
		//서비스객체 : 해당 글번호를 사용하여 글 정보 가지고오기
		model.addAttribute("bvo", service.readContent(bno));
	}
	
	//글번호에 해당하는 게시글 상세 보기(incl Paging)
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPageGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{ //0출력
		l.info("C: readPage 겟 글번호: "+(bno*0));
		l.info("c: readPage 겟 cri"+cri);
		//서비스객체 : 해당 글번호를 사용하여 글 정보 가지고오기
		model.addAttribute("bvo", service.readContent(bno));
	}
	
	//글 수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception{
		l.info("C: modify 겟 메서드 파라미터 : "+bno);
		model.addAttribute("bvo", service.readContent(bno));
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo,RedirectAttributes rttr) throws Exception{
		l.info("C: modify 포스트 메서드 파라미터 : "+vo);
		service.modify(vo);
		rttr.addFlashAttribute("result", "up-ok");
		return "redirect:/board/listAll";
	}

	//글 수정(incl Paging)
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPageGET(Criteria cri, @RequestParam("bno") int bno, Model model) throws Exception{
		l.info("C: modifyPage 겟 bno파라미터 : "+bno);
		model.addAttribute("bvo", service.readContent(bno));
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(Criteria cri, BoardVO vo, RedirectAttributes rttr) throws Exception{
		l.info("C: modifyPage 포스트 bno파라미터 : "+vo);
		service.modify(vo);
		rttr.addFlashAttribute("result", "up-ok");
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("pageSize", cri.getPageSize());
		return "redirect:/board/listPage";
	}
	
	
	//글삭제
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePOST(@RequestParam("bno") int bno,RedirectAttributes rttr) throws Exception{
		l.info("C: remove 포스트 메서드");
		// 글번호 저장
		// 서비스객체 사용하여 글 삭제
		service.remove(bno);
		// 삭제정보 저장해서 이동
		// 글삭제 후 얼럿창 -> 글목록으로 페이지 이동
		rttr.addFlashAttribute("result", "delete-ok");
		return "redirect:/board/listAll";
	}
	
	//글삭제(incl Paging)
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePagePOST(Criteria cri, @RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		l.info("C: removePage 포스트");
		// 글번호 저장
		// 서비스객체 사용하여 글 삭제
		service.remove(bno);
		// 삭제정보 저장해서 이동
		// 글삭제 후 얼럿창 -> 글목록으로 페이지 이동
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("pageSize", cri.getPageSize());
		rttr.addFlashAttribute("result", "delete-ok");
		return "redirect:/board/listPage";
	}
	
	//페이징처리한 글목록
	//http://localhost:8088/board/listCri
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listCriGET(Criteria cri, Model model) throws Exception{
		l.info("C: listCri 겟 호출" + cri);
		model.addAttribute("boardList", service.listCri(cri));
	}
	
	//글목록보기(PageMaker객체 사용)
	// http://localhost:8088/board/listPage
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPageGET(Criteria cri, Model model) throws Exception{
		l.info("C: cri는 "+cri);
		model.addAttribute("boardList", service.listCri(cri));
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.pageCount()); //DB의 전체ROW수 입력
		
		// 뷰페이지로 전달 
		model.addAttribute("pm", pm);
	}
	
	
	
}
