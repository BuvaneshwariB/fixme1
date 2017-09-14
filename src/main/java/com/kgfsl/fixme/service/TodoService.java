package com.kgfsl.fixme.service;

import com.kgfsl.fixme.model.Todo;
import java.util.List;

public interface TodoService {
	public List<Todo> findAll();
	public void saveTodo(Todo Todo);
    public void updateTodo(Todo Todo,Long id);
	public Todo findOne(long id);
	public void delete(Long todoId);	
}