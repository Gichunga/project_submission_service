package com.gichungasoftwares.submissionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Long assignedUserId;
    private List<String> tags = new ArrayList<>();
    private ProjectStatus status;
    private LocalDateTime deadline;
    private LocalDateTime createdAt;
}
