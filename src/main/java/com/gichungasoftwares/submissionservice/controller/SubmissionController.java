package com.gichungasoftwares.submissionservice.controller;

import com.gichungasoftwares.submissionservice.model.Submission;
import com.gichungasoftwares.submissionservice.model.UserDto;
import com.gichungasoftwares.submissionservice.service.ProjectService;
import com.gichungasoftwares.submissionservice.service.SubmissionService;
import com.gichungasoftwares.submissionservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    // save a user submission
    @PostMapping
    public ResponseEntity<Submission> submitProject(
            @RequestParam Long projectId,
            @RequestParam String githubUrl,
            @RequestHeader ("Authorization") String jwt) throws Exception
    {
        UserDto userDto = userService.findUserByJwt(jwt);
        Submission submission = submissionService.submitProject(projectId, githubUrl, userDto.getId(), jwt);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);
    }

    // get submission by id
    @GetMapping("/{submissionId}")
    public ResponseEntity<Submission> getSubmissionById(
            @PathVariable Long submissionId
    )throws Exception{
        Submission submission = submissionService.getSubmissionById(submissionId);
        return new ResponseEntity<>(submission, HttpStatus.OK);

    }

    //get all submissions
    @GetMapping
    public ResponseEntity<List<Submission>> getAllSubmissions(){
        List<Submission> submissionList = submissionService.getAllSubmissions();
        return new ResponseEntity<>(submissionList, HttpStatus.OK);
    }

    // get all submissions of a project
    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Submission>> getSubmissionsByProjectId(@PathVariable Long projectId) throws Exception{
        List<Submission> submissionList = submissionService.getSubmissionsByProjectId(projectId);
        return new ResponseEntity<>(submissionList, HttpStatus.OK);
    }

    // accept or decline a submission
    @PutMapping("/{submissionId}/accept")
    public ResponseEntity<Submission> acceptOrDeclineSubmission
    (
            @PathVariable Long submissionId,
            @RequestParam String status,
            @RequestHeader("Authorization") String jwt) throws Exception{
        submissionService.acceptOrDeclineSubmission(submissionId, status, jwt);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
