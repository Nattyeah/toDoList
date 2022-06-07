package com.nataly.toDoList.infrastructure.repository;

import com.nataly.toDoList.application.model.TasksEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends MongoRepository<TasksEntity, String> {

}
