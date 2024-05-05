package com.example.clientStore.service;

import com.example.clientStore.model.Champion;
import com.example.clientStore.model.dto.input.ChampionInputDTO;
import com.example.clientStore.repository.ChampionRepository;
import com.example.clientStore.service.exception.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.example.clientStore.model.enums.ChampionRoleEnum.getChampionRoleEnum;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Champion saveChampion(ChampionInputDTO championInputDTO) {
        Champion champion = modelMapper.map(championInputDTO, Champion.class);

        //TODO: One champion can have more than one role
        champion.setRole(getChampionRoleEnum(championInputDTO.getRole()));

        findChampionByName(champion.getId(), champion.getName());
        findChampionByTitle(champion.getId(), champion.getTitle());
        findChampionByImageUrl(champion.getId(), champion.getImageUrl());

        champion = championRepository.save(champion);
        return champion;
    }

    private void findChampionByName(Long id, String name){
        Champion champion = championRepository.findByName(name);
        if(Objects.nonNull(champion) && !Objects.equals(id, champion.getId())){
            throw new BadRequestException("This Champion name is already in use!");
        }
    }

    private void findChampionByTitle(Long id, String title){
        Champion champion = championRepository.findByTitle(title);
        if(Objects.nonNull(champion) && !Objects.equals(id, champion.getId())){
            throw new BadRequestException("This Champion title is already in use!");
        }
    }

    private void findChampionByImageUrl(Long id, String title){
        Champion champion = championRepository.findByImageUrl(title);
        if(Objects.nonNull(champion) && !Objects.equals(id, champion.getId())){
            throw new BadRequestException("This Champion image is already in use!");
        }
    }
}
