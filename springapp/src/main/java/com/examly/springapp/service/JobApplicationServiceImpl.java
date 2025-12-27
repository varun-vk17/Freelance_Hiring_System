package com.examly.springapp.service;

import com.examly.springapp.model.JobApplication;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
    
    private static final Map<Long, JobApplication> store = new HashMap<>();
    private static long idCounter = 1;
    
    @Override
    public JobApplication createJobApplication(JobApplication jobApplication) {
        jobApplication.setApplicationId(idCounter++);
        store.put(jobApplication.getApplicationId(), jobApplication);
        return jobApplication;
    }
    
    @Override
    public List<JobApplication> getAllJobApplications() {
        return new ArrayList<>(store.values());
    }
    
    @Override
    public JobApplication getJobApplicationById(Long id) {
        return store.get(id);
    }
    
    @Override
    public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
        jobApplication.setApplicationId(id);
        store.put(id, jobApplication);
        return jobApplication;
    }
    
    @Override
    public void deleteJobApplication(Long id) {
        store.remove(id);
    }
}
