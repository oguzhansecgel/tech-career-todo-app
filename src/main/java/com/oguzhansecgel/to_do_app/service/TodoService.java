package com.oguzhansecgel.to_do_app.service;

import com.oguzhansecgel.to_do_app.dto.request.CreateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.request.UpdateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.response.CreateTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetAllListTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetByIdTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.UpdateTodoResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    CreateTodoResponse createTodo(CreateTodoRequest createTodoRequest);
    UpdateTodoResponse updateTodo(UpdateTodoRequest updateTodoRequest, int id);
    void deletedTodo(int id);
    List<GetAllListTodoResponse> getAllListTodo();
    Optional<GetByIdTodoResponse> getById(int id);
    List<GetAllListTodoResponse> getAllDoneTodos();
    List<GetAllListTodoResponse> getAllInProgressTodos();
    List<GetAllListTodoResponse> getAllNotStartedTodos();
    List<GetAllListTodoResponse> getAllPendingTodos();
    List<GetAllListTodoResponse> getAllCancelledTodos();
    List<GetAllListTodoResponse> getTodosByStartedTime(LocalDate startedTime);
    List<GetAllListTodoResponse> getTodosByFinishTime(LocalDate finishTime);
}
