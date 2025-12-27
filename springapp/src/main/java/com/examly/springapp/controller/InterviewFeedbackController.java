package com.examly.springapp.controller;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.model.InterviewFeedbackRequest;
import com.examly.springapp.service.InterviewFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {
@Autowired
    private InterviewFeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<InterviewFeedback> addFeedback(
            @RequestBody InterviewFeedbackRequest request) {

        InterviewFeedback feedback = new InterviewFeedback();
        feedback.setContent(request.getContent());
        feedback.setInternal(request.isInternal());
        feedback.setInterviewRound(request.getInterviewRound());

        if (request.getJobApplication() != null) {
            feedback.setApplicationId(
                    request.getJobApplication().getApplicationId()
            );
        }

        if (request.getUser() != null) {
            feedback.setUserId(
                    request.getUser().getUserId()
            );
        }

        InterviewFeedback saved = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

@GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }
@GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getFeedbackById(
            @PathVariable Long id) {

        InterviewFeedback feedback = feedbackService.getFeedbackById(id);
        if (feedback == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> updateFeedback(
            @PathVariable Long id,
            @RequestBody InterviewFeedback feedback) {

        return ResponseEntity.ok(
                feedbackService.updateFeedback(id, feedback)
        );
    }
@GetMapping("/application/{applicationId}")
    public ResponseEntity<List<InterviewFeedback>> getByApplication(
            @PathVariable Long applicationId) {

        return ResponseEntity.ok(
                feedbackService.getFeedbacksByApplicationId(applicationId)
        );
    }
}
