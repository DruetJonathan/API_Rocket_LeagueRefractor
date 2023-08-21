package com.example.api_rocket_leaguerefractor.repository;

import com.example.api_rocket_leaguerefractor.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
}
