package com.oguzhansecgel.to_do_app.controller;

import com.oguzhansecgel.to_do_app.dto.request.CreateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.request.UpdateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.response.CreateTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetAllListTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetByIdTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.UpdateTodoResponse;
import com.oguzhansecgel.to_do_app.exception.ApiResponse;
import org.springframework.http.HttpStatus;
import com.oguzhansecgel.to_do_app.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/find/by/status/done/jobs")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusDone() {
        List<GetAllListTodoResponse> response = todoService.getAllDoneTodos();
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/find/by/status/done/jobs");
    }

    @GetMapping("/find/by/status/completed/jobs")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusCompleted() {
        List<GetAllListTodoResponse> response = todoService.getAllCompletedTodos();
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/find/by/status/completed/jobs");
    }

    @GetMapping("/find/by/status/cancelled/jobs")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusCancelled() {
        List<GetAllListTodoResponse> response = todoService.getAllCancelledTodos();
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/find/by/status/cancelled/jobs");
    }

    @GetMapping("/find/by/status/pending/jobs")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusPending() {
        List<GetAllListTodoResponse> response = todoService.getAllPendingTodos();
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/find/by/status/pending/jobs");
    }

    @GetMapping("/find/by/status/notStarted/jobs")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoStatusNotStarted() {
        List<GetAllListTodoResponse> response = todoService.getAllNotStartedTodos();
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/find/by/status/notStarted/jobs");
    }

    @GetMapping("/list/all/todo")
    public ApiResponse<List<GetAllListTodoResponse>> getAllTodoList() {
        List<GetAllListTodoResponse> response = todoService.getAllListTodo();
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/list/all/todo");
    }

    @GetMapping("/get/by/{id}")
    public ApiResponse<Optional<GetByIdTodoResponse>> getByIdTodo(@PathVariable int id) {
        Optional<GetByIdTodoResponse> response = todoService.getById(id);
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/get/by/" + id);
    }

    @GetMapping("/by-started-time")
    public ApiResponse<List<GetAllListTodoResponse>> getTodosByStartedTime(@RequestParam LocalDate startedTime) {
        List<GetAllListTodoResponse> response = todoService.getTodosByStartedTime(startedTime);
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/by-started-time?startedTime=" + startedTime);
    }

    @GetMapping("/by-finish-time")
    public ApiResponse<List<GetAllListTodoResponse>> getTodosByFinishTime(@RequestParam LocalDate finishTime) {
        List<GetAllListTodoResponse> response = todoService.getTodosByFinishTime(finishTime);
        return new ApiResponse<>(true, "success", HttpStatus.OK.value(), response, "/api/v1/todo/by-finish-time?finishTime=" + finishTime);
    }

    @DeleteMapping("/delete/todo/{id}")
    public ApiResponse<Void> deleteTodo(@PathVariable int id) {
        todoService.deletedTodo(id);
        return new ApiResponse<>(true, "successfully deleted", HttpStatus.NO_CONTENT.value(), null,"/api/v1/todo/delete/todo/{id}");
    }

    @PostMapping("/create/todo")
    public ApiResponse<CreateTodoResponse> createTodo(@Valid @RequestBody CreateTodoRequest createTodoRequest) {
        CreateTodoResponse response = todoService.createTodo(createTodoRequest);

        return new ApiResponse<>(true, "successfully created", HttpStatus.CREATED.value(), response,"/api/v1/todo/create/todo");
    }

    @PutMapping("/update/todo/{id}")
    public ApiResponse<UpdateTodoResponse> updateTodo(@Valid @RequestBody UpdateTodoRequest updateTodoRequest, @PathVariable int id) {
        UpdateTodoResponse response = todoService.updateTodo(updateTodoRequest, id);
        return new ApiResponse<>(true, "successfully updated", HttpStatus.OK.value(), response,"/api/v1/todo/update/todo/{id}");
    }
}
