package com.example.grb.todolist.service;

import com.example.grb.todolist.dto.ToDoListDTO;
import com.example.grb.todolist.entity.ToDoListEntity;
import com.example.grb.todolist.repository.ToDoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    @Autowired
    public ToDoRepositoy toDoRepositoy;

    public List<ToDoListDTO> listarTodos(){
        Sort sort = Sort.by("prioridades").descending().and(
            Sort.by("titulo").ascending());
        List<ToDoListEntity> listEntities = toDoRepositoy.findAll(sort);
        return listEntities.stream().map(ToDoListDTO :: new).toList();
    }

    public void inserir(ToDoListDTO toDoList){
        ToDoListEntity toDoListEntity = new ToDoListEntity(toDoList);
        toDoRepositoy.save(toDoListEntity);
    }

    public ToDoListDTO atualizar (ToDoListDTO toDoListDTO){
        ToDoListEntity toDoListEntity = new ToDoListEntity(toDoListDTO);
        return new ToDoListDTO(toDoRepositoy.save(toDoListEntity));
    }

    public void  excluir(Long id){
        ToDoListEntity toDoListEntity = toDoRepositoy.findById(id).get();
        toDoRepositoy.delete(toDoListEntity);
    }

}
