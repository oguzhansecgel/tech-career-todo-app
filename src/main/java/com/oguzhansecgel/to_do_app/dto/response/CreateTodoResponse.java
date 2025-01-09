package com.oguzhansecgel.to_do_app.dto.response;

import com.oguzhansecgel.to_do_app.model.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateTodoResponse {
    private int id;
    private String todoDescription;
    private LocalDate startedTime;
    private LocalDate finishTime;
    private Status status;

    public CreateTodoResponse() {
    }

    public CreateTodoResponse(int id, String todoDescription, LocalDate startedTime, LocalDate finishTime, Status status) {
        this.id = id;
        this.todoDescription = todoDescription;
        this.startedTime = startedTime;
        this.finishTime = finishTime;
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
