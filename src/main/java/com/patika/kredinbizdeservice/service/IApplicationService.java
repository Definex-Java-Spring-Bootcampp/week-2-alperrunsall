package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;

import java.util.List;

public interface IApplicationService {
    Application save(Application application);

    List<Application> getAllApplications();

    List<Application> getApplicationsByEmail(String email);

    Application update(String email, Application application);

    void delete(Application application);
}
