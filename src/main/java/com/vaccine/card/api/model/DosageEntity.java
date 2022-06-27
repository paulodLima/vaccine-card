package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_DOSAGE", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_DOSAGE", sequenceName = "TB_DOSAGE_ID_DOSAGE_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class DosageEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOSAGE")
    @Column(name = "ID_DOSAGE")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RECOMMENDED_AGE", nullable = false)
    private RecommendedAgeEntity recommendedAgeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_REINFORCEMENT", nullable = false)
    private ReinforcementEntity reinforcementEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecommendedAgeEntity getRecommendedAgeEntity() {
        return recommendedAgeEntity;
    }

    public void setRecommendedAgeEntity(RecommendedAgeEntity recommendedAgeEntity) {
        this.recommendedAgeEntity = recommendedAgeEntity;
    }

    public ReinforcementEntity getReinforcementEntity() {
        return reinforcementEntity;
    }

    public void setReinforcementEntity(ReinforcementEntity reinforcementEntity) {
        this.reinforcementEntity = reinforcementEntity;
    }
}
