package com.example.ToDoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoApp.entities.Todo;

public interface ToDoRepo extends JpaRepository<Todo,Integer>{
	

}
