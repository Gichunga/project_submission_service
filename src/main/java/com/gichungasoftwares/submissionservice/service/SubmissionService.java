package com.gichungasoftwares.submissionservice.service;

import com.gichungasoftwares.submissionservice.model.Submission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubmissionService {
    // submit a completed project
    Submission submitProject(Long projectId, String githubUrl, Long userId) throws RuntimeException;
    //get submissions by submission id
    Submission getSubmittedProjectById(Long submissionId) throws RuntimeException;
    // get submissions by project id
    List<Submission> getProjectSubmissionsByProjectId(Long projectId);
    // accept or decline a submission
    Submission acceptOrDeclineSubmission(Long submissionId, String status) throws RuntimeException;
}
