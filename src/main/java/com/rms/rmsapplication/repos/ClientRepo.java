package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Company,Long> {
    @Override
    Optional<Company> findById(Long aLong);
}
