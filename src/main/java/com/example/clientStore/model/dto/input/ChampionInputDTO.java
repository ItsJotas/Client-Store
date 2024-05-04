package com.example.clientStore.model.dto.input;

import com.example.clientStore.model.enums.ChampionRoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChampionInputDTO {

    @NotNull(message = "The Name field is required!")
    @NotBlank(message = "The Name field cannot be empty!")
    private String name;

    @NotNull(message = "The Title field is required!")
    @NotBlank(message = "The Title field cannot be empty!")
    private String title;

    @NotNull(message = "The Role field is required!")
    private Integer role;

    @NotNull(message = "The Blue Essence Price field is required!")
    private Integer bePrice;

    @NotNull(message = "The RpPrice field is required!")
    private Integer rpPrice;

    @NotNull(message = "The Release Date field is required!")
    private LocalDate releaseDate;

    @NotNull(message = "The Image URL field is required!")
    @NotBlank(message = "The Image URL Date cannot be empty!")
    private String imageUrl;
}
