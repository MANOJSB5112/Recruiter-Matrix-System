package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepo extends JpaRepository<Interview,Long> {
}
