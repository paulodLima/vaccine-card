package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.DiseaseEntity;
import com.vaccine.card.api.model.DosageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DosageRepository extends JpaRepository<DosageEntity, Long>, CommonRepository {

    @Query(value = "select dis from DosageEntity dis where dis.uuid = :uuid")
    Optional<DosageEntity> findByUuid(@Param("uuid") String uuid);
}
