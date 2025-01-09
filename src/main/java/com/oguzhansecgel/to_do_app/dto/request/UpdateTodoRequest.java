package com.oguzhansecgel.to_do_app.dto.request;

import com.oguzhansecgel.to_do_app.model.Status;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UpdateTodoRequest {
    @NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}")
    private String todoDescription;
    private LocalDate startedTime;
    private LocalDate  finishTime;
    private Status status;

    public UpdateTodoRequest() {
    }

    public UpdateTodoRequest(String todoDescription, LocalDate startedTime, LocalDate finishTime, Status status) {
        this.todoDescription = todoDescription;
        this.startedTime = startedTime;
        this.finishTime = finishTime;
        this.status = status;
    }

    public @NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}") String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(@NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}") String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public LocalDate getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(LocalDate startedTime) {
        this.startedTime = startedTime;
    }

    public LocalDate getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDate finishTime) {
        this.finishTime = finishTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
