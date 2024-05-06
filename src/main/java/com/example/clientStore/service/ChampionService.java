package com.example.clientStore.service;

import com.example.clientStore.model.Champion;
import com.example.clientStore.model.dto.input.ChampionInputDTO;
import com.example.clientStore.model.dto.output.ChampionOutputDTO;
import com.example.clientStore.repository.ChampionRepository;
import com.example.clientStore.service.exception.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

        findChampionByName(champion.getId(), champion.getName());
        findChampionByTitle(champion.getId(), champion.getTitle());
        findChampionByImageUrl(champion.getId(), champion.getImageUrl());

        //TODO: exception: a champion price cannot be 0

        //TODO: this is saving a null value
        champion.getRoles().addAll(0, getChampionRoleEnum(championInputDTO.getRoles()));

        champion = championRepository.save(champion);
        return champion;
    }

    public Page<ChampionOutputDTO> getAllChampions(Integer page, Integer size, String orderBy, String sortBy, String name) {

        Sort sort = orderBy.equals("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(page, size, sort);

        //TODO: filter by role

        Page<Champion> champions = championRepository.findAllFilter(pageable, name);
        Page<ChampionOutputDTO> championOutputDTOs = champions.map(c -> modelMapper.map(c, ChampionOutputDTO.class));

        return championOutputDTOs;
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
