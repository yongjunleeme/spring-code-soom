package com.codesoom.assignment.domain;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Long id);

    Task save(Task task);

    List<Task> findAll();

    void delete(Task task);
}
