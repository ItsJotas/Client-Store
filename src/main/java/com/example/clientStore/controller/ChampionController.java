package com.example.clientStore.controller;

import com.example.clientStore.model.Champion;
import com.example.clientStore.model.dto.input.ChampionInputDTO;
import com.example.clientStore.model.dto.output.ChampionOutputDTO;
import com.example.clientStore.service.ChampionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Page<ChampionOutputDTO>> findAllChampions(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size,
        @RequestParam(value = "orderBy", defaultValue = "ASC") String orderBy,
        @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
        @RequestParam(name = "name", required = false) String name
    ){
        Page<ChampionOutputDTO> championOutputDTOs = championService.getAllChampions(page, size, orderBy, sortBy, name);
        return ResponseEntity.ok().body(championOutputDTOs);
    }
}
