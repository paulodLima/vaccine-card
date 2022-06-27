package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.CommonEntity;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommonRepository {

    <T extends CommonEntity> Optional<T> findByUuid(@Param("uuid") String uuid);

}
