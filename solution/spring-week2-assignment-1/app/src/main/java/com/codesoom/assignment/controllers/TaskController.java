package com.codesoom.assignment.controllers;

import com.codesoom.assignment.TaskNotFoundException;
import com.codesoom.assignment.models.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {
    private List<Task> tasks = new ArrayList<>();
    private Long newId = 0L;

    @GetMapping
    public List<Task> List() {
        return tasks;
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        task.setId(generateID());
        tasks.add(task);
        return task;
    }

    @GetMapping("{id}")
    public Task detail(@PathVariable Long id) {
        return findTask(id);
    }

    @PatchMapping("{id}")
    public Task update(
            @PathVariable Long id,
            @RequestBody Task source
    ) {
        Task task = findTask(id);
        task.setTitle(source.getTitle());

        return task;
    }

    @DeleteMapping("{id}")
    public Task delete(@PathVariable Long id) {
        return findTask(id);
    }

    private Task findTask(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    private Long generateID() {
        newId += 1;
        return newId;
    }

}
