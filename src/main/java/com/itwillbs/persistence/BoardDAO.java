package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

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
	
	//특정 페이지에 있는 글정보를 확인 
	public List<BoardVO> listPage(int page) throws Exception;
	
	//페이징 처리하는 동작(Criteria 객체 사용)
	public List<BoardVO> listPageCri(Criteria cri) throws Exception;
	
	//DB 테이블에 있는 모든 글 개수 계산 후 리턴
	public int pageCount() throws Exception;
}
