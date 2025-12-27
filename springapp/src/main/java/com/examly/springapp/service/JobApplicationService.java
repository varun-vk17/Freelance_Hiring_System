package com.examly.springapp.service;

import com.examly.springapp.model.JobApplication;
import java.util.List;

public interface JobApplicationService {
    JobApplication createJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplications();
    JobApplication getJobApplicationById(Long id);
    JobApplication updateJobApplication(Long id, JobApplication jobApplication);
    void deleteJobApplication(Long id);
} 