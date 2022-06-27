package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.ValidityAfterOpenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ValidityAfterOpenRepository extends JpaRepository<ValidityAfterOpenEntity, Long>, CommonRepository {

    @Query(value = "select validity from ValidityAfterOpenEntity validity where validity.uuid = :uuid")
    Optional<ValidityAfterOpenEntity> findByUuid(@Param("uuid") String uuid);
}
