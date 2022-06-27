package com.vaccine.card.api.repository;

import com.vaccine.card.api.model.RecommendedAgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecommendedAgeRepository extends JpaRepository<RecommendedAgeEntity, Long>, CommonRepository {

    @Query(value = "select rec from RecommendedAgeEntity rec where rec.uuid = :uuid")
    Optional<RecommendedAgeEntity> findByUuid(@Param("uuid") String uuid);
}
