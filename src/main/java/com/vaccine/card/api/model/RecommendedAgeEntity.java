package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_RECOMMENDED_AGE", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_RECOMMENDED_AGE", sequenceName = "TB_RECOMMENDED_AGE_ID_RECOMMENDED_AGE_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class RecommendedAgeEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECOMMENDED_AGE")
    @Column(name = "ID_RECOMMENDED_AGE")
    private Long id;

    @Column(name = "RECOMMENDED_AGE", nullable = false)
    private Integer recommendedAge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(Integer recommendedAge) {
        this.recommendedAge = recommendedAge;
    }
}
