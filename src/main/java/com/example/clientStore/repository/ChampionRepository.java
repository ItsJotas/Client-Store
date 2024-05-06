package com.example.clientStore.repository;

import com.example.clientStore.model.Champion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Champion findByName(String name);

    Champion findByTitle(String title);

    Champion findByImageUrl(String title);

    @Query(value = "SELECT * FROM champion c " +
            "WHERE ((:name IS NULL) or c.name LIKE CONCAT(:name,'%')) ",
            nativeQuery = true)
    Page<Champion> findAllFilter(
            PageRequest pageable,
            @Param("name") String name);
}
