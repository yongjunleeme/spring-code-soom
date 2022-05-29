package com.codesoom.assignment.application;

import com.codesoom.assignment.TaskNotFoundException;
import com.codesoom.assignment.domain.Task;
import com.codesoom.assignment.domain.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

//@DataJpaTest
@DisplayName("TaskService 클래스")
public class TaskServiceTest {

    private TaskService taskService;
    private Task task;

    private static final String TASK_TITLE = "test";
    private static final String UPDATE_POSTFIX = "!!!";
    private static final String CREATE_POSTFIX = "!";

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        // 실제 가장 많이 쓰임
        taskRepository = mock(TaskRepository.class);

        taskService = new TaskService(taskRepository);
        List<Task> tasks = new ArrayList<>();

        task = new Task();
        task.setTitle(TASK_TITLE);
        tasks.add(task);

        given(taskRepository.findAll()).willReturn(tasks);
        given(taskRepository.findById(1L)).willReturn(Optional.of(task));
        given(taskRepository.findById(100L)).willReturn(Optional.empty());
    }

    @BeforeEach
    void setUpSaveTask() {

        Task createdTask = new Task();
        createdTask.setTitle(TASK_TITLE + CREATE_POSTFIX);

        given(taskRepository.save(any(Task.class))).will(invocation -> {
            Task task = invocation.getArgument(0);
            return task;
        });
    }

    @Test
    void getTasks() {

        List<Task> tasks = taskService.getTasks();

        verify(taskRepository).findAll();
        assertThat(tasks).hasSize(1);

        Task task = tasks.get(0);
        assertThat(task.getTitle()).isEqualTo(TASK_TITLE);
    }

    @Test
    void getTaskWithExistedId() {
        Task task = taskService.getTask(1L);
        assertThat(task.getTitle()).isEqualTo(TASK_TITLE);

        verify(taskRepository).findById(1L);
    }

    @Test
    void getTaskWithInvalidId() {
        assertThatThrownBy(() -> taskService.getTask(100L))
                .isInstanceOf(TaskNotFoundException.class);

        verify(taskRepository).findById(100L);
    }

    @Test
    void createTask() {
        Task source = new Task();
        source.setTitle(TASK_TITLE + CREATE_POSTFIX);
        Task task = taskService.createTask(source);

        verify(taskRepository).save(any(Task.class));

        assertThat(task.getTitle()).isEqualTo(TASK_TITLE + CREATE_POSTFIX);
    }

    @Test
    void updateTaskWithExistedId() {
        Task source = new Task();
        source.setTitle(TASK_TITLE + UPDATE_POSTFIX);
        Task task = taskService.updateTask(1L, source);

        verify(taskRepository).findById(1L);

        assertThat(task.getTitle()).isEqualTo(TASK_TITLE + UPDATE_POSTFIX);
    }

    @Test
    void updateTaskWithNotExistedId() {
        Task source = new Task();
        source.setTitle(TASK_TITLE + UPDATE_POSTFIX);

        assertThatThrownBy(() -> taskService.updateTask(100L, source))
                .isInstanceOf(TaskNotFoundException.class);
        verify(taskRepository).findById(100L);
    }

    @Test
    void deleteTaskWithExistedId() {
        taskService.deleteTask(1L);
        verify(taskRepository).findById(1L);
        verify(taskRepository).delete(any(Task.class));
    }


    @Test
    void deleteTaskWithNotExistedId() {
        assertThatThrownBy(() -> taskService.deleteTask(100L))
                .isInstanceOf(TaskNotFoundException.class);
        verify(taskRepository).findById(100L);
    }
}
