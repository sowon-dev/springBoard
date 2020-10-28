package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bdao;
	
	//글쓰기
	@Override
	public void regist(BoardVO vo) throws Exception {
		bdao.create(vo);
		System.out.println("S: regist메서드 "+vo);
	}

	//글 전체 목록
	@Override
	public List<BoardVO> listAll() throws Exception {
		List<BoardVO> boardList = bdao.listAll();
		System.out.println("S: listAll메서드 ");
		return boardList;
	}
	
	
}
