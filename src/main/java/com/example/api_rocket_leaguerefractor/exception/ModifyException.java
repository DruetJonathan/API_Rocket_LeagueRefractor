package com.example.api_rocket_leaguerefractor.exception;

public class ModifyException extends CustomException{
    public ModifyException(String message) {
        super(message);
    }

    public ModifyException(String message, Throwable cause) {
        super(message, cause);
    }
}
