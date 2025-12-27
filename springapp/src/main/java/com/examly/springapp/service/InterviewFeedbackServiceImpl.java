package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    private static final Map<Long, InterviewFeedback> store = new HashMap<>();
    private static long idCounter = 1;

    @Override
    public InterviewFeedback addFeedback(InterviewFeedback feedback) {
        feedback.setFeedbackId(idCounter++);
        store.put(feedback.getFeedbackId(), feedback);
        return feedback;
    }

    @Override
    public List<InterviewFeedback> getAllFeedbacks() {
        return new ArrayList<>(store.values());
    }

    @Override
    public InterviewFeedback getFeedbackById(Long id) {
        return store.get(id);
    }

    @Override
    public InterviewFeedback updateFeedback(Long id, InterviewFeedback feedback) {
        InterviewFeedback existing = store.get(id);
        if (existing != null) {
            feedback.setFeedbackId(id);
            feedback.setApplicationId(existing.getApplicationId());
            feedback.setUserId(existing.getUserId());
        } else {
            feedback.setFeedbackId(id);
        }
        store.put(id, feedback);
        return feedback;
    }

    @Override
    public List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId) {
        List<InterviewFeedback> result = new ArrayList<>();
        for (InterviewFeedback f : store.values()) {
            if (applicationId.equals(f.getApplicationId())) {
                result.add(f);
            }
        }
        return result;
    }
}
