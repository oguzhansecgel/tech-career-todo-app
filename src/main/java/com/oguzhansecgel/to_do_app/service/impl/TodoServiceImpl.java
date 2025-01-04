package com.oguzhansecgel.to_do_app.service.impl;

import com.oguzhansecgel.to_do_app.repository.TodoRepository;
import com.oguzhansecgel.to_do_app.service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {


    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
}
