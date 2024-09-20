package com.rms.rmsapplication.service;


import com.rms.rmsapplication.dtos.JobCreationDto;
import com.rms.rmsapplication.model.Address;
import com.rms.rmsapplication.model.Job;
import com.rms.rmsapplication.repos.AddressRepo;
import com.rms.rmsapplication.repos.JobRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class JobServiceImpl implements JobService{

    private final JobRepo jobRepo;
    private final AddressRepo addressRepo;

    JobServiceImpl(JobRepo jobRepo, AddressRepo addressRepo)
    {
        this.jobRepo=jobRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    public void newJob(JobCreationDto jobCreationDto) {
        Job job=new Job();
        job.setTitle(jobCreationDto.getTitle());
        job.setDescription(jobCreationDto.getDescription());
        job.setClient(jobCreationDto.getClient());
        job.setBillRate(jobCreationDto.getBillRate());
        job.setContractDuration(jobCreationDto.getContractDuration());
        Address address=new Address();
        address.setStreet(jobCreationDto.getStreet());
        address.setZipcode(jobCreationDto.getZipcode());
        address.setCity(jobCreationDto.getCity());
        address.setCountry(jobCreationDto.getCountry());
        job.setAddress(address);
        job.setIsActive(true);
        addressRepo.save(address);
        jobRepo.save(job);
    }
}
