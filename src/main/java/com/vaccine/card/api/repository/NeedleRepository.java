package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.NeedleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NeedleRepository extends JpaRepository<NeedleEntity, Long>, CommonRepository {

    @Query(value = "select need from NeedleEntity need where need.uuid = :uuid")
    Optional<NeedleEntity> findByUuid(@Param("uuid") String uuid);
}