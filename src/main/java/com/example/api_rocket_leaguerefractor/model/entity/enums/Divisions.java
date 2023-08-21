package com.example.api_rocket_leaguerefractor.model.entity.enums;

public enum Divisions {
    UNRANKED("UNRANKED"),
    DIVISION_I("Division 1"), DIVISION_II("Division 2"), DIVISION_III("Division 3"), DIVISION_IV("Division 4");

    private final String value;

    Divisions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
