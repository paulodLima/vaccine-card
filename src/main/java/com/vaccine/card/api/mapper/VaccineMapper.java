package com.vaccine.card.api.mapper;

import com.vaccine.card.api.dto.request.VaccineRequestDto;
import com.vaccine.card.api.dto.response.DosageResponseDTO;
import com.vaccine.card.api.dto.response.VaccineResponseDTO;
import com.vaccine.card.api.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class VaccineMapper {


    @Autowired
    private DosageMapper dosageMapper;

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inclusionDate", ignore = true)
    @Mapping(target = "description", source = "vaccineRequestDto.description")
    @Mapping(target = "name", source = "vaccineRequestDto.name")
    public abstract VaccineEntity toEntity(VaccineRequestDto vaccineRequestDto, ApplicationLocationEntity applicationLocationEntity, BasicVaccinationEntity basicVaccinationEntity, CompositionEntity compositionEntity, DiseaseEntity diseaseEntity, List<DosageEntity> dosageEntities, NeedleEntity needleEntity, RouteAdministrationEntity routeAdministrationEntity, SideEffectEntity sideEffectEntity, ValidityAfterOpenEntity validityAfterOpenEntity);


    @Mapping(target = "name", source = "vaccineEntity.name")
    @Mapping(target = "uuid", source = "vaccineEntity.uuid")
    @Mapping(target = "description", source = "vaccineEntity.description")
    @Mapping(target = "applicationLocation", source = "vaccineEntity.applicationLocationEntity.description")
    @Mapping(target = "basicVaccination", source = "vaccineEntity.basicVaccinationEntity.description")
    @Mapping(target = "composition", source = "vaccineEntity.compositionEntity.description")
    @Mapping(target = "disease", source = "vaccineEntity.diseaseEntity.description")
    @Mapping(target = "dosages", source = "vaccineEntity.dosageEntities", qualifiedByName = "mappingDosages")
    @Mapping(target = "needle", source = "vaccineEntity.needleEntity.description")
    @Mapping(target = "routeAdministration", source = "vaccineEntity.routeAdministrationEntity.description")
    @Mapping(target = "sideEffect", source = "vaccineEntity.sideEffectEntity.description")
    @Mapping(target = "validityAfterOpen", source = "vaccineEntity.validityAfterOpenEntity.description")
    public abstract VaccineResponseDTO toResponse(VaccineEntity vaccineEntity);

    @Named("mappingDosages")
    List<DosageResponseDTO> mappingDosages(List<DosageEntity> dosageEntities) {

        if (CollectionUtils.isEmpty(dosageEntities)) {
            return null;
        }

        return dosageEntities.stream().map(dosageMapper::toResponseDTO).collect(Collectors.toList());

    }

}
