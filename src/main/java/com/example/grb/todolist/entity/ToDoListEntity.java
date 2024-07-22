package com.example.grb.todolist.entity;

import com.example.grb.todolist.dto.ToDoListDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "GRB_LISTA_DE_AFAZERES")
public class ToDoListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = true)
    private String descricao;
    @Column(nullable = false)
    private int prioridade;
    @Column(nullable = false)
    private boolean feito;

    public ToDoListEntity(ToDoListDTO toDoList){
        BeanUtils.copyProperties(toDoList, this);
    }

    public ToDoListEntity(){

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoListEntity toDoList = (ToDoListEntity) o;
        return Objects.equals(id, toDoList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
