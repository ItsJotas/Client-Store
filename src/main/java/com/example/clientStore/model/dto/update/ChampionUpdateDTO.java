package com.example.clientStore.model.dto.update;

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
    //TODO: this will be a ENUM
    private String role;
    private Integer bePrice;
    private Integer rpPrice;
    private Integer discount;

}
