package com.example.api_rocket_leaguerefractor.controller;

import com.example.api_rocket_leaguerefractor.exception.AddException;
import com.example.api_rocket_leaguerefractor.exception.ModifyException;
import com.example.api_rocket_leaguerefractor.model.entity.Team;
import com.example.api_rocket_leaguerefractor.model.form.TeamForm;
import com.example.api_rocket_leaguerefractor.service.PlayerService;
import com.example.api_rocket_leaguerefractor.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indique que cette classe est un contrôleur REST
@CrossOrigin("*") // Permet les requêtes cross-origin de toutes les origines
public class TeamController {
    TeamService teamService; // Service pour gérer les opérations liées aux équipes
    PlayerService playerService; // Service pour gérer les opérations liées aux joueurs

    public TeamController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @GetMapping("/teams") // Endpoint pour récupérer la liste des équipes
    public ResponseEntity<List<Team>> getTeams() {
        // Renvoie une réponse avec la liste de toutes les équipes récupérée depuis le service
        List<Team> all = this.teamService.getAll();
        if (all.isEmpty())
            return ResponseEntity.ok(all);
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/team/{id}") // Endpoint pour récupérer une équipe par ID
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
        // Récupère l'équipe par son ID depuis le service, renvoie 200 OK si trouvée, 404 NOT FOUND sinon
        Team team = teamService.getById(id);
        if (team != null) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/team/modify/{id}") // Endpoint pour mettre à jour une équipe
    public ResponseEntity<Team> updateTeam(@RequestBody @Valid Team team, @PathVariable Long id) {
        // Met à jour l'équipe en utilisant les données reçues, renvoie la version mise à jour
        try {
            Team modify = this.teamService.modify(team);
            if (modify != null){
                return ResponseEntity.ok(modify);
            }else{
                return ResponseEntity.notFound().build();
            }
        }catch (ModifyException e){
            return ResponseEntity.badRequest().build();
        }


    }

    @PostMapping("/team/add") // Endpoint pour ajouter une nouvelle équipe
    public ResponseEntity<Team> addTeam(@RequestBody @Valid TeamForm toAdd) {
        // Crée une nouvelle équipe en utilisant les données reçues, renvoie la nouvelle équipe ajoutée
        try {
            Team team = new Team();
            team.setCaptain(this.playerService.getById(toAdd.getCaptain()));
            team.setPlayers(this.playerService.getAllPlayersById(toAdd.getPlayers()));
            if (team != null){
                return ResponseEntity.ok(this.teamService.add(toAdd.toEntity()));
            }else{
                return ResponseEntity.internalServerError().build();
            }
        }catch (AddException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/team/delete/{id}") // Endpoint pour supprimer une équipe
    public ResponseEntity<Boolean> deleteTeam(@PathVariable Long id) {
        // Supprime l'équipe par son ID, renvoie true si réussi, 400 BAD REQUEST sinon
        boolean delete = this.teamService.delete(id);
        if (delete)
            return ResponseEntity.ok(delete);
        else
            return ResponseEntity.internalServerError().build();
    }
}
