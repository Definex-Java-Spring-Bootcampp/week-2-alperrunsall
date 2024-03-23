package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public Application save(Application application) {
        applicationRepository.save(application);
        return application;
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.getAll();
    }

    @Override
    public List<Application> getApplicationsByEmail(String email) {
        return applicationRepository.findByMail(email);
    }

    @Override
    public Application update(String email, Application application) {
        return null;
    }

    @Override
    public void delete(Application application) {

    }


}
