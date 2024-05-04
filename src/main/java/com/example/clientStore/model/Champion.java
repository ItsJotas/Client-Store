package com.example.clientStore.model;

import com.example.clientStore.model.enums.ChampionRoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private ChampionRoleEnum role;

    @Column(nullable = false)
    private Integer bePrice;

    @Column(nullable = false)
    private Integer rpPrice;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false, unique = true)
    private String imageUrl;

    private Integer discount;

}
