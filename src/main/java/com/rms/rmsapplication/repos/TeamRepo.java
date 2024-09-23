package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepo extends JpaRepository<Team,Long> {
    @Override
    Optional<Team> findById(Long aLong);
}
