package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.SideEffectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SideEffectRepository extends JpaRepository<SideEffectEntity, Long>, CommonRepository {

    @Query(value = "select side from SideEffectEntity side where side.uuid = :uuid")
    Optional<SideEffectEntity> findByUuid(@Param("uuid") String uuid);


}
