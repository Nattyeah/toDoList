package com.nataly.toDoList.application.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "tasks")
public class TasksEntity {
// Saida da req
    @Id
    @MongoId
    private String id;

    private String title;

    private String description;

    private LocalDateTime deadline;
}
