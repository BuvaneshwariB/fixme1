package com.kgfsl.fixme.service;

import com.kgfsl.fixme.model.Todo;
import com.kgfsl.fixme.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	 
	
//@Transactional
	public List<Todo> findAll(){
		return todoRepository.findAll();
	}
	
	public void saveTodo(Todo Todo){
		todoRepository.save(Todo);
	}
	public Todo findOne(long id){
		return todoRepository.findOne(id);
	}

	@Override
	public void updateTodo(Todo todo,Long id) {
		todo.setId(id);
		todoRepository.saveAndFlush(todo);
	}

	@Override
	public void delete(Long todoId) {
		todoRepository.delete(todoId);
	}
	




}




