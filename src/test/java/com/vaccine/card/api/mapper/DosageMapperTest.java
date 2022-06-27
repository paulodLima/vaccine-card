package com.vaccine.card.api.mapper;

import com.vaccine.card.api.dto.response.DosageResponseDTO;
import com.vaccine.card.api.model.DosageEntity;
import com.vaccine.card.api.model.RecommendedAgeEntity;
import com.vaccine.card.api.model.ReinforcementEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DosageMapperTest {

    private DosageMapper mapper = Mappers.getMapper(DosageMapper.class);


    @Test
    void toResponseDTO() {

        DosageEntity dosageEntity = new DosageEntity();
        dosageEntity.setDescription("16 gotas");
        RecommendedAgeEntity recommendedAgeEntity = new RecommendedAgeEntity();
        recommendedAgeEntity.setRecommendedAge(1);
        ReinforcementEntity reinforcementEntity = new ReinforcementEntity();
        reinforcementEntity.setReinforcement(24);
        dosageEntity.setRecommendedAgeEntity(recommendedAgeEntity);
        dosageEntity.setReinforcementEntity(reinforcementEntity);

        DosageResponseDTO dosageResponseDTO = mapper.toResponseDTO(dosageEntity);

        assertEquals("16 gotas", dosageResponseDTO.getDescription());
        assertEquals(1, dosageResponseDTO.getRecommendedAge());
        assertEquals(24, dosageResponseDTO.getReinforcement());

    }


    @Test
    void toResponseDTOWithNullParam() {


        DosageResponseDTO dosageResponseDTO = mapper.toResponseDTO(null);

        assertNull(dosageResponseDTO);


    }
}