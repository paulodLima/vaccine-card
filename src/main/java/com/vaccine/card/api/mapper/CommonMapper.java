package com.vaccine.card.api.mapper;

import com.vaccine.card.api.dto.response.CommonResponseDTO;
import com.vaccine.card.api.model.CommonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CommonMapper {

    public abstract CommonResponseDTO toResponseDTO(CommonEntity simpleEntity);
}
