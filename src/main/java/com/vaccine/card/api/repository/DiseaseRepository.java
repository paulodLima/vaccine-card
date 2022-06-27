package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Long>, CommonRepository {

    @Query(value = "select dis from DiseaseEntity dis where dis.uuid = :uuid")
    Optional<DiseaseEntity> findByUuid(@Param("uuid") String uuid);
}
