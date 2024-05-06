package com.example.clientStore.model.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionUpdateDTO {

    private String name;
    private String title;
    private List<Integer> roles;
    private Integer bePrice;
    private Integer rpPrice;
    private Integer discount;

}
