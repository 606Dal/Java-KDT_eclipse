package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.zerock.dto.TodoAddDTO;

public class TodoDAOTests {

	@Disabled
	@Test
	public void test1()throws Exception {
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 20; i++) {
			
			String now = TodoDAO.INSTANCE.makeConnection(); // 예외 던지는 거 필요함(throws Exception).
			System.out.println(now);
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		// null이 아닐거라고 확신할 때 테스트
		//Assertions.assertNotNull(TodoDAO.INSTANCE);
	}

	@Disabled //테스트가 되지 않음
	@Test
	public void testInsert() throws Exception {
		
		TodoAddDTO dto = new TodoAddDTO();
		dto.setTitle("Test 코드 Title");
		dto.setWriter("user00");
		
		TodoDAO.INSTANCE.insert(dto);
		
	}
	
	@Test
	public void testList() throws Exception {
	
		System.out.println(TodoDAO.INSTANCE.list(1));
	}
	
	
	
	
	
}
