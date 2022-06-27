package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_DISEASE", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_DISEASE", sequenceName = "TB_DISEASE_ID_DISEASE_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class DiseaseEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DISEASE")
    @Column(name = "ID_DISEASE")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
