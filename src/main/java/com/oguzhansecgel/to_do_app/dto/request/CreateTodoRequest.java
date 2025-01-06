package com.oguzhansecgel.to_do_app.dto.request;

import com.oguzhansecgel.to_do_app.model.Status;
import jakarta.validation.constraints.NotEmpty;

public class CreateTodoRequest {

    @NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}")
    private String todoDescription;
    private Status status;

    public CreateTodoRequest() {
    }

    public CreateTodoRequest(String todoDescription, Status status) {
        this.todoDescription = todoDescription;
        this.status = status;
    }

    public @NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}") String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(@NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}") String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
