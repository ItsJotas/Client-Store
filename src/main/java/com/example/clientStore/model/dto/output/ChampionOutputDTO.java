package com.example.clientStore.model.dto.output;

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
    //TODO: this will be a ENUM
    private String role;
    private Integer bePrice;
    private Integer rpPrice;
    private Integer discount;

}
