package com.example.api_rocket_leaguerefractor.service;


import com.example.api_rocket_leaguerefractor.model.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAll();
    Player getById(Long id);
    Player add(Player player);
    Player modify(Player player);
    boolean delete(Player player);
    List<Player> getAllPlayersById(Long[] ids);

}
