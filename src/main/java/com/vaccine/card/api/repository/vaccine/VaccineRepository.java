package com.vaccine.card.api.repository.vaccine;

import com.vaccine.card.api.model.VaccineEntity;
import com.vaccine.card.api.repository.CommonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VaccineRepository extends JpaRepository<VaccineEntity, Long>, CommonRepository, VaccineQuery {

    @Query(value = "select vaccine from VaccineEntity vaccine where vaccine.uuid = :uuid")
    Optional<VaccineEntity> findByUuid(@Param("uuid") String uuid);
}
