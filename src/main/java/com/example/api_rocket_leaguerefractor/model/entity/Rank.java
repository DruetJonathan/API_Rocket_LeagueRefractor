package com.example.api_rocket_leaguerefractor.model.entity;

import com.example.api_rocket_leaguerefractor.model.entity.enums.Divisions;
import com.example.api_rocket_leaguerefractor.model.entity.enums.Ranks;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Embeddable // Indique que cette classe sera utilisée comme composant incorporable dans une autre entité
@Getter // Lombok annotation pour générer automatiquement les méthodes getters
@Setter // Lombok annotation pour générer automatiquement les méthodes setters
@Table(name = "Ranks") // Spécifie le nom de la table associée dans la base de données
public class Rank {
    @Enumerated(EnumType.STRING) // Indique que l'attribut sera stocké sous forme de chaîne dans la base de données
    private Ranks rank; // Le rang du joueur

    @Enumerated(EnumType.STRING) // Indique que l'attribut sera stocké sous forme de chaîne dans la base de données
    private Divisions division; // La division du joueur
}