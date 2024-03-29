package com.gichungasoftwares.submissionservice.service;

import com.gichungasoftwares.submissionservice.model.ProjectDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "SUBMISSION-SERVICE", url = "http://localhost:5002")
public interface ProjectService {

    //get project from the project service by provided id
    @GetMapping("api/projects/{projectId}") // provide the whole path
    ResponseEntity<ProjectDto> getProjectById(@PathVariable("projectId") Long id) throws Exception ;

    // mark project as completed
    @PutMapping("api/projects/{projectId}/complete")
    ResponseEntity<ProjectDto> completeProject(
            @PathVariable("projectId") Long projectId,
            @RequestHeader("Authorization") String jwt
    ) throws Exception ;

}
