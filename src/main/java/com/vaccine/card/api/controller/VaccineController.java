package com.vaccine.card.api.controller;

import com.vaccine.card.api.dto.filter.VaccineFilter;
import com.vaccine.card.api.dto.request.VaccineRequestDto;
import com.vaccine.card.api.dto.response.VaccineResponseDTO;
import com.vaccine.card.api.service.VaccineService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vaccine")
public class VaccineController {


    private VaccineService service;


    public VaccineController(VaccineService service) {
        this.service = service;
    }

    @PostMapping
    public VaccineResponseDTO create(@Valid @RequestBody VaccineRequestDto vaccineRequestDto) {


        return service.create(vaccineRequestDto);
    }


    @GetMapping
    public List<VaccineResponseDTO> get(VaccineFilter vaccineFilter, Pageable pageable) {


        return service.get(vaccineFilter, pageable);
    }


    @GetMapping("/{uuid}")
    public VaccineResponseDTO get(@PathVariable String uuid) {

        return service.getByUuid(uuid);
    }


}
