package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class JobApplication {

    @Id
    private Long applicationId;
    private String coverLetter;
    private String resumeUrl;
    private String status;
    private String priority;
    
    @Transient
    private User candidate;
    
    @Transient
    private JobPosition jobPosition;

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public User getCandidate() {
        return candidate;
    }
    
    public void setCandidate(User candidate) {
        this.candidate = candidate;
    }
    
    public JobPosition getJobPosition() {
        return jobPosition;
    }
    
    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }
}
