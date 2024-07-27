package com.devops.musicsurvey.controller;


import com.devops.musicsurvey.model.SurveyResponse;
import com.devops.musicsurvey.service.SurveyResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey")
public class SurveyResponseController {

    @Autowired
    private SurveyResponseService service;

    @PostMapping
    public ResponseEntity<?> submitSurvey(@Valid @RequestBody SurveyResponse response) {
        try {
            SurveyResponse savedResponse = service.saveSurveyResponse(response);
            return ResponseEntity.ok(savedResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<SurveyResponse> getSurveyResults() {
        return service.getAllResponses();
    }
}
