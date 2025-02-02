package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	//DB접근을 위해 필요한 객체
	@Inject
	private SqlSession session;
	
	//Mapper의 위치정보를 저장
	private static final String namespace = "com.itwillbs.mapper.BoardMapper";
	
	//글쓰기
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
		System.out.println("DAO: 글쓰기메서드");
	}

	//글 전체 목록
	@Override
	public List<BoardVO> listAll() throws Exception {
		System.out.println("DAO: 글전체목록 메서드");
		//sqlSession 객체 사용하여 Mapper 호출	
		return session.selectList(namespace+".listAll");
	}

	//글번호에 해당하는 게시글 상세 보기
	@Override
	public BoardVO readContent(Integer bno) throws Exception {
		//sqlSession 객체 사용하여 Mapper 호출	
		return session.selectOne(namespace+".readContent", bno);
	}

	//글 수정
	@Override
	public void modify(BoardVO vo) throws Exception {
		System.out.println("DAO: bno는?"+vo.getBno());
		session.update(namespace+".modify", vo);
	}

	//글 삭제
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}

	//페이징
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		//페이지가 0인 경우 1로 바꿔서 처리
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1)*10;
		return session.selectList(namespace+".listPage", page);
	}
	
	//페이징 처리하는 동작(Criteria 객체 사용)
	@Override
	public List<BoardVO> listPageCri(Criteria cri) throws Exception {
		System.out.println("DAO: listPageCri 호출");
		return session.selectList(namespace+".listPageCri", cri);
	}

	//DB 테이블에 있는 모든 글 개수 계산 후 리턴
	@Override
	public int pageCount() throws Exception{
		return session.selectOne(namespace+".pageCount");
	}
	

	
	
}
