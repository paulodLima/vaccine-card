package com.vaccine.card.api.controller;

import com.vaccine.card.api.dto.response.CommonResponseDTO;
import com.vaccine.card.api.mapper.CommonMapper;
import com.vaccine.card.api.repository.ValidityAfterOpenRepository;
import com.vaccine.card.api.service.CommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/validity-after-open")
public class ValidityAfterOpenController {

    private CommonService service;

    public ValidityAfterOpenController(CommonMapper mapper, ValidityAfterOpenRepository repository) {
        this.service = new CommonService(repository, mapper);
    }


    @GetMapping
    public List<CommonResponseDTO> get() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        return service.findAll();

    }
}
