package com.patika.kredinbizdeservice.controller;


import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {
    private final IApplicationService applicationService;

    @Autowired
    public ApplicationController(IApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAllApplications();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Application create(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @GetMapping("/{email}")
    public List<Application> getApplicationListByEmail(@PathVariable String email) {
        return applicationService.getApplicationsByEmail(email);
    }

}
