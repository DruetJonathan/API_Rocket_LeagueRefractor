package com.example.api_rocket_leaguerefractor.repository;

import com.example.api_rocket_leaguerefractor.model.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat,Long> {
}
