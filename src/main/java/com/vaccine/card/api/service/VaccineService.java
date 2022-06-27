package com.vaccine.card.api.service;

import com.vaccine.card.api.dto.filter.VaccineFilter;
import com.vaccine.card.api.dto.request.VaccineRequestDto;
import com.vaccine.card.api.dto.response.VaccineResponseDTO;
import com.vaccine.card.api.exception.MessageErrorImpl;
import com.vaccine.card.api.mapper.VaccineMapper;
import com.vaccine.card.api.model.*;
import com.vaccine.card.api.repository.*;
import com.vaccine.card.api.repository.vaccine.VaccineRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.vaccine.card.api.util.MessagesUtil.getMessage;

@Service
public class VaccineService {

    private ApplicationLocationRepository applicationLocationRepository;
    private BasicVaccinationRepository basicVaccinationRepository;
    private CompositionRepository compositionRepository;
    private DiseaseRepository diseaseRepository;
    private DosageRepository dosageRepository;
    private NeedleRepository needleRepository;
    private RouteAdministrationRepository routeAdministrationRepository;
    private SideEffectRepository sideEffectRepository;
    private ValidityAfterOpenRepository validityAfterOpenRepository;
    private VaccineRepository vaccineRepository;
    private VaccineMapper mapper;

    public VaccineService(ApplicationLocationRepository applicationLocationRepository, BasicVaccinationRepository basicVaccinationRepository, CompositionRepository compositionRepository, DiseaseRepository diseaseRepository, DosageRepository dosageRepository, NeedleRepository needleRepository, RecommendedAgeRepository recommendedAgeRepository, ReinforcementRepository reinforcementRepository, RouteAdministrationRepository routeAdministrationRepository, SideEffectRepository sideEffectRepository, ValidityAfterOpenRepository validityAfterOpenRepository, VaccineRepository vaccineRepository, VaccineMapper mapper) {
        this.applicationLocationRepository = applicationLocationRepository;
        this.basicVaccinationRepository = basicVaccinationRepository;
        this.compositionRepository = compositionRepository;
        this.diseaseRepository = diseaseRepository;
        this.dosageRepository = dosageRepository;
        this.needleRepository = needleRepository;
        this.routeAdministrationRepository = routeAdministrationRepository;
        this.sideEffectRepository = sideEffectRepository;
        this.validityAfterOpenRepository = validityAfterOpenRepository;
        this.vaccineRepository = vaccineRepository;
        this.mapper = mapper;
    }

    public VaccineResponseDTO create(VaccineRequestDto vaccineRequestDto) {

        ApplicationLocationEntity applicationLocationEntity = applicationLocationRepository.findByUuid(vaccineRequestDto.getApplicationLocationId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.APPLICATION_LOCATION))));
        BasicVaccinationEntity basicVaccinationEntity = basicVaccinationRepository.findByUuid(vaccineRequestDto.getBasicVaccinationId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.BASIC_VACCINATION))));
        CompositionEntity compositionEntity = compositionRepository.findByUuid(vaccineRequestDto.getCompositionId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.COMPOSITION))));
        DiseaseEntity diseaseEntity = diseaseRepository.findByUuid(vaccineRequestDto.getDiseaseId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.DISEASE))));
        List<DosageEntity> dosageEntities = vaccineRequestDto.getDosageIds().stream().map(x -> dosageRepository.findByUuid(x).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.DOSAGE))))).collect(Collectors.toList());
        NeedleEntity needleEntity = needleRepository.findByUuid(vaccineRequestDto.getNeedleId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.NEEDLE))));
        RouteAdministrationEntity routeAdministrationEntity = routeAdministrationRepository.findByUuid(vaccineRequestDto.getRouteAdministrationId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.ADMINISTRATION_ROUTE))));
        SideEffectEntity sideEffectEntity = sideEffectRepository.findByUuid(vaccineRequestDto.getSideEffectId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.SIDE_EFFECT))));
        ValidityAfterOpenEntity validityAfterOpenEntity = validityAfterOpenRepository.findByUuid(vaccineRequestDto.getValidityAfterOpenId()).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.VALIDITY_AFTER_OPEN))));

        VaccineEntity vaccineEntity = mapper.toEntity(vaccineRequestDto, applicationLocationEntity, basicVaccinationEntity, compositionEntity, diseaseEntity, dosageEntities, needleEntity, routeAdministrationEntity, sideEffectEntity, validityAfterOpenEntity);

        return mapper.toResponse(vaccineRepository.save(vaccineEntity));

    }

    public List<VaccineResponseDTO> get(VaccineFilter vaccineFilter, Pageable pageable) {


        return vaccineRepository.findAllAndFilter(vaccineFilter, pageable).stream().map(mapper::toResponse).collect(Collectors.toList());
    }


    public VaccineResponseDTO getByUuid(String uuid) {

        return mapper.toResponse(vaccineRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.VACCINE)))));
    }
}
