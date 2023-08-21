package com.example.api_rocket_leaguerefractor.model.entity.enums;

public enum Ranks {
    UNRANKED("Unranked"),
    BRONZE_I("Bronze I"), BRONZE_II("Bronze II"), BRONZE_III("Bronze III"),
    SILVER_I("Silver I"), SILVER_II("Silver II"), SILVER_III("Silver III"),
    GOLD_I("Gold I"), GOLD_II("Gold II"), GOLD_III("Gold III"),
    PLATINUM_I("Platinum I"), PLATINUM_II("Platinum II"), PLATINUM_III("Platinum III"),
    DIAMOND_I("Diamond I"), DIAMOND_II("Diamond II"), DIAMOND_III("Diamond III"),
    CHAMPION_I("Champion I"), CHAMPION_II("Champion II"), CHAMPION_III("Champion III"),
    GRAND_CHAMPION_I("Grand Champion I"), GRAND_CHAMPION_II("Grand Champion II"), GRAND_CHAMPION_III("Grand Champion III"),
    SUPERSONIC_LEGEND("Supersonic Legend");
    private final String value;
    Ranks(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
