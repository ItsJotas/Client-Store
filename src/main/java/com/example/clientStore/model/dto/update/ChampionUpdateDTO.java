package com.example.clientStore.model.dto.update;

import com.example.clientStore.model.enums.ChampionRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionUpdateDTO {

    private String name;
    private String title;
    private Integer role;
    private Integer bePrice;
    private Integer rpPrice;
    private Integer discount;

}
