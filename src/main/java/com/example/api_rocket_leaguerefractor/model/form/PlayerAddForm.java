package com.example.api_rocket_leaguerefractor.model.form;

import com.example.api_rocket_leaguerefractor.model.entity.Player;
import com.example.api_rocket_leaguerefractor.model.entity.Rank;
import com.example.api_rocket_leaguerefractor.model.entity.Stat;
import com.example.api_rocket_leaguerefractor.model.entity.enums.Plateforms;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data // Lombok annotation pour générer automatiquement les méthodes getters, setters, equals, hashCode, et toString
public class PlayerAddForm {
    @NotBlank(message = "Le pseudo ne peut pas être vide et doit contenir entre {min} et {max} caractères.")
    @Size(min = 3, max = 32, message = "Le pseudo doit contenir entre {min} et {max} caractères.")
    private String pseudo; // Pseudo du joueur, doit être non vide et respecter la taille spécifiée

    @NotEmpty(message = "La liste des ranks ne peut pas être vide")
    private List<Rank> ranks; // Liste des rangs et divisions du joueur, ne peut pas être vide

    @NotEmpty(message = "La plateforme ne peut pas être vide")
    private Plateforms plateform; // Plateforme à laquelle le joueur appartient, ne peut pas être vide

    @NotEmpty(message = "Les stats ne peuvent pas être vide")
    private Stat stats;

    @NotEmpty(message = "L'id de la team ne peut pas être vide")
    private Long teamId; // Identifiant de l'équipe à laquelle le joueur appartient, ne peut pas être vide

    // Méthode pour convertir PlayerAddForm en instance de Player
    public Player toEntity() {
        // Crée une nouvelle instance de la classe Player
        Player player = new Player();

        // Copie la valeur du pseudo depuis le formulaire vers l'instance de Player
        player.setPseudo(this.getPseudo());

        // Copie la liste des rangs depuis le formulaire vers l'instance de Player
        player.setRanks(this.getRanks());

        // Copie la plateforme depuis le formulaire vers l'instance de Player
        player.setPlateform(this.getPlateform());

        // Crée une nouvelle liste pour stocker les statistiques du joueur
        ArrayList<Stat> listStats = new ArrayList<>();

        // Ajoute les statistiques depuis le formulaire à la liste de statistiques
        listStats.add(stats);

        // Copie la liste de statistiques depuis la liste temporaire vers l'instance de Player
        player.setStats(listStats);
        // Retourne l'instance de Player basée sur les données de ce formulaire
        // TODO SET TEAM DANS LE SERVICE OU LE CONTROLLER
        return player;
    }
}