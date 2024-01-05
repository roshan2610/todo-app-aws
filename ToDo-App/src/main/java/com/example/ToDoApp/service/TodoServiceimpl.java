package com.example.ToDoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoApp.entities.Todo;
import com.example.ToDoApp.exception.ResourceNotFoundException;
import com.example.ToDoApp.repository.ToDoRepo;

@Service

public class TodoServiceimpl implements TodoService{

	@Autowired
	private ToDoRepo todoRepo;

	@Override
	public Todo SaveTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepo.save(todo);
	}

	@Override
	public List<Todo> getAllToDo() {
		// TODO Auto-generated method stub
		return todoRepo.findAll();
	}

	@Override
	public Todo getTodoByid(int id) {
		// TODO Auto-generated method stub
		return todoRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("ToDo ID Not Found with id = +id"));
	}

	@Override
	public void deleteTodo(int id) {
		// TODO Auto-generated method stub
		Todo todo = todoRepo.findById(id)				
				.orElseThrow(()-> new ResourceNotFoundException("ToDo ID Not Found with id = +id"));

		todoRepo.delete(todo);
		
	}

	
	@Override
	public Todo updateTodo(int id, Todo todo) {
		// TODO Auto-generated method stub
		Todo oldTodo = todoRepo.findById(id)				
				.orElseThrow(()-> new ResourceNotFoundException("ToDo ID Not Found with id = +id"));

		oldTodo.setTitle(todo.getTitle());
		oldTodo.setDescription(todo.getDescription());
		oldTodo.setStatus(todo.getStatus());
		oldTodo.setUsername(todo.getUsername());

		return todoRepo.save(oldTodo);
	}
	
	

}
