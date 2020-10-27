package com.itwillbs.persistence;

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
		System.out.println("DAO 글쓰기메서드");
	}
	
}
