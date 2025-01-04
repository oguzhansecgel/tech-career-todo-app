package com.oguzhansecgel.to_do_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "to-do-list")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String todoDescription;

    @Enumerated(EnumType.STRING)
    private Status status;
    public Todo() {
    }

    public Todo(int id, String todoDescription, Status status) {
        this.id = id;
        this.todoDescription = todoDescription;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
