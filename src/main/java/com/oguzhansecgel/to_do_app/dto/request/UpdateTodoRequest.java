package com.oguzhansecgel.to_do_app.dto.request;

import com.oguzhansecgel.to_do_app.model.Status;

public class UpdateTodoRequest {
    private String todoDescription;
    private Status status;

    public UpdateTodoRequest() {
    }

    public UpdateTodoRequest(String todoDescription, Status status) {
        this.todoDescription = todoDescription;
        this.status = status;
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