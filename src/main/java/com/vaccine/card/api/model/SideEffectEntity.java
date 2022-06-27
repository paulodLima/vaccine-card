package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_SIDE_EFFECT", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_SIDE_EFFECT", sequenceName = "TB_SIDE_EFFECT_ID_SIDE_EFFECT_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class SideEffectEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SIDE_EFFECT")
    @Column(name = "ID_SIDE_EFFECT")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
