package com.anks.MatchPredictor.service;

import com.anks.MatchPredictor.dto.TeamRequest;
import com.anks.MatchPredictor.dto.TeamResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class TeamService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String PYTHON_API_URL = "http://localhost:5001/predict";

    public double getPredictionFromPython(TeamRequest req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TeamRequest> entity = new HttpEntity<>(req, headers);

        ResponseEntity<TeamResponse> response =
                restTemplate.postForEntity(PYTHON_API_URL, entity, TeamResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody().getPredictedScore();
        }
        throw new RuntimeException("Prediction API failed");
    }
}
