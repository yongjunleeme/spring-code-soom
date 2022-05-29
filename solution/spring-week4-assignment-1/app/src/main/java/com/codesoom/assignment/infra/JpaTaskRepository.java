package com.codesoom.assignment.infra;

import com.codesoom.assignment.domain.Task;
import com.codesoom.assignment.domain.TaskRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


// 실제로는 필요 없잉 TaskRepository에서 CrudRepository를 상속하고
// InMemoryTaskRepository처럼 기능 구현도 할 필요 없이 갖다 쓰면 된다.
@Primary
public interface JpaTaskRepository extends TaskRepository, CrudRepository<Task, Long> {

    Optional<Task> findById(Long id);

    Task save(Task task);

    List<Task> findAll();

    void delete(Task task);

}
