package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.ApplicationLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ApplicationLocationRepository extends JpaRepository<ApplicationLocationEntity, Long>, CommonRepository {

    @Query(value = "select location from ApplicationLocationEntity location where location.uuid = :uuid")
    Optional<ApplicationLocationEntity> findByUuid(@Param("uuid") String uuid);
}
