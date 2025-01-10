package com.oguzhansecgel.to_do_app.service.impl;

import com.oguzhansecgel.to_do_app.dto.request.CreateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.request.UpdateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.response.CreateTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetAllListTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetByIdTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.UpdateTodoResponse;
import com.oguzhansecgel.to_do_app.mapper.TodoMapping;
import com.oguzhansecgel.to_do_app.model.Todo;
import com.oguzhansecgel.to_do_app.repository.TodoRepository;
import com.oguzhansecgel.to_do_app.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;
    private final Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public CreateTodoResponse createTodo(CreateTodoRequest createTodoRequest) {
        Todo todo = TodoMapping.INSTANCE.createTodo(createTodoRequest);
        Todo savedTodo = todoRepository.save(todo);
        log.info("Todo created: " + savedTodo);
        return new CreateTodoResponse(savedTodo.getId(), savedTodo.getTodoDescription(),savedTodo.getStartedTime(),savedTodo.getFinishTime(),savedTodo.getStatus());
    }

    @Override
    public UpdateTodoResponse updateTodo(UpdateTodoRequest updateTodoRequest, int id) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        Todo todo = TodoMapping.INSTANCE.updateTodo(updateTodoRequest, existingTodo);
        Todo savedTodo = todoRepository.save(todo);
        log.info("Todo updated: " + savedTodo);
        return new UpdateTodoResponse(savedTodo.getId(), savedTodo.getTodoDescription(),savedTodo.getStartedTime(),savedTodo.getFinishTime(),savedTodo.getStatus());
    }

    @Override
    public void deletedTodo(int id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not Found"));

        todoRepository.delete(todo);
    }

    @Override
    public List<GetAllListTodoResponse> getAllListTodo() {
        List<Todo> todos = todoRepository.findAll();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public Optional<GetByIdTodoResponse> getById(int id) {
        Optional<Todo> existingTodo = todoRepository.findById(id);
        return existingTodo.map(TodoMapping.INSTANCE::getByIdTodoResponse);
    }

    @Override
    public List<GetAllListTodoResponse> getAllDoneTodos() {
        List<Todo> todos = todoRepository.findAllDoneTodos();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public List<GetAllListTodoResponse> getAllInProgressTodos() {
        List<Todo> todos = todoRepository.findAllInProgressTodos();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public List<GetAllListTodoResponse> getAllNotStartedTodos() {
        List<Todo> todos = todoRepository.findAllNotStartedTodos();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public List<GetAllListTodoResponse> getAllPendingTodos() {
        List<Todo> todos = todoRepository.findAllPendingTodos();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public List<GetAllListTodoResponse> getAllCancelledTodos() {
        List<Todo> todos = todoRepository.findAllCancelledTodos();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public List<GetAllListTodoResponse> getTodosByStartedTime(LocalDate startedTime) {
        List<Todo> todos = todoRepository.findByStartedTime(startedTime);
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }

    @Override
    public List<GetAllListTodoResponse> getTodosByFinishTime(LocalDate finishTime) {
        List<Todo> todos = todoRepository.findByFinishTime(finishTime);
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }
}
