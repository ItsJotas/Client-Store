package com.example.clientStore.model.enums;

import com.example.clientStore.service.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ChampionRoleEnum {

    None(0, "None"),
    Assassin(1, "Assassin"),
    Fighter(2, "Fighter"),
    Mage(3, "Mage"),
    Marksman(4, "Marksman"),
    Support(5, "Support"),
    Tank(6, "Tank");

    private Integer id;
    private String description;

    public static List<ChampionRoleEnum> getChampionRoleEnum(List<Integer> id){
        List<ChampionRoleEnum> roleEnumList = new ArrayList<>();

        //TODO: make a exception for same roles
        for(ChampionRoleEnum championRoleEnum : values()){
            if(Objects.nonNull(championRoleEnum) && id.contains(championRoleEnum.getId())){
                roleEnumList.add(championRoleEnum);
            }
            if(roleEnumList.size() == id.size()){
                return roleEnumList;
            }
        }

        throw new BadRequestException("Champion Role not found, please choose a valid value!");
    }
}
