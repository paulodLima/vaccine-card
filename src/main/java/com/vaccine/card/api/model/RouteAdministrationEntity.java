package com.vaccine.card.api.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ROUTE_ADMINISTRATION", schema = "DBVACCINE")
@SequenceGenerator(name = "SEQ_ROUTE_ADMINISTRATION", sequenceName = "TB_ROUTE_ADMINISTRATION_ID_ROUTE_ADMINISTRATION_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class RouteAdministrationEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROUTE_ADMINISTRATION")
    @Column(name = "ID_ROUTE_ADMINISTRATION")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
