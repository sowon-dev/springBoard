package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	//글쓰기 (create)
	public void create(BoardVO vo) throws Exception;
	
	//글 전체 목록
	public List<BoardVO> listAll() throws Exception; 
	
	//글번호에 해당하는 게시글 상세 보기
	public BoardVO readContent(Integer bno) throws Exception;
	
	//글수정
	public void modify(BoardVO vo) throws Exception;
	
	//글삭제
	public void delete(Integer bno) throws Exception;
}
