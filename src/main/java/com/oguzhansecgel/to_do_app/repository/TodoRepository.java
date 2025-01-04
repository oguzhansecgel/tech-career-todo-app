package com.oguzhansecgel.to_do_app.repository;

import com.oguzhansecgel.to_do_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
