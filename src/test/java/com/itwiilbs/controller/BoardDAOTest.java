package com.itwiilbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;
import com.itwillbs.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	
	//DB객체
	@Inject
	private BoardDAO bdao;
	
	//@Test
	public void testDAO() throws Exception{
		System.out.println("TEST: boardDAO -> bdao");
	}
	
	//@Test
	public void testInsertBoard() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("공지사항");
		vo.setContent("공지안내입니다. 테스트입니다.");
		vo.setWriter("관리자");
		
		bdao.create(vo);
		System.out.println("T: 글쓰기메서드 "+vo);
	}
	
	// 특정 페이지의 글 정보 확인
	@Test
	public void testListPage() throws Exception{
		//페이지정보 1,3,5
		int page = 5;
		//주입받은 DAO 객체 사용 접근
		List<BoardVO> boardList = bdao.listPage(page);
		//리스트에 저장된 정보를 콘솔창에 출력
		for(BoardVO vo :boardList) {
			System.out.println(vo.getBno()+"------"+vo.getTitle());
		}
	}
	
	//Criteria 객체 사용 페이징 처리 테스트
	@Test
	public void testListCri() throws Exception{
		// 페이징 처리 객체생성
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPageSize(20);
		
		// dao 객체 사용해서 정보 가지고오기
		List<BoardVO> boardList = bdao.listPageCri(cri);
		
		// 콘솔창 출력 
		for(BoardVO vo:boardList) {
			System.out.println(vo.getBno()+" ------ "+vo.getTitle());
		}
	}
	
}
