package com.example.api_rocket_leaguerefractor.exception;

public class DeletionFailedException extends CustomException{

    public DeletionFailedException(String ressourceName, Long ressourceId) {
        super("Erreur durant la suppresion de "+ressourceName+" possedant l'id -> "+ressourceId);
    }

    public DeletionFailedException(String failDelete) {
        super(failDelete);
    }
}
