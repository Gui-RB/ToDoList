package com.example.grb.todolist.controller;

import com.example.grb.todolist.dto.ToDoListDTO;
import com.example.grb.todolist.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoListController {

    @Autowired
    public ToDoListService toDoListService;

    @GetMapping
    List<ToDoListDTO> listarTodos(){
        return  toDoListService.listarTodos();
    }

    @PostMapping
    public void  inserir(@RequestBody ToDoListDTO toDoListDTO){
      toDoListService.inserir(toDoListDTO);
    }

    @PutMapping
    public ToDoListDTO atualizar(@RequestBody ToDoListDTO toDoListDTO){
        return toDoListService.atualizar(toDoListDTO);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void>excluir(@PathVariable("id") Long id){
        toDoListService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
