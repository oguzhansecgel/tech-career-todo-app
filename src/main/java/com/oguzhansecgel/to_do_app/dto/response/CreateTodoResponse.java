package com.oguzhansecgel.to_do_app.dto.response;

import com.oguzhansecgel.to_do_app.model.Status;

public class CreateTodoResponse {
    private int id;
    private String todoDescription;

    private Status status;

    public CreateTodoResponse() {
    }

    public CreateTodoResponse(int id, String todoDescription, Status status) {
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
