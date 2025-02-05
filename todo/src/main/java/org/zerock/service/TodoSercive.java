package org.zerock.service;

import java.util.List;

import org.zerock.dao.TodoDAO;
import org.zerock.dto.TodoAddDTO;
import org.zerock.dto.TodoListDTO;

//원래는 트랜젝션 처리하고 해야 함.
public enum TodoSercive {

	INSTANCE;
	
	// 고객이 알아보기 쉬워야 해서 insert 대신 add 같은 거 사용함.
	public void add(TodoAddDTO dto)throws Exception {
		
		TodoDAO.INSTANCE.insert(dto);
		
	}
	
	public List<TodoListDTO> getList(int page) throws Exception {
		return TodoDAO.INSTANCE.list(page);
	}
	
}
