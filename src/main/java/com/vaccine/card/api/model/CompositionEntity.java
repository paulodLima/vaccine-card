package com.vaccine.card.api.model;


import javax.persistence.*;

@Entity
@Table(name = "TB_COMPOSITION", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_COMPOSITION", sequenceName = "TB_COMPOSITION_ID_COMPOSITION_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class CompositionEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMPOSITION")
    @Column(name = "ID_COMPOSITION")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
