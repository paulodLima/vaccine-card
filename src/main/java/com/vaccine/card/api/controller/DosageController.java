package com.vaccine.card.api.controller;

import com.vaccine.card.api.dto.response.DosageResponseDTO;
import com.vaccine.card.api.service.DosageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/dosage")
public class DosageController {

    private DosageService service;


    public DosageController(DosageService service) {
        this.service = service;
    }

    @GetMapping
    public List<DosageResponseDTO> get() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        return service.findAll();

    }
}
