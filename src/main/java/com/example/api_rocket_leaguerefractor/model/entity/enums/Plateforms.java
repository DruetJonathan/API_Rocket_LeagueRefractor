package com.example.api_rocket_leaguerefractor.model.entity.enums;

public enum Plateforms {
    PC("PC"),
    PLAYSTATION_4("PlayStation 4"),
    XBOX_ONE("Xbox One"),

    NINTENDO_SWITCH("Nintendo Switch");

    private final String name;

    Plateforms(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
