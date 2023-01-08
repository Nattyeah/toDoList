package com.nataly.toDoList.application.controller;

import com.nataly.toDoList.application.model.TasksEntity;
import com.nataly.toDoList.service.TasksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/toDoList/v1")
public class TodoListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TasksService.class);

    @Autowired
    private TasksService service;

    //    getAll
    @GetMapping("/tasks")
    public ResponseEntity<List<TasksEntity>> getAllTasks() {
        LOGGER.info("Searching for all tasks");

        return ResponseEntity.ok(service.getAllTasks());
    }

    //    getTaskById
    @GetMapping("/tasks/{id}")
    public ResponseEntity<TasksEntity> getTaskById(@PathVariable String id) {
        try {
            LOGGER.info("Searching for task with id '" + id + "'");

            return service.getTaskById(id);

        } catch (NoSuchElementException ex) {
            LOGGER.warn("Task with id: '" + id + " not found!'", ex);

            return ResponseEntity.notFound().build();
        }
    }

    //    createTask
    @PostMapping("/tasks")
    public ResponseEntity<TasksEntity> createTask(@RequestBody TasksEntity request) {
        LOGGER.info("Creating new task [{}]", request);

        return new ResponseEntity<>(service.createTask(request), HttpStatus.CREATED);
    }

    //    updateTask
    @PutMapping("/tasks/{id}")
    public ResponseEntity<TasksEntity> updateTask(@PathVariable String id, @RequestBody TasksEntity request) {
        LOGGER.info("Updating task with body [{}]", request);

        return service.updateTask(id, request);
    }

    //    deleteTask
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable String id) {
        LOGGER.info("Deleting task with id [{}]", id);

        return service.deleteTask(id);
    }

}
