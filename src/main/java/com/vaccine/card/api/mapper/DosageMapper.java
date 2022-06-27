package com.vaccine.card.api.mapper;

import com.vaccine.card.api.dto.response.DosageResponseDTO;
import com.vaccine.card.api.model.DosageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class DosageMapper {

    @Mapping(target = "recommendedAge", source = "dosageEntity.recommendedAgeEntity.recommendedAge")
    @Mapping(target = "reinforcement", source = "dosageEntity.reinforcementEntity.reinforcement")
    public abstract DosageResponseDTO toResponseDTO(DosageEntity dosageEntity);

}
