package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_VALIDITY_AFTER_OPEN", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_VALIDITY_AFTER_OPEN", sequenceName = "TB_VALIDITY_AFTER_OPEN_ID_VALIDITY_AFTER_OPEN_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class ValidityAfterOpenEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VALIDITY_AFTER_OPEN")
    @Column(name = "ID_VALIDITY_AFTER_OPEN")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
