package com.codesoom.assignment.controllers;

import com.codesoom.assignment.TaskNotFoundException;
import com.codesoom.assignment.application.TaskService;
import com.codesoom.assignment.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class TaskControllerTest {
    private TaskController controller;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        // 프록시 패턴
        // Controller -> Spy -> Real Object
        // taskService = spy(new TaskService());

        // Mock 패턴
        // 타입이 필요함(원래는 인터페이스가 타입, 클래스는 구현체를 같이 가지고 있는 것임)
        taskService = mock(TaskService.class);

        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        task.setTitle("Test1");
        tasks.add(task);

        // 아래 가짜로 구현헀기 때문에 실제 taskService에서 제대로 동작함을 테스트를 통해 증명해야 함
        given(taskService.getTasks()).willReturn(tasks);
        given(taskService.getTask(1L)).willReturn(task);
        given(taskService.getTask(100L))
                .willThrow(new TaskNotFoundException(100L));
        given(taskService.updateTask(eq(100L), any(Task.class)))
                .willThrow(new TaskNotFoundException(100L));
        given(taskService.deleteTask(eq(100L)))
                .willThrow(new TaskNotFoundException(100L));

        controller = new TaskController(taskService);
    }

    @Test
    void listWithoutTasks() {
        given(taskService.getTasks()).willReturn(new ArrayList<>());

        assertThat(controller.list()).isEmpty();
        verify(taskService).getTasks();
    }

    @Test
    void listWithSomeTasks() {
        assertThat(controller.list()).isNotEmpty();
        verify(taskService).getTasks();
    }

    @Test
    void detailWithExistedId() {
        Task task = controller.detail(1L);
        assertThat(task).isNotNull();
    }

    @Test
    void detailWithNotExistedId() {
        assertThatThrownBy(() -> controller.detail(100L))
                .isInstanceOf(TaskNotFoundException.class);
    }

    @Test
    void createNewTask() {
        Task task = new Task();
        task.setTitle("Test2");
        controller.create(task);

        verify(taskService).createTask(task);
    }

    @Test
    void updateExistedTask() {
        Task task = new Task();
        task.setTitle("Renamed task");
        controller.update(1L, task);

        verify(taskService).updateTask(1L, task);
    }

    @Test
    void updateNotExistedTask() {
        Task task = new Task();
        task.setTitle("Renamed task");
        assertThatThrownBy(() -> controller.update(100L, task))
                .isInstanceOf(TaskNotFoundException.class);
    }

    @Test
    void deleteExistedTask() {
        controller.delete(1L);
        verify(taskService).deleteTask(1L);
    }

    @Test
    void deleteNotExistedTask() {
        assertThatThrownBy(() -> controller.delete(100L))
                .isInstanceOf(TaskNotFoundException.class);
    }
}