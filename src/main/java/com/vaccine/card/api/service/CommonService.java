package com.vaccine.card.api.service;

import com.vaccine.card.api.dto.response.CommonResponseDTO;
import com.vaccine.card.api.exception.MessageErrorImpl;
import com.vaccine.card.api.mapper.CommonMapper;
import com.vaccine.card.api.model.CommonEntity;
import com.vaccine.card.api.repository.CommonRepository;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import static com.vaccine.card.api.util.MessagesUtil.getMessage;

public class CommonService {

    private CommonRepository repository;
    private CommonMapper mapper;

    public CommonService(CommonRepository repository, CommonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    CommonResponseDTO findByUuid(String uuid) {

        return mapper.toResponseDTO(repository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException(getMessage(MessageErrorImpl.RESOURCE_NOT_FOUND, getMessage(MessageErrorImpl.RESOURCE)))));

    }

    public List<CommonResponseDTO> findAll() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {


        Method method = repository.getClass().getMethod("findAll");

        Object invoke = method.invoke(repository);

        List<CommonEntity> commonEntities = (List<CommonEntity>) invoke;

        return commonEntities.stream().map(mapper::toResponseDTO).collect(Collectors.toList());

    }
}
