package com.example.api_rocket_leaguerefractor.service;

import com.example.api_rocket_leaguerefractor.model.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeamService {
    List<Team> getAll();
    Team getById(Long id);
    Team add(Team team);
    Team modify(Team team);
    boolean delete(Long id);
}
