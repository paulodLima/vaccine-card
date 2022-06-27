package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_NEEDLE", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_NEEDLE", sequenceName = "TB_NEEDLE_ID_NEEDLE_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class NeedleEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NEEDLE")
    @Column(name = "ID_NEEDLE")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
