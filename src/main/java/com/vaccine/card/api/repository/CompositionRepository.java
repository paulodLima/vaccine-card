package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.CompositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CompositionRepository extends JpaRepository<CompositionEntity, Long>, CommonRepository {

    @Query(value = "select comp from CompositionEntity comp where comp.uuid = :uuid")
    Optional<CompositionEntity> findByUuid(@Param("uuid") String uuid);
}
