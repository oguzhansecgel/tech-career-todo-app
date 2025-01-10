package com.oguzhansecgel.to_do_app.repository;

import com.oguzhansecgel.to_do_app.dto.response.GetAllListTodoResponse;
import com.oguzhansecgel.to_do_app.model.Status;
import com.oguzhansecgel.to_do_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface TodoRepository extends JpaRepository<Todo,Integer> {

    List<Todo> findByStartedTime(LocalDate startedTime);
    List<Todo> findByFinishTime(LocalDate finishTime);

    List<Todo> findByStatus(Status status);

    default List<Todo> findAllDoneTodos() {
        return findByStatus(Status.DONE);
    }

    default List<Todo> findAllInProgressTodos() {
        return findByStatus(Status.IN_PROGRESS);
    }
    default List<Todo> findAllNotStartedTodos() {
        return findByStatus(Status.NOT_STARTED);
    }
    default List<Todo> findAllPendingTodos() {
        return findByStatus(Status.PENDING);
    }
    default List<Todo> findAllCancelledTodos() {
        return findByStatus(Status.CANCELLED);
    }
}
