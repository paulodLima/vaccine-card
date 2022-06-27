package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.RouteAdministrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RouteAdministrationRepository extends JpaRepository<RouteAdministrationEntity, Long>, CommonRepository {

    @Query(value = "select route from RouteAdministrationEntity route where route.uuid = :uuid")
    Optional<RouteAdministrationEntity> findByUuid(@Param("uuid") String uuid);
}
