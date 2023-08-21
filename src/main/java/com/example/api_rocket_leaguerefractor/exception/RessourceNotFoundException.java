package com.example.api_rocket_leaguerefractor.exception;

public class RessourceNotFoundException extends CustomException{
    public RessourceNotFoundException(String ressourceName,Long ressourceId) {
        super("Erreur durant la suppresion de "+ressourceName+" possedant l'id -> "+ressourceId);
    }

    public RessourceNotFoundException(String message) {
        super(message);
    }
}
