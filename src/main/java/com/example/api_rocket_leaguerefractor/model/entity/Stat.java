package com.example.api_rocket_leaguerefractor.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Embeddable // Indique que cette classe est une entité JPA
@Getter // Lombok annotation pour générer automatiquement les méthodes getters
@Setter // Lombok annotation pour générer automatiquement les méthodes setters
@Table(name = "Stats") // Spécifie le nom de la table associée dans la base de données
public class Stat {
    private Integer wins; // Nombre de victoires
    private Integer goals; // Nombre de buts marqués
    private Integer assists; // Nombre de passes décisives
    private Integer mvps; // Nombre de fois où le joueur a été désigné MVP
    private Integer shots; // Nombre de tirs effectués
    private Integer saves; // Nombre de tirs sauvés
    private LocalDate dateInserted; // Nouvel attribut pour stocker la date d'insertion dans les statistiques
}

