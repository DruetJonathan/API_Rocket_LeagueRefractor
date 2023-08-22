package com.example.api_rocket_leaguerefractor.model.entity;

import com.example.api_rocket_leaguerefractor.model.entity.enums.Plateforms;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter // Lombok annotation pour générer automatiquement les méthodes getters
@Setter // Lombok annotation pour générer automatiquement les méthodes setters
@Entity // Indique que cette classe est une entité JPA
@Table(name = "Players") // Spécifie le nom de la table associée dans la base de données
public class Player {
    @Id // Indique que cet attribut est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Utilise une stratégie d'auto-incrémentation pour générer les valeurs de la clé primaire
    private Long id; // Identifiant unique du joueur

    private String pseudo; // Pseudo du joueur

    @ElementCollection // Indique une relation "élément-collection", utile pour stocker une liste d'objets complexes
    private List<Rank> ranks; // Liste des rangs et divisions du joueur

    private Plateforms plateform; // Plateforme à laquelle le joueur appartient

    @ElementCollection // Permet de mettre à jour les stats lorsqu'elles sont mises à jour pour le joueur
    private List<Stat> stats; // Liste pour stocker l'historique des stats


    @ManyToOne // Relation Many-to-One avec la classe Team, indiquant qu'un joueur appartient à une équipe
    @JoinColumn(name = "team_id") // Colonne dans la table Players qui stockera la clé étrangère vers l'équipe
    @JsonIgnore // Ignorer cette propriété lors de la sérialisation JSON pour éviter des références cycliques
    private Team team; // L'équipe à laquelle le joueur appartient
}
