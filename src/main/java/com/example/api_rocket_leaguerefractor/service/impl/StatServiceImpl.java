package com.example.api_rocket_leaguerefractor.service.impl;

import com.example.api_rocket_leaguerefractor.exception.DeletionFailedException;
import com.example.api_rocket_leaguerefractor.exception.RessourceNotFoundException;
import com.example.api_rocket_leaguerefractor.model.entity.Stat;
import com.example.api_rocket_leaguerefractor.repository.StatRepository;
import com.example.api_rocket_leaguerefractor.service.StatService;
import jakarta.transaction.Transactional;

import java.util.List;

public class StatServiceImpl implements StatService {
    StatRepository statRepository;

    public StatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public List<Stat> getAll() {
        return this.statRepository.findAll();
    }

    @Override
    public Stat getById(Long id) {
        return this.statRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("stat", id));
    }

    @Override
    public Stat modify(Stat stat) {
        return this.statRepository.save(stat);
    }

    @Override
    @Transactional
    public Stat add(Stat stat) {
        return this.statRepository.save(stat);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            // Supprime un joueur de la base de données par son ID, en cas d'échec, lance une exception personnalisée
            this.statRepository.deleteById(id);
        } catch (DeletionFailedException e) {
            throw new DeletionFailedException("Fail delete");
        }
        return true; // Renvoie true après suppression réussie    }
    }
}
