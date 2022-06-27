package com.vaccine.card.api.mapper;

import com.vaccine.card.api.dto.response.CommonResponseDTO;
import com.vaccine.card.api.model.CommonEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.spy;

class CommonMapperTest {

    private CommonMapper mapper = Mappers.getMapper(CommonMapper.class);


    @Test
    void toResponseDTO() {

        CommonEntity commonEntity = spy(CommonEntity.class);
        commonEntity.setDescription("PEDACAOZERA");
        commonEntity.setUuid("sadsadsa321321321");

        CommonResponseDTO commonResponseDTO = mapper.toResponseDTO(commonEntity);

        assertEquals(commonEntity.getDescription(), commonResponseDTO.getDescription());
        assertEquals(commonEntity.getUuid(), commonResponseDTO.getUuid());
    }


    @Test
    void toResponseDTOWithNullSource() {


        CommonResponseDTO commonResponseDTO = mapper.toResponseDTO(null);

        assertNull(commonResponseDTO);
    }
}