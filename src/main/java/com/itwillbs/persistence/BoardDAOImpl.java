package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

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
	
	
	
	
	
	
	
}
