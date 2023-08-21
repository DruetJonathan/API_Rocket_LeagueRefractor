package com.example.api_rocket_leaguerefractor.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter // Lombok annotation pour générer automatiquement les méthodes getters
@Setter // Lombok annotation pour générer automatiquement les méthodes setters
@Entity // Indique que cette classe est une entité JPA
@Table(name = "Teams") // Spécifie le nom de la table associée dans la base de données
public class Team {
    @Id // Indique que cet attribut est la clé primaire de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Utilise une stratégie d'auto-incrémentation pour générer les valeurs de la clé primaire
    private Long id; // Identifiant unique de l'équipe

    private String teamName; // Nom de l'équipe

    @OneToMany(mappedBy = "team") // Relation One-to-Many avec la classe Player, "team" fait référence à l'attribut "team" dans la classe Player
    private List<Player> players; // Liste des joueurs appartenant à cette équipe

    @ManyToOne // Relation Many-to-One avec la classe Player, indiquant qu'un capitaine appartient à une équipe
    @JoinColumn(name = "captain_id") // Colonne dans la table Teams qui stockera la clé étrangère vers le capitaine
    private Player captain; // Le capitaine de cette équipe
}