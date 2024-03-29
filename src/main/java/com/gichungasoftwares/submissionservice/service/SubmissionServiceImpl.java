package com.gichungasoftwares.submissionservice.service;

import com.gichungasoftwares.submissionservice.model.ProjectDto;
import com.gichungasoftwares.submissionservice.model.Submission;
import com.gichungasoftwares.submissionservice.model.UserDto;
import com.gichungasoftwares.submissionservice.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService{
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    // save a user submission
    @Override
    public Submission submitProject(Long projectId, String githubUrl, Long userId, String jwt) throws Exception {
        // find project
        ProjectDto project = projectService.getProjectById(projectId);
        // find user
        UserDto user = userService.findUserByJwt(jwt); // logged in user
        if(project != null && user != null) {
            //create submission
            Submission submission = new Submission();
            submission.setProjectId(projectId);
            submission.setUserId(userId);
            submission.setSubmissionTime(LocalDateTime.now());
            submission.setGithubUrl(githubUrl);
            return submissionRepository.save(submission);
        }
        throw  new RuntimeException("Project not found with id " +projectId);
    }

    // get submission by id
    @Override
    public Submission getSubmissionById(Long submissionId) throws RuntimeException {
        return submissionRepository.findById(submissionId).orElseThrow(() -> new RuntimeException("Submission not found! " + submissionId));
    }

    // get all submissions of a project - one project can be assigned to multiple users
    @Override
    public List<Submission> getSubmissionsByProjectId(Long projectId) throws Exception {
        //find project
        ProjectDto project = projectService.getProjectById(projectId);
        if (project == null) {
            throw new Exception("Error: project not found!");
        }

        return submissionRepository.findByProjectId(projectId);
    }

    // accept submission and mark a project as complete
    @Override
    public Submission acceptOrDeclineSubmission(Long submissionId, String status, String jwt) throws Exception {
        Submission submission = new Submission();
        submission.setStatus(status);
        if (status.equals("ACCEPT")){
            projectService.completeProject(submission.getProjectId(), jwt);
        }

        return submissionRepository.save(submission);
    }
}
