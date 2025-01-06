package com.oguzhansecgel.to_do_app.mapper;

import com.oguzhansecgel.to_do_app.dto.request.CreateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.request.UpdateTodoRequest;
import com.oguzhansecgel.to_do_app.dto.response.GetAllListTodoResponse;
import com.oguzhansecgel.to_do_app.dto.response.GetByIdTodoResponse;
import com.oguzhansecgel.to_do_app.model.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TodoMapping {


    TodoMapping INSTANCE = Mappers.getMapper(TodoMapping.class);

    Todo createTodo(CreateTodoRequest request);

    Todo updateTodo(UpdateTodoRequest request, @MappingTarget Todo target);

    GetByIdTodoResponse getByIdTodoResponse(Todo todo);


    GetAllListTodoResponse getAllListTodoResponse(Todo todos);
    List<GetAllListTodoResponse> getAllListToTodoResponse(List<Todo> todos);
}
