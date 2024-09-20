package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepo extends JpaRepository<JobOffer,Long> {
}
