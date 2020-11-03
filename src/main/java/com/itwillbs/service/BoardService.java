package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardService {
	//글쓰기
	public void regist(BoardVO vo) throws Exception;
	
	//글 전체 목록
	public List<BoardVO> listAll() throws Exception;
	
	//글번호에 해당하는 게시글 상세 보기
	//public BoardVO readContent(int bno) throws Exception;
	public BoardVO readContent(Integer bno) throws Exception;
	
	//글 수정
	public void modify(BoardVO vo) throws Exception;
	
	//글 삭제
	public void remove(Integer bno) throws Exception;
	
	
	
}
