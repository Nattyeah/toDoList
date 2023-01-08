package com.nataly.toDoList.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String title;

    private String description;

    private LocalDateTime deadline;

    public void update(TasksEntity request) {
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.deadline = request.getDeadline();
    }
}
