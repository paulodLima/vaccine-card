package com.vaccine.card.api.model;


import javax.persistence.*;

@Entity
@Table(name = "TB_BASIC_VACCINATION", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_BASIC_VACCINATION", sequenceName = "TB_BASIC_VACCINATION_ID_BASIC_VACCINATION_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class BasicVaccinationEntity extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BASIC_VACCINATION")
    @Column(name = "ID_BASIC_VACCINATION")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
