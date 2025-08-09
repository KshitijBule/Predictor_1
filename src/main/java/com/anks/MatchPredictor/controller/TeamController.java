package com.anks.MatchPredictor.controller;

import com.anks.MatchPredictor.dto.TeamRequest;
import com.anks.MatchPredictor.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/predictions")
public class TeamController {
    private TeamService teamService;


        @PostMapping
        public ResponseEntity<Double> predict(@RequestBody TeamRequest req) {
            double prediction = teamService.getPredictionFromPython(req);
            return ResponseEntity.ok(prediction);
        }

    }

