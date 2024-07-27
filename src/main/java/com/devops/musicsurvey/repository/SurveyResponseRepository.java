package com.devops.musicsurvey.repository;

import com.devops.musicsurvey.model.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    Optional<SurveyResponse> findByEmail(String email);
}
