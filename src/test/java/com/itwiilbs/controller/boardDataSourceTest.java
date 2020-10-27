package com.itwiilbs.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class boardDataSourceTest {
	//datasource객체 생성(DI)
	//@Inject
	private DataSource ds;
	
	@Test
	public void testDataSource() throws Exception{
		System.out.println("ds 테스트 "+ds); //ds의 객체생성이 안되면 null로 출력됨
		try (Connection con = ds.getConnection()){
			System.out.println("Conntect확인 " + con);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
