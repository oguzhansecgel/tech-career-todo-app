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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public CreateTodoResponse createTodo(CreateTodoRequest createTodoRequest) {
        Todo todo = TodoMapping.INSTANCE.createTodo(createTodoRequest);
        Todo savedTodo = todoRepository.save(todo);
        return new CreateTodoResponse(savedTodo.getId(), savedTodo.getTodoDescription(),savedTodo.getStatus());
    }

    @Override
    public UpdateTodoResponse updateTodo(UpdateTodoRequest updateTodoRequest, int id) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        Todo todo = TodoMapping.INSTANCE.updateTodo(updateTodoRequest, existingTodo);
        Todo savedTodo = todoRepository.save(todo);
        return new UpdateTodoResponse(savedTodo.getId(), savedTodo.getTodoDescription(),savedTodo.getStatus());
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
    public List<GetAllListTodoResponse> getAllContinueTodos() {
        List<Todo> todos = todoRepository.findAllContinueTodos();
        return TodoMapping.INSTANCE.getAllListToTodoResponse(todos);
    }
}
