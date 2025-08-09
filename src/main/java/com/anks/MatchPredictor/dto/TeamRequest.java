package com.anks.MatchPredictor.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamRequest {

    private String teamName;

    private int gameplayed;

    private int currentPos;

    private int wins;

    private int draws;

    private int losses;

    private int goalsFor;

    private int goalAgainst;

}
