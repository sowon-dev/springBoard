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

	//글번호에 해당하는 게시글 상세 보기
	@Override
	public BoardVO readContent(Integer bno) throws Exception {
		BoardVO bvo = bdao.readContent(bno);
		return bvo;
	}

	//글 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		bdao.modify(vo);
	}

	//글 삭제
	@Override
	public void remove(Integer bno) throws Exception {
		bdao.delete(bno);
	}
	
}
