package com.example.clientStore.model.enums;

import com.example.clientStore.service.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ChampionRoleEnum {

    Assassin(1, "Assassin"),
    Fighter(2, "Fighter"),
    Mage(3, "Mage"),
    Marksman(4, "Marksman"),
    Support(5, "Support"),
    Tank(6, "Tank");

    private Integer id;
    private String description;

    public static ChampionRoleEnum getChampionRoleEnum(Integer id){
        for(ChampionRoleEnum championRoleEnum : values()){
            if(championRoleEnum.id.equals(id)){
                return championRoleEnum;
            }
        }
        throw new BadRequestException("Champion Role not found, please choose a valid value!");
    }
}
