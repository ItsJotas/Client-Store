package com.example.clientStore.repository;

import com.example.clientStore.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Champion findByName(String name);

    Champion findByTitle(String title);

    Champion findByImageUrl(String title);
}
