package com.example.api_rocket_leaguerefractor.controller;

import com.example.api_rocket_leaguerefractor.exception.AddException;
import com.example.api_rocket_leaguerefractor.exception.ModifyException;
import com.example.api_rocket_leaguerefractor.model.entity.Player;
import com.example.api_rocket_leaguerefractor.model.entity.dto.PlayerSeeAllDTO;
import com.example.api_rocket_leaguerefractor.model.form.PlayerAddForm;
import com.example.api_rocket_leaguerefractor.service.PlayerService;
import com.example.api_rocket_leaguerefractor.service.TeamService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Permet les requêtes cross-origin
@CrossOrigin("*")

// Indique que c'est un contrôleur Spring géré par Spring MVC
@RestController

// Génère automatiquement des logs SLF4J
@Slf4j
public class PlayerController {

    // Injection des services nécessaires
    private final PlayerService playerService;
    private final TeamService teamService;

    // Constructeur pour injecter les services
    public PlayerController(
            PlayerService playerService,
            TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    // Point de terminaison pour obtenir la liste de tous les joueurs
    @RequestMapping("/players/see")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> all = this.playerService.getAll();
        List<PlayerSeeAllDTO> allDTOS = new ArrayList<>();
        for (int i = 0; i < all.size()-1; i++) {
            allDTOS.add(Player.toDto(all.get(i)));
            System.out.println(allDTOS.get(i).toString());
        }
        if (!all.isEmpty()) {
            // Retourne une réponse avec le code 200 (OK) et la liste de joueurs

            return ResponseEntity.status(200).body(all);
        } else {
            // Retourne une réponse avec le code 204 (No Content) car la liste est vide
            return ResponseEntity.noContent().build();
        }
    }

    // Point de terminaison pour obtenir les détails d'un joueur par son ID
    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        Player player = playerService.getById(id);
        if (player != null) {
            // Retourne une réponse avec le code 200 (OK) et les détails du joueur
            return ResponseEntity.ok(player);
        } else {
            // Retourne une réponse avec le code 404 (Not Found) car le joueur n'existe pas
            return ResponseEntity.notFound().build();
        }
    }

    // Point de terminaison pour modifier les détails d'un joueur par son ID
    @PostMapping("/player/modify/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody @Valid PlayerAddForm playerDTO, @PathVariable Long id) {
        try {
            Player modify = this.playerService.modify(playerDTO.toEntity());
            if (modify != null) {
                // Retourne une réponse avec le code 200 (OK) et les détails du joueur modifié
                return ResponseEntity.ok(modify);
            } else {
                // Retourne une réponse avec le code 404 (Not Found) car le joueur n'a pas pu être modifié
                return ResponseEntity.notFound().build();
            }
        } catch (ModifyException e) {
            // Retourne une réponse avec le code 400 (Bad Request) en cas d'erreur de modification
            return ResponseEntity.badRequest().build();
        }
    }

    // Point de terminaison pour ajouter un nouveau joueur
    @PostMapping("/player/add")
    public ResponseEntity<Player> addPlayer(@RequestBody @Valid PlayerAddForm toAdd) {
        try {
            Player player = toAdd.toEntity();
            player.setTeam(teamService.getById(toAdd.getTeamId()));
            Player add = this.playerService.add(player);
            if (add != null) {
                // Retourne une réponse avec le code 200 (OK) et les détails du joueur ajouté
                return ResponseEntity.ok(add);
            } else {
                // Retourne une réponse avec le code 500 (Internal Server Error) en cas d'erreur interne
                return ResponseEntity.notFound().build();
            }
        } catch (AddException addException) {
            // Retourne une réponse avec le code 400 (Bad Request) en cas d'erreur d'ajout
            return ResponseEntity.badRequest().build();
        }
    }

    // Point de terminaison pour supprimer un joueur par son ID
    @DeleteMapping("/player/delete/{id}")
    public ResponseEntity<Boolean> deletePlayer(@PathVariable Long id) {
        Player byId = playerService.getById(id);
        boolean delete = this.playerService.delete(byId);

        if (delete) {
            // Retourne une réponse avec le code 200 (OK) en cas de suppression réussie
            return ResponseEntity.ok(true);
        } else {
            // Retourne une réponse avec le code 500 (Internal Server Error) en cas d'erreur interne
            return ResponseEntity.internalServerError().build();
        }
    }
}
