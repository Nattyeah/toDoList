package com.nataly.toDoList.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksDTO {
// Entrada da req
    private String id;

    private String title;

    private String description;

    private LocalDateTime deadline;
}
