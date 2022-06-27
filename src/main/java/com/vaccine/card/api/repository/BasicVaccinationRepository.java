package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.BasicVaccinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasicVaccinationRepository extends JpaRepository<BasicVaccinationEntity, Long>, CommonRepository {

    @Query(value = "select basic from BasicVaccinationEntity basic where basic.uuid = :uuid")
    Optional<BasicVaccinationEntity> findByUuid(@Param("uuid") String uuid);


}
