package com.example.grb.todolist.repository;

import com.example.grb.todolist.entity.ToDoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepositoy extends JpaRepository<ToDoListEntity, Long > {
}
