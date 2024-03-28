package com.gichungasoftwares.submissionservice.service;

import com.gichungasoftwares.submissionservice.model.Submission;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService{
    // save a user submission
    @Override
    public Submission submitProject(Long projectId, String githubUrl, Long userId) throws RuntimeException {

        return null;
    }

    @Override
    public Submission getSubmittedProjectById(Long submissionId) throws RuntimeException {
        return null;
    }

    @Override
    public List<Submission> getProjectSubmissionsByProjectId(Long projectId) {
        return null;
    }

    @Override
    public Submission acceptOrDeclineSubmission(Long submissionId, String status) throws RuntimeException {
        return null;
    }
}
