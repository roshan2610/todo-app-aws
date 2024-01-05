package com.example.ToDoApp.service;

import java.util.List;

import com.example.ToDoApp.entities.Todo;

public interface TodoService {

	public Todo SaveTodo(Todo todo);
	
	public List<Todo> getAllToDo();
	
	public Todo getTodoByid(int id);
	
	public void deleteTodo(int id);
	
	public Todo updateTodo(int id, Todo todo);
}
