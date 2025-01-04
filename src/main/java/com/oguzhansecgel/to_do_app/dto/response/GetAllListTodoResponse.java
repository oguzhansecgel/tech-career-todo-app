package com.oguzhansecgel.to_do_app.dto.response;

public class GetAllListTodoResponse {

    private int id;
    private String todoDescription;

    private String status;

    public GetAllListTodoResponse() {
    }

    public GetAllListTodoResponse(int id, String todoDescription, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

