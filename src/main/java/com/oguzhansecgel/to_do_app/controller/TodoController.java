package com.oguzhansecgel.to_do_app.controller;

import com.oguzhansecgel.to_do_app.dto.request.CreateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.request.UpdateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.response.CreateTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetAllListTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetByIdTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.UpdateTodoResponse;
import com.oguzhansecgel.to_do_app.result.ApiResponse;
import com.oguzhansecgel.to_do_app.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/find/by/status/done")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusDone()
    {
        List<GetAllListTodoResponse> response = todoService.getAllDoneTodos();
        return new ApiResponse<>(true,"success",response);
    }
    @GetMapping("/find/by/status/continue")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusContinue()
    {
        List<GetAllListTodoResponse> response = todoService.getAllContinueTodos();
        return new ApiResponse<>(true,"success",response);
    }
    @GetMapping("/list/all/todo")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoList()
    {
        List<GetAllListTodoResponse> response = todoService.getAllListTodo();
        return new ApiResponse<>(true,"success",response);
    }
    @GetMapping("/get/by/{id}")
    public ApiResponse<Optional<GetByIdTodoResponse>> getByIdTodo(@PathVariable int id)
    {
        Optional<GetByIdTodoResponse> response = todoService.getById(id);
        return new ApiResponse<>(true,"success",response);
    }

    @DeleteMapping("/delete/todo/{id}")
    public ApiResponse<Void> deleteTodo(@PathVariable int id)
    {
        todoService.deletedTodo(id);
        return new ApiResponse<>(true,"todo success deleted ",null);
    }
    @PostMapping("/create/todo")
    public ApiResponse<CreateTodoResponse> createTodo(@Valid @RequestBody CreateTodoRequest createTodoRequest)
    {
         CreateTodoResponse response = todoService.createTodo(createTodoRequest);
         return new ApiResponse<>(true,"successfully",response);
    }
    @PutMapping("/update/todo/{id}")
    public ApiResponse<UpdateTodoResponse> updateTodo(@Valid @RequestBody UpdateTodoRequest updateTodoRequest,@PathVariable int id)
    {
        UpdateTodoResponse response = todoService.updateTodo(updateTodoRequest, id);
        return new ApiResponse<>(true,"successfully",response);
    }
}
