package com.examly.springapp.service;

import com.examly.springapp.model.JobPosition;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    private final Map<Long, JobPosition> store = new HashMap<>();
    private long idCounter = 1;

    @Override
    public JobPosition addJobPosition(JobPosition jobPosition) {
        jobPosition.setPositionId(idCounter++);
        store.put(jobPosition.getPositionId(), jobPosition);
        return jobPosition;
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return new ArrayList<>(store.values());
    }

    @Override
    public JobPosition getJobPositionById(Long id) {
        return store.get(id);
    }

    @Override
    public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
        jobPosition.setPositionId(id);
        store.put(id, jobPosition);
        return jobPosition;
    }
    @Override
public List<JobPosition> searchJobPositions(String keyword) {
    List<JobPosition> result = new ArrayList<>();

    for (JobPosition job : store.values()) {
        if (job.getPositionTitle() != null &&
            job.getPositionTitle().contains(keyword)) {
            result.add(job);
        }
    }
    return result;
}

}
