package com.rms.rmsapplication.repos;

import com.rms.rmsapplication.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {

}
