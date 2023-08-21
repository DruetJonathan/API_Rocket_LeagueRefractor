package com.example.api_rocket_leaguerefractor.service.impl;

import com.example.api_rocket_leaguerefractor.exception.DeletionFailedException;
import com.example.api_rocket_leaguerefractor.exception.RessourceNotFoundException;
import com.example.api_rocket_leaguerefractor.model.entity.Team;
import com.example.api_rocket_leaguerefractor.repository.PlayerRepository;
import com.example.api_rocket_leaguerefractor.repository.TeamRepository;
import com.example.api_rocket_leaguerefractor.service.TeamService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indique que cette classe est un service Spring
public class TeamServiceImpl implements TeamService {
    TeamRepository teamRepository; // Référence au repository pour interagir avec la base de données

    // Constructeur pour injecter le repository au service
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAll() {
        // Récupère la liste de toutes les équipes à partir du repository et la retourne
        return this.teamRepository.findAll();
    }

    @Override
    public Team getById(Long id) {
        // Récupère une équipe par son ID à partir du repository et la retourne si elle existe,
        // sinon lance une exception personnalisée
        return this.teamRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("team", id));
    }

    @Override
    @Transactional // Indique que cette méthode est transactionnelle
    public Team add(Team team) {
        // Ajoute une nouvelle équipe à la base de données en utilisant le repository et retourne l'équipe ajoutée
        return this.teamRepository.save(team);
    }

    @Override
    @Transactional // Indique que cette méthode est transactionnelle
    public Team modify(Team team) {
        // Modifie une équipe dans la base de données en utilisant le repository et retourne l'équipe modifiée
        return this.teamRepository.save(team);
    }

    @Override
    @Transactional // Indique que cette méthode est transactionnelle
    public boolean delete(Long id) {
        try {
            // Supprime une équipe de la base de données par son ID, en cas d'échec, lance une exception personnalisée
            teamRepository.deleteById(id);
        } catch (DeletionFailedException e) {
            throw new DeletionFailedException("Failed delete");
        }
        return true; // Renvoie true après la suppression réussie
    }
}

