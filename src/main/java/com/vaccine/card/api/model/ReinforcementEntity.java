package com.vaccine.card.api.model;


import javax.persistence.*;

@Entity
@Table(name = "TB_REINFORCEMENT", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_REINFORCEMENT", sequenceName = "TB_REINFORCEMENT_ID_REINFORCEMENT_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class ReinforcementEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REINFORCEMENT")
    @Column(name = "ID_REINFORCEMENT")
    private Long id;

    @Column(name = "REINFORCEMENT", nullable = false)
    private Integer reinforcement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReinforcement() {
        return reinforcement;
    }

    public void setReinforcement(Integer reinforcement) {
        this.reinforcement = reinforcement;
    }
}
