package com.itwiilbs.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;
import com.itwillbs.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {
	
	//DB객체
	@Inject
	private BoardDAO bdao;
	
	//서비스객체
	@Inject
	private BoardService bService;
	
	@Test
	public void testDAO() throws Exception{
		System.out.println("TEST: boardDAO -> bdao");
	}
	
	@Test
	public void testServiceRegist() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("공지사항");
		vo.setContent("서비스테스트입니다.");
		vo.setWriter("관리자");
		
		bService.regist(vo);
		System.out.println("T: 서비스regist메서드 "+vo);
	}
}
