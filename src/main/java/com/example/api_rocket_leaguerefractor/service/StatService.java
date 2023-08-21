package com.example.api_rocket_leaguerefractor.service;

import com.example.api_rocket_leaguerefractor.model.entity.Rank;
import com.example.api_rocket_leaguerefractor.model.entity.Stat;

import java.util.List;

public interface StatService {
    List<Stat> getAll();
    Stat getById(Long id);
    Stat modify(Stat stat);
    Stat add(Stat stat);
    boolean delete(Long id);
}
