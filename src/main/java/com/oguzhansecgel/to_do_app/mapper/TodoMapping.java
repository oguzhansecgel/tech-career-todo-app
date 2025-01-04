package com.oguzhansecgel.to_do_app.mapper;

import com.oguzhansecgel.to_do_app.dto.request.CreateTodoRequest;
import com.oguzhansecgel.to_do_app.model.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapping {


    TodoMapping INSTANCE = Mappers.getMapper(TodoMapping.class);

    Todo createTodo(CreateTodoRequest request);
}
