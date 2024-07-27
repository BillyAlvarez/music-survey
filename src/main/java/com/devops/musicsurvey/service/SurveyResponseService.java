package com.devops.musicsurvey.service;

import com.devops.musicsurvey.model.SurveyResponse;
import com.devops.musicsurvey.repository.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyResponseService {

    @Autowired
    private SurveyResponseRepository repository;

    public SurveyResponse saveSurveyResponse(SurveyResponse response) throws Exception {
        if (repository.findByEmail(response.getEmail()).isPresent()) {
            throw new Exception("Email already exists");
        }
        return repository.save(response);
    }

    public List<SurveyResponse> getAllResponses() {
        return repository.findAll();
    }
}
