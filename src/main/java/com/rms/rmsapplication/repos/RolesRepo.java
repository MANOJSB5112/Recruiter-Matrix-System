package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {

    @Override
    List<Roles> findAllById(Iterable<Long> longs);
}
