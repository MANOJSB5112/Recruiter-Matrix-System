package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long> {
    @Query("SELECT i FROM Interview i WHERE i.submission.id IN " +
            "(SELECT s.id FROM Submission s WHERE s.recruiter.id = :employeeId)")
    List<Interview> findInterviewsByRecruiterId(@Param("employeeId") Long employeeId);

    @Query("SELECT i FROM Interview i WHERE i.submission.id IN " +
            "(SELECT s.id FROM Submission s WHERE s.candidate.id = :candidateId)")
    List<Interview> findInterviewsByCandidateId(@Param("candidateId") Long candidateId);
}
