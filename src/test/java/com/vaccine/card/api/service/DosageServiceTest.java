package com.vaccine.card.api.service;

import com.vaccine.card.api.mapper.DosageMapper;
import com.vaccine.card.api.model.DosageEntity;
import com.vaccine.card.api.repository.DosageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DosageServiceTest {

    @Mock
    private DosageRepository repository;

    @Mock
    private DosageMapper mapper;

    @InjectMocks
    private DosageService service;

    @Test
    void findByUuid() {

        DosageEntity dosageEntity = new DosageEntity();

        when(repository.findByUuid(anyString())).thenReturn(Optional.of(dosageEntity));

        service.findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");

        verify(repository, times(1)).findByUuid("45b7d9a5-c2f1-4332-9e4e-d11733f67ce0");
        verify(mapper, times(1)).toResponseDTO(dosageEntity);

    }

    @Test
    void findAll() {

        DosageEntity dosageEntity = new DosageEntity();
        DosageEntity secondDosageEntity = new DosageEntity();

        when(repository.findAll()).thenReturn(Arrays.asList(dosageEntity, secondDosageEntity));

        service.findAll();

        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).toResponseDTO(dosageEntity);
        verify(mapper, times(1)).toResponseDTO(secondDosageEntity);
    }

}