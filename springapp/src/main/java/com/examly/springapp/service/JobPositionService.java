package com.examly.springapp.service;

import com.examly.springapp.model.JobPosition;
import java.util.List;

public interface JobPositionService {

    JobPosition addJobPosition(JobPosition jobPosition);
    List<JobPosition> getAllJobPositions();
    JobPosition getJobPositionById(Long id);
    JobPosition updateJobPosition(Long id, JobPosition jobPosition);
    List<JobPosition> searchJobPositions(String keyword);

}
