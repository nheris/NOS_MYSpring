package com.winter.app;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class DBConnectTest extends MyTest{

	@Autowired
	private DataSource dataSource; //my_context.xml 부모 객체?
	
	@Test //단정문(멤버변수)를 사용하기위해 선언
	public void connectTest() throws Exception {
		Connection con = dataSource.getConnection();
		
		//단정문 => null=false
		assertNotNull(con);//true, false
	}

}
