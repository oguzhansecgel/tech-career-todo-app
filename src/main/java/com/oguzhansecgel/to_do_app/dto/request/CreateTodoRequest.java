package com.oguzhansecgel.to_do_app.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class CreateTodoRequest {

    @NotEmpty(message = "{todo.description.validation.constraints.NotNull.message}")
    private String todoDescription;
    private LocalDate startedTime;
    private LocalDate  finishTime;

    public CreateTodoRequest() {
    }

    public CreateTodoRequest(String todoDescription, LocalDate startedTime, LocalDate finishTime) {
        this.todoDescription = todoDescription;
        this.startedTime = startedTime;
        this.finishTime = finishTime;
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


}
