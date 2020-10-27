package com.itwiilbs.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void testDAO() throws Exception{
		System.out.println("TEST: boardDAO -> bdao");
	}
	
	@Test
	public void testInsertBoard() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("공지사항");
		vo.setContent("공지안내입니다. 테스트입니다.");
		vo.setWriter("관리자");
		
		bdao.create(vo);
		System.out.println("T: 글쓰기메서드 "+vo);
	}
}
