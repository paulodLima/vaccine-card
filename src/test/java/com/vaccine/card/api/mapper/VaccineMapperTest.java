package com.vaccine.card.api.mapper;

import com.vaccine.card.api.dto.request.VaccineRequestDto;
import com.vaccine.card.api.dto.response.VaccineResponseDTO;
import com.vaccine.card.api.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class VaccineMapperTest {

    @Autowired
    private VaccineMapper mapper;

    @Test
    void toEntity() {

        VaccineRequestDto vaccineRequestDto = new VaccineRequestDto();
        vaccineRequestDto.setDescription("foo vaccine");
        vaccineRequestDto.setName("vaccinezera");

        ApplicationLocationEntity applicationLocationEntity = new ApplicationLocationEntity();
        BasicVaccinationEntity basicVaccinationEntity = new BasicVaccinationEntity();
        CompositionEntity compositionEntity = new CompositionEntity();
        DiseaseEntity diseaseEntity = new DiseaseEntity();
        DosageEntity dosageEntity = new DosageEntity();
        DosageEntity secondDosageEntity = new DosageEntity();
        NeedleEntity needleEntity = new NeedleEntity();
        RouteAdministrationEntity routeAdministrationEntity = new RouteAdministrationEntity();
        SideEffectEntity sideEffectEntity = new SideEffectEntity();
        ValidityAfterOpenEntity validityAfterOpenEntity = new ValidityAfterOpenEntity();

        List<DosageEntity> dosageEntities = Arrays.asList(dosageEntity, secondDosageEntity);

        VaccineEntity vaccineEntity = mapper.toEntity(vaccineRequestDto, applicationLocationEntity, basicVaccinationEntity, compositionEntity, diseaseEntity, dosageEntities, needleEntity, routeAdministrationEntity, sideEffectEntity, validityAfterOpenEntity);

        assertEquals("foo vaccine", vaccineEntity.getDescription());
        assertEquals("vaccinezera", vaccineEntity.getName());
        assertEquals(applicationLocationEntity, vaccineEntity.getApplicationLocationEntity());
        assertEquals(basicVaccinationEntity, vaccineEntity.getBasicVaccinationEntity());
        assertEquals(compositionEntity, vaccineEntity.getCompositionEntity());
        assertEquals(diseaseEntity, vaccineEntity.getDiseaseEntity());
        assertEquals(dosageEntities, vaccineEntity.getDosageEntities());
        assertEquals(needleEntity, vaccineEntity.getNeedleEntity());
        assertEquals(routeAdministrationEntity, vaccineEntity.getRouteAdministrationEntity());
        assertEquals(sideEffectEntity, vaccineEntity.getSideEffectEntity());
        assertEquals(validityAfterOpenEntity, vaccineEntity.getValidityAfterOpenEntity());
    }

    @Test
    void toResponse() {

        ApplicationLocationEntity applicationLocationEntity = new ApplicationLocationEntity();
        applicationLocationEntity.setDescription("perna");
        BasicVaccinationEntity basicVaccinationEntity = new BasicVaccinationEntity();
        basicVaccinationEntity.setDescription("1 dose");
        CompositionEntity compositionEntity = new CompositionEntity();
        compositionEntity.setDescription("virus vivo");
        DiseaseEntity diseaseEntity = new DiseaseEntity();
        diseaseEntity.setDescription("tuberculose");
        DosageEntity dosageEntity = new DosageEntity();
        dosageEntity.setDescription("16 gotas");
        RecommendedAgeEntity recommendedAgeEntity = new RecommendedAgeEntity();
        recommendedAgeEntity.setRecommendedAge(1);
        ReinforcementEntity reinforcementEntity = new ReinforcementEntity();
        reinforcementEntity.setReinforcement(24);
        dosageEntity.setRecommendedAgeEntity(recommendedAgeEntity);
        dosageEntity.setReinforcementEntity(reinforcementEntity);
        RecommendedAgeEntity secondRecommendedAgeEntity = new RecommendedAgeEntity();
        secondRecommendedAgeEntity.setRecommendedAge(4);
        ReinforcementEntity secondReinforcementEntity = new ReinforcementEntity();
        secondReinforcementEntity.setReinforcement(36);
        DosageEntity secondDosageEntity = new DosageEntity();
        secondDosageEntity.setDescription("17 gotas");
        secondDosageEntity.setRecommendedAgeEntity(secondRecommendedAgeEntity);
        secondDosageEntity.setReinforcementEntity(secondReinforcementEntity);
        NeedleEntity needleEntity = new NeedleEntity();
        needleEntity.setDescription("15 mm");


        RouteAdministrationEntity routeAdministrationEntity = new RouteAdministrationEntity();
        routeAdministrationEntity.setDescription("oral");
        SideEffectEntity sideEffectEntity = new SideEffectEntity();
        sideEffectEntity.setDescription("dor de cabeca");
        ValidityAfterOpenEntity validityAfterOpenEntity = new ValidityAfterOpenEntity();
        validityAfterOpenEntity.setDescription("1 dia");

        List<DosageEntity> dosageEntities = Arrays.asList(dosageEntity, secondDosageEntity);


        VaccineEntity vaccineEntity = new VaccineEntity();
        vaccineEntity.setApplicationLocationEntity(applicationLocationEntity);
        vaccineEntity.setBasicVaccinationEntity(basicVaccinationEntity);
        vaccineEntity.setCompositionEntity(compositionEntity);
        vaccineEntity.setDiseaseEntity(diseaseEntity);
        vaccineEntity.setDosageEntities(dosageEntities);
        vaccineEntity.setNeedleEntity(needleEntity);
        vaccineEntity.setRouteAdministrationEntity(routeAdministrationEntity);
        vaccineEntity.setSideEffectEntity(sideEffectEntity);
        vaccineEntity.setValidityAfterOpenEntity(validityAfterOpenEntity);
        vaccineEntity.setDescription("foo vaccine");
        vaccineEntity.setName("vaccinezera");

        VaccineResponseDTO vaccineResponseDTO = mapper.toResponse(vaccineEntity);

        assertEquals("foo vaccine", vaccineResponseDTO.getDescription());
        assertEquals("vaccinezera", vaccineResponseDTO.getName());
        assertEquals("perna", vaccineResponseDTO.getApplicationLocation());
        assertEquals("1 dose", vaccineResponseDTO.getBasicVaccination());
        assertEquals("virus vivo", vaccineResponseDTO.getComposition());
        assertEquals("tuberculose", vaccineResponseDTO.getDisease());
        assertEquals("16 gotas", vaccineResponseDTO.getDosages().get(0).getDescription());
        assertEquals(1, vaccineResponseDTO.getDosages().get(0).getRecommendedAge());
        assertEquals(24, vaccineResponseDTO.getDosages().get(0).getReinforcement());
        assertEquals("17 gotas", vaccineResponseDTO.getDosages().get(1).getDescription());
        assertEquals(4, vaccineResponseDTO.getDosages().get(1).getRecommendedAge());
        assertEquals(36, vaccineResponseDTO.getDosages().get(1).getReinforcement());
        assertEquals("15 mm", vaccineResponseDTO.getNeedle());
        assertEquals("oral", vaccineResponseDTO.getRouteAdministration());
        assertEquals("dor de cabeca", vaccineResponseDTO.getSideEffect());
        assertEquals("1 dia", vaccineResponseDTO.getValidityAfterOpen());

    }
}