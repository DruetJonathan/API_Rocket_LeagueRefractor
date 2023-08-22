package com.example.api_rocket_leaguerefractor.model.entity.dto;

import com.example.api_rocket_leaguerefractor.model.entity.Team;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TeamAddFormDTO {
    private Long id;
    private String teamName;

    public static List<TeamAddFormDTO> toDTO(List<Team> all) {
        ArrayList<TeamAddFormDTO> teamAddFormDTOS = new ArrayList<>();
        for (int i = 0; i <= all.size()-1; i++) {
            TeamAddFormDTO teamAddFormDTO = new TeamAddFormDTO();
            Team team = all.get(i);

            teamAddFormDTO.setId(team.getId());
            teamAddFormDTO.setTeamName(team.getTeamName());
            teamAddFormDTOS.add(teamAddFormDTO);
        }
        System.out.println(teamAddFormDTOS.toString());
        return teamAddFormDTOS;
    }
}
