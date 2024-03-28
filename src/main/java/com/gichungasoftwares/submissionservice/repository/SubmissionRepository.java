package com.gichungasoftwares.submissionservice.repository;

import com.gichungasoftwares.submissionservice.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    // find all submissions of one project
    List<Submission> findByProjectId(Long projectId);
}
