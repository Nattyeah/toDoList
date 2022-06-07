package com.nataly.toDoList.service;

import com.nataly.toDoList.application.dto.TasksDTO;
import com.nataly.toDoList.application.model.TasksEntity;
import com.nataly.toDoList.exceptions.TasksExceptions;
import com.nataly.toDoList.infrastructure.repository.TasksRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private final ModelMapper modelMapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(TasksService.class);

    @Autowired
    private TasksRepository repository;

    //    getAll
    public List<TasksEntity> getAllTasks() {
        return repository.findAll();
    }

    //    getTaskById
    public TasksDTO getTaskById(String id) throws TasksExceptions {
        Optional<TasksEntity> findTasks = repository.findById(id);

        if (findTasks.isPresent()) {
            return modelMapper.map(findTasks.get(), TasksDTO.class);
        } else {
            throw new TasksExceptions("Error finding task by id: {}" + id);
        }
    }

    //    createTask
    public TasksDTO createTask(TasksDTO request) {
        TasksEntity createTasks = repository.save(modelMapper.map(request, TasksEntity.class));
        return modelMapper.map(createTasks, TasksDTO.class);
    }

    //    updateTask
    public TasksDTO updateTask(String id, TasksDTO tasksDTO) throws TasksExceptions {
        Optional<TasksEntity> findTasks = repository.findById(id);

        if (findTasks.isPresent()) {
           TasksEntity updateTasks = findTasks.get();
           repository.save(modelMapper.map(tasksDTO, TasksEntity.class));
           return modelMapper.map(updateTasks, TasksDTO.class);
        } else {
            throw new TasksExceptions("Error while updating task");
        }
    }

    //    deleteTask
    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}
