package com.nataly.toDoList.service;

import com.nataly.toDoList.application.model.TasksEntity;
import com.nataly.toDoList.infrastructure.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksRepository repository;

    //    getAll
    public List<TasksEntity> getAllTasks() {
        return repository.findAll();
    }

    //    getTaskById
    public ResponseEntity<TasksEntity> getTaskById(String id) {
        return repository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    //    createTask
    public TasksEntity createTask(TasksEntity request) {
        return repository.save(request);
    }

    //    updateTask
    public ResponseEntity<TasksEntity> updateTask(String id, TasksEntity request) {
        return repository.findById(id)
                .map(tasksToUpdate -> {
                    tasksToUpdate.update(request);
                    TasksEntity updated = repository.save(tasksToUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //    deleteTask
    public ResponseEntity<Object> deleteTask(String id) {
        return repository.findById(id)
                .map(tasksToDelete -> {
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
