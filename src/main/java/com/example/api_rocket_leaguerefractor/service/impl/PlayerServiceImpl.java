package com.example.api_rocket_leaguerefractor.service.impl;

import com.example.api_rocket_leaguerefractor.exception.DeletionFailedException;
import com.example.api_rocket_leaguerefractor.exception.RessourceNotFoundException;
import com.example.api_rocket_leaguerefractor.model.entity.Player;
import com.example.api_rocket_leaguerefractor.repository.PlayerRepository;
import com.example.api_rocket_leaguerefractor.service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indique que cette classe est un service Spring
public class PlayerServiceImpl implements PlayerService {
    PlayerRepository playerRepository; // Référence au repository pour interagir avec la base de données

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAll() {
        // Récupère la liste de tous les joueurs à partir du repository et la retourne
        return this.playerRepository.findAll();
    }

    @Override
    public Player getById(Long id) {
        // Récupère un joueur par son ID à partir du repository et le retourne s'il existe,
        // sinon lance une exception personnalisée
        return this.playerRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("player", id));
    }

    @Override
    public Player modify(Player player) {
        return this.playerRepository.save(player);
    }

    @Override
    @Transactional // Indique que cette méthode est transactionnelle
    public Player add(Player player) {
        // Ajoute un nouveau joueur à la base de données en utilisant le repository et retourne le joueur ajouté
        return this.playerRepository.save(player);
    }

    @Override
    @Transactional // Indique que cette méthode est transactionnelle
    public boolean delete(Long id) {
        try {
            // Supprime un joueur de la base de données par son ID, en cas d'échec, lance une exception personnalisée
            this.playerRepository.deleteById(id);
        } catch (DeletionFailedException e) {
            throw new DeletionFailedException("Fail delete");
        }
        return true; // Renvoie true après suppression réussie
    }

    @Override
    public List<Player> getAllPlayersById(Long[] ids) {
        // Récupère la liste des joueurs correspondant aux IDs spécifiés à partir du repository et la retourne
        return this.playerRepository.findAllById(List.of(ids));
    }
}
