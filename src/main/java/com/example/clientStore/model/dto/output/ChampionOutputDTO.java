package com.example.clientStore.model.dto.output;

import com.example.clientStore.model.enums.ChampionRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionOutputDTO {

    private Long id;
    private String name;
    private String title;
    private ChampionRoleEnum role;
    private Integer bePrice;
    private Integer rpPrice;
    private Integer discount;

}
