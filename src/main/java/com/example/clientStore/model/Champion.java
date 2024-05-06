package com.example.clientStore.model;

import com.example.clientStore.model.enums.ChampionRoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<ChampionRoleEnum> roles;

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
