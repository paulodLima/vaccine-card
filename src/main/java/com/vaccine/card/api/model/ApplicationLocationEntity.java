package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_APPLICATION_LOCATION", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_APPLICATION_LOCATION", sequenceName = "TB_APPLICATION_LOCATION_ID_APPLICATION_LOCATION_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class ApplicationLocationEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_APPLICATION_LOCATION")
    @Column(name = "ID_APPLICATION_LOCATION")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
