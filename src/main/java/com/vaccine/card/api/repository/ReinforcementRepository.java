package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.ReinforcementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReinforcementRepository extends JpaRepository<ReinforcementEntity, Long>, CommonRepository {

    @Query(value = "select reinf from ReinforcementEntity reinf where reinf.uuid = :uuid")
    Optional<ReinforcementEntity> findByUuid(@Param("uuid") String uuid);
}
