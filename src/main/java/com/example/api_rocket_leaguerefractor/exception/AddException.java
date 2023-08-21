package com.example.api_rocket_leaguerefractor.exception;

public class AddException extends CustomException{
    public AddException(String message) {
        super(message);
    }

    public AddException(String message, Throwable cause) {
        super(message, cause);
    }
}
