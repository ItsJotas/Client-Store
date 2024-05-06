package com.example.clientStore.model.dto.output;

import com.example.clientStore.model.enums.ChampionRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionOutputDTO {

    private Long id;
    private String name;
    private String title;
    //TODO: Make an array of strings to show the roles
    private List<ChampionRoleEnum> roles;
    private Integer bePrice;
    private Integer rpPrice;
    private Integer discount;

}
