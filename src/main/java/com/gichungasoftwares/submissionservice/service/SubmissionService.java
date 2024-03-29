package com.gichungasoftwares.submissionservice.service;

import com.gichungasoftwares.submissionservice.model.Submission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubmissionService {
    // submit a completed project
    Submission submitProject(Long projectId, String githubUrl, Long userId, String jwt) throws Exception;
    //get submissions by submission id
    Submission getSubmissionById(Long submissionId) throws Exception;
    // get submissions by project id
    List<Submission> getSubmissionsByProjectId(Long projectId) throws Exception;
    // accept or decline a submission
    Submission acceptOrDeclineSubmission(Long submissionId, String status, String jwt) throws Exception;
}
