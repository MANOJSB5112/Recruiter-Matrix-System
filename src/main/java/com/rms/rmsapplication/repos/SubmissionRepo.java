package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepo extends JpaRepository<Submission,Long> {


   @Override
   Optional<Submission> findById(Long aLong);

   Long countSubmissionByCandidate_Id(Long id);

   List<Submission> findSubmissionByRecruiterId(@Param("employeeId") Long employeeId);

   List<Submission> findSubmissionByCandidateId(@Param("candidateId") Long candidateId);
}
