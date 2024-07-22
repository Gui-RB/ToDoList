package com.example.grb.todolist.dto;

import com.example.grb.todolist.entity.ToDoListEntity;
import org.springframework.beans.BeanUtils;

public class ToDoListDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private int prioridade;
    private boolean feito;

    public ToDoListDTO(ToDoListEntity list){
        BeanUtils.copyProperties(list,this);
    }

    public ToDoListDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isFeito() {
        return feito;
    }

    public void setFeito(boolean feito) {
        this.feito = feito;
    }
}
