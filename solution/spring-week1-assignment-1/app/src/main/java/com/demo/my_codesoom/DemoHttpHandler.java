package com.demo.my_codesoom;

import com.demo.my_codesoom.models.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DemoHttpHandler implements HttpHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Task> tasks = new ArrayList<>();
    private Long newId = 0L;

    public DemoHttpHandler() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Do nothing~");

        tasks.add(task);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // 1. Method
        // 2. Path
        // 3. Headers, Body(Content)

        URI uri = exchange.getRequestURI();
        String path = uri.getPath();

        String method = exchange.getRequestMethod();
        System.out.println(method + " " + path); 

        if (path.equals("/tasks")) {
            handleCollection(exchange, method);
            return;
        }

        if (path.startsWith("/tasks/")) {
            Long id = Long.parseLong(path.substring("/tasks/".length()));
            handleItem(exchange, method, id);
            return;
        }
        send(exchange, 200, "Hello, world!");
    }

    private void handleItem(HttpExchange exchange, String method, Long id) throws IOException {
        Task task = findTask(id);

        if (task == null) {
            send(exchange, 404, "");
            return;
        }

        if (method.equals("GET")){
            // Jackson
//            content = "[{\"id\":1, \"title\":\"Do nothing\"}:";  // \ 위치 참고
            handleDetail(exchange, task);
            return;
        }

        if (method.equals("PUT") || method.equals("PATCH")){
            handleUpdate(exchange, task);
        }

        if (method.equals("DELETE")){
            handleDelete(exchange, task);
        }
    }

    private void handleDelete(HttpExchange exchange, Task task) throws IOException {
        tasks.remove(task);
        send(exchange, 200, toJSON(task));
    }

    private void handleDetail(HttpExchange exchange, Task task) throws IOException {
        send(exchange, 200, toJSON(task));
    }

    private void handleUpdate(HttpExchange exchange, Task task) throws IOException {
        String body = getBody(exchange);

        Task source = toTask(body);
        task.setTitle(source.getTitle());
        send(exchange, 200, toJSON(task));
    }

    private Task findTask(Long id) {
        return tasks.stream()
                    .filter(task -> task.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    private void handleCollection(HttpExchange exchange, String method) throws IOException {

        if (method.equals("GET")) {
            handleList(exchange);
        }

        if (method.equals("POST")) {
            handleCreate(exchange);
        }
    }

    private void handleList(HttpExchange exchange) throws IOException {
        send(exchange, 200, tasksToJSON());
    }

    private String tasksToJSON() throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        objectMapper.writeValue(outputStream, tasks);

        return outputStream.toString();
    }

    private void handleCreate(HttpExchange exchange) throws IOException {
        String body = getBody(exchange);

        Task task = toTask(body);
        task.setId(generateId());
        tasks.add(task);
        send(exchange, 201, toJSON(task));
    }

    private Long generateId() {
        newId += 1;
        return newId;
    }

    private String getBody(HttpExchange exchange) {
        InputStream inputStream = exchange.getRequestBody();
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));
    }

    private void send(HttpExchange exchange, int statusCode, String content) throws IOException {
        exchange.sendResponseHeaders(statusCode, content.getBytes().length);  // 한글이면 bytes로 받아야 한다?

        OutputStream outputStream = exchange.getResponseBody();
        outputStream.write(content.getBytes());
        outputStream.flush(); // flush: 버퍼에 있는 데이터를 모두 처리하라
        outputStream.close();
    }

    private Task toTask(String content) throws JsonProcessingException {
        return objectMapper.readValue(content, Task.class);
    }

    private String toJSON(Object object) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        objectMapper.writeValue(outputStream, object);

        return outputStream.toString();
    }
}
