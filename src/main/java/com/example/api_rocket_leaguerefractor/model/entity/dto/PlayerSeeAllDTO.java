package com.example.api_rocket_leaguerefractor.model.entity.dto;

import com.example.api_rocket_leaguerefractor.model.entity.Player;
import com.example.api_rocket_leaguerefractor.model.entity.Rank;
import com.example.api_rocket_leaguerefractor.model.entity.Stat;
import com.example.api_rocket_leaguerefractor.model.entity.enums.Plateforms;
import lombok.Data;

import java.util.List;

@Data
public class PlayerSeeAllDTO {
    private Long id;
    private String pseudo;
    private Plateforms plateform;
    private List<Rank> ranks;
    private Long teamId;
}

