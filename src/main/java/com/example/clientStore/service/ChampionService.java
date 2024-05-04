package com.example.clientStore.service;

import com.example.clientStore.model.Champion;
import com.example.clientStore.model.dto.input.ChampionInputDTO;
import com.example.clientStore.repository.ChampionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.clientStore.model.enums.ChampionRoleEnum.getChampionRoleEnum;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Champion saveChampion(ChampionInputDTO championInputDTO) {
        Champion champion = modelMapper.map(championInputDTO, Champion.class);
        champion.setRole(getChampionRoleEnum(championInputDTO.getRole()));

        //TODO: exception for already existing name, title and imgUrl
        champion = championRepository.save(champion);
        return champion;
    }
}
