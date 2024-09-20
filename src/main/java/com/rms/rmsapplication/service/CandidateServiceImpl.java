package com.rms.rmsapplication.service;

import com.rms.rmsapplication.dtos.CandidateCreationDto;
import com.rms.rmsapplication.model.Address;
import com.rms.rmsapplication.model.Candidate;
import com.rms.rmsapplication.repos.AddressRepo;
import com.rms.rmsapplication.repos.CandidateRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CandidateServiceImpl implements CandidateService{
    private final AddressRepo addressRepo;
    private final CandidateRepo candidateRepo;

    public CandidateServiceImpl(AddressRepo addressRepo, CandidateRepo candidateRepo) {
        this.addressRepo = addressRepo;
        this.candidateRepo = candidateRepo;
    }

    @Override
    public void newCandidate(CandidateCreationDto candidateCreationDto) {

            Address address = Address.builder()
                    .street(candidateCreationDto.getStreet())
                    .city(candidateCreationDto.getCity())
                    .zipcode(candidateCreationDto.getZipcode())
                    .country(candidateCreationDto.getCountry())
                    .build();
            addressRepo.save(address);
            Candidate candidate = Candidate.builder()
                    .name(candidateCreationDto.getName())
                    .email(candidateCreationDto.getEmail())
                    .phoneNumber(candidateCreationDto.getPhoneNumber())
                    .currentCompany(candidateCreationDto.getCurrentCompany())
                    .currentSalary(candidateCreationDto.getCurrentSalary())
                    .address(address)
                    .build();
            candidateRepo.save(candidate);

    }
}
