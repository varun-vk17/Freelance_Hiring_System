package com.examly.springapp.controller;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

    @Autowired
    private JobPositionService jobPositionService;

    @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition jobPosition) {
        return new ResponseEntity<>(jobPositionService.addJobPosition(jobPosition), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobPosition>> getAllJobPositions() {
        return ResponseEntity.ok(jobPositionService.getAllJobPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPosition(@PathVariable Long id) {
        return ResponseEntity.ok(jobPositionService.getJobPositionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(
            @PathVariable Long id,
            @RequestBody JobPosition jobPosition) {

        return ResponseEntity.ok(jobPositionService.updateJobPosition(id, jobPosition));
    }
    @GetMapping("/search/{keyword}")
public ResponseEntity<List<JobPosition>> searchJobPositions(
        @PathVariable String keyword) {

    return ResponseEntity.ok(jobPositionService.searchJobPositions(keyword));
}

}
