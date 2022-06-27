package com.vaccine.card.api.service;

import com.vaccine.card.api.dto.response.DosageResponseDTO;
import com.vaccine.card.api.exception.MessageErrorImpl;
import com.vaccine.card.api.mapper.DosageMapper;
import com.vaccine.card.api.repository.DosageRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static com.vaccine.card.api.util.MessagesUtil.getMessage;

@Service
public class DosageService {

    private DosageRepository repository;
    private DosageMapper mapper;

    public DosageService(DosageRepository repository, DosageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    DosageResponseDTO findByUuid(String uuid) {

        return mapper.toResponseDTO(repository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.RESOURCE)))));

    }

    public List<DosageResponseDTO> findAll() {


        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());

    }


}
