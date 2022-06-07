package com.nataly.toDoList.application.controller;

import com.nataly.toDoList.application.dto.TasksDTO;
import com.nataly.toDoList.application.model.TasksEntity;
import com.nataly.toDoList.exceptions.TasksExceptions;
import com.nataly.toDoList.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/toDoList/v1")
public class TodoListController {

    @Autowired
    private TasksService service;

//    getAll
    public ResponseEntity<List<TasksEntity>> getAllTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }
//    getTaskById
    public ResponseEntity<TasksDTO> getTaskById(@PathVariable String id) throws TasksExceptions {
        return ResponseEntity.ok(service.getTaskById(id));
    }
//    createTask
    public ResponseEntity<TasksDTO> createTask(@RequestBody TasksDTO request) {
        return new ResponseEntity<>(service.createTask(request), HttpStatus.CREATED);
    }
//    updateTask
    public ResponseEntity<TasksDTO> updateTask(@PathVariable String id, @RequestBody TasksDTO request) throws TasksExceptions {
        return ResponseEntity.ok(service.updateTask(id, request));
    }
//    deleteTask
    public void deleteTask(String id) {
        service.deleteTask(id);
    }

}
