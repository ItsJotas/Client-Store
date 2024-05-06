package com.example.clientStore.controller;

import com.example.clientStore.model.Champion;
import com.example.clientStore.model.dto.input.ChampionInputDTO;
import com.example.clientStore.model.dto.output.ChampionOutputDTO;
import com.example.clientStore.service.ChampionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/store/champion")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @PostMapping
    public ResponseEntity<?> createChampion(@RequestBody @Valid ChampionInputDTO championInputDTO){
        Champion champion = championService.saveChampion(championInputDTO);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/store/champion/{id}")
                .buildAndExpand(champion.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<Champion>> findAllChampions(){
        List<Champion> champions = championService.getAllChampions();
        return ResponseEntity.ok().body(champions);
    }
}
