package com.vaccine.card.api.service;

import com.vaccine.card.api.dto.filter.VaccineFilter;
import com.vaccine.card.api.dto.request.VaccineRequestDto;
import com.vaccine.card.api.mapper.VaccineMapper;
import com.vaccine.card.api.model.*;
import com.vaccine.card.api.repository.*;
import com.vaccine.card.api.repository.vaccine.VaccineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VaccineServiceTest {

    @Mock
    private ApplicationLocationRepository applicationLocationRepository;
    @Mock
    private BasicVaccinationRepository basicVaccinationRepository;
    @Mock
    private CompositionRepository compositionRepository;
    @Mock
    private DiseaseRepository diseaseRepository;
    @Mock
    private DosageRepository dosageRepository;
    @Mock
    private NeedleRepository needleRepository;
    @Mock
    private RouteAdministrationRepository routeAdministrationRepository;
    @Mock
    private SideEffectRepository sideEffectRepository;
    @Mock
    private ValidityAfterOpenRepository validityAfterOpenRepository;
    @Mock
    private VaccineRepository vaccineRepository;
    @Mock
    private VaccineMapper mapper;
    @InjectMocks
    private VaccineService service;

    @Test
    void create() {

        VaccineRequestDto vaccineRequestDto = new VaccineRequestDto();
        vaccineRequestDto.setApplicationLocationId("49be3d7c-2d81-4afc-9a1e-dedb6f7a5668");
        vaccineRequestDto.setBasicVaccinationId("83aa3624-98ac-4096-9725-2f291d81e70c");
        vaccineRequestDto.setCompositionId("d5f31644-9be5-4455-81c4-13b8f37f1c1c");
        vaccineRequestDto.setDiseaseId("6507d81c-161d-45e3-83f3-aa1396ae9d45");
        vaccineRequestDto.setDosageIds(Arrays.asList("9251cfe6-58f6-477e-9e2c-b79d10546889", "e12bf485-4626-41e6-9bbc-09cb7aeab931"));
        vaccineRequestDto.setNeedleId("2299b194-a2f5-48ef-bc60-3af59ab23eed");
        vaccineRequestDto.setRouteAdministrationId("1c6ce3e3-3beb-4674-bd0c-3027bccb7cdf");
        vaccineRequestDto.setSideEffectId("ce488522-1e13-4b4f-93e4-a3f8d6a32d4d");
        vaccineRequestDto.setValidityAfterOpenId("0eeb7c11-805b-4cb1-beef-3da2dc307ba4");

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

        VaccineEntity vaccineEntity = new VaccineEntity();

        vaccineEntity.setDosageEntities(dosageEntities);

        VaccineEntity vaccineEntityResponse = new VaccineEntity();

        when(applicationLocationRepository.findByUuid(anyString())).thenReturn(Optional.of(applicationLocationEntity));
        when(basicVaccinationRepository.findByUuid(anyString())).thenReturn(Optional.of(basicVaccinationEntity));
        when(compositionRepository.findByUuid(anyString())).thenReturn(Optional.of(compositionEntity));
        when(diseaseRepository.findByUuid(anyString())).thenReturn(Optional.of(diseaseEntity));
        when(dosageRepository.findByUuid("9251cfe6-58f6-477e-9e2c-b79d10546889")).thenReturn(Optional.of(dosageEntity));
        when(dosageRepository.findByUuid("e12bf485-4626-41e6-9bbc-09cb7aeab931")).thenReturn(Optional.of(secondDosageEntity));
        when(needleRepository.findByUuid(anyString())).thenReturn(Optional.of(needleEntity));
        when(routeAdministrationRepository.findByUuid(anyString())).thenReturn(Optional.of(routeAdministrationEntity));
        when(sideEffectRepository.findByUuid(anyString())).thenReturn(Optional.of(sideEffectEntity));
        when(validityAfterOpenRepository.findByUuid(anyString())).thenReturn(Optional.of(validityAfterOpenEntity));
        when(mapper.toEntity(any(), any(), any(), any(), any(), any(), any(), any(), any(), any())).thenReturn(vaccineEntity);
        when(vaccineRepository.save(any(VaccineEntity.class))).thenReturn(vaccineEntityResponse);

        service.create(vaccineRequestDto);

        verify(applicationLocationRepository, times(1)).findByUuid("49be3d7c-2d81-4afc-9a1e-dedb6f7a5668");
        verify(basicVaccinationRepository, times(1)).findByUuid("83aa3624-98ac-4096-9725-2f291d81e70c");
        verify(compositionRepository, times(1)).findByUuid("d5f31644-9be5-4455-81c4-13b8f37f1c1c");
        verify(diseaseRepository, times(1)).findByUuid("6507d81c-161d-45e3-83f3-aa1396ae9d45");
        verify(dosageRepository, times(1)).findByUuid("9251cfe6-58f6-477e-9e2c-b79d10546889");
        verify(dosageRepository, times(1)).findByUuid("e12bf485-4626-41e6-9bbc-09cb7aeab931");
        verify(needleRepository, times(1)).findByUuid("2299b194-a2f5-48ef-bc60-3af59ab23eed");
        verify(routeAdministrationRepository, times(1)).findByUuid("1c6ce3e3-3beb-4674-bd0c-3027bccb7cdf");
        verify(sideEffectRepository, times(1)).findByUuid("ce488522-1e13-4b4f-93e4-a3f8d6a32d4d");
        verify(validityAfterOpenRepository, times(1)).findByUuid("0eeb7c11-805b-4cb1-beef-3da2dc307ba4");
        verify(mapper, times(1)).toEntity(vaccineRequestDto, applicationLocationEntity, basicVaccinationEntity, compositionEntity, diseaseEntity, dosageEntities, needleEntity, routeAdministrationEntity, sideEffectEntity, validityAfterOpenEntity);
        verify(vaccineRepository, times(1)).save(vaccineEntity);
        verify(mapper, times(1)).toResponse(vaccineEntityResponse);

    }

    @Test
    void get() {

        VaccineFilter vaccineFilter = new VaccineFilter();
        vaccineFilter.setName("BCG");

        Pageable pageable = mock(Pageable.class);

        VaccineEntity vaccineEntity = new VaccineEntity();
        VaccineEntity secondVaccineEntity = new VaccineEntity();

        List<VaccineEntity> vaccineEntities = Arrays.asList(vaccineEntity, secondVaccineEntity);

        when(vaccineRepository.findAllAndFilter(any(VaccineFilter.class), any(Pageable.class))).thenReturn(vaccineEntities);

        service.get(vaccineFilter, pageable);

        verify(vaccineRepository, times(1)).findAllAndFilter(vaccineFilter, pageable);
        verify(mapper, times(1)).toResponse(vaccineEntity);
        verify(mapper, times(1)).toResponse(secondVaccineEntity);


    }

    @Test
    void getByUuid() {

        VaccineEntity vaccineEntity = new VaccineEntity();

        when(vaccineRepository.findByUuid(anyString())).thenReturn(Optional.of(vaccineEntity));

        service.getByUuid("75a7ee63-5572-4b68-bc89-88d6c87be21d");

        verify(vaccineRepository, times(1)).findByUuid("75a7ee63-5572-4b68-bc89-88d6c87be21d");
        verify(mapper, times(1)).toResponse(vaccineEntity);


    }
}