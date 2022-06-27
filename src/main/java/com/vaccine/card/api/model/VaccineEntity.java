package com.vaccine.card.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_VACCINE", schema = "DBVACCINE", uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})})
@SequenceGenerator(name = "SEQ_VACCINE", sequenceName = "TB_VACCINE_ID_VACCINE_seq",
        allocationSize = 1, schema = "DBVACCINE")
public class VaccineEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VACCINE")
    @Column(name = "ID_VACCINE")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_APPLICATION_LOCATION", nullable = false)
    private ApplicationLocationEntity applicationLocationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BASIC_VACCINATION", nullable = false)
    private BasicVaccinationEntity basicVaccinationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPOSITION", nullable = false)
    private CompositionEntity compositionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISEASE", nullable = false)
    private DiseaseEntity diseaseEntity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.ALL})
    @JoinTable(
            name = "TB_VACCINE_DOSAGE", schema = "DBVACCINE",
            joinColumns = @JoinColumn(name = "ID_VACCINE", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ID_DOSAGE", nullable = false))
    private List<DosageEntity> dosageEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NEEDLE", nullable = false)
    private NeedleEntity needleEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ROUTE_ADMINISTRATION", nullable = false)
    private RouteAdministrationEntity routeAdministrationEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SIDE_EFFECT", nullable = false)
    private SideEffectEntity sideEffectEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VALIDITY_AFTER_OPEN", nullable = false)
    private ValidityAfterOpenEntity validityAfterOpenEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationLocationEntity getApplicationLocationEntity() {
        return applicationLocationEntity;
    }

    public void setApplicationLocationEntity(ApplicationLocationEntity applicationLocationEntity) {
        this.applicationLocationEntity = applicationLocationEntity;
    }

    public BasicVaccinationEntity getBasicVaccinationEntity() {
        return basicVaccinationEntity;
    }

    public void setBasicVaccinationEntity(BasicVaccinationEntity basicVaccinationEntity) {
        this.basicVaccinationEntity = basicVaccinationEntity;
    }

    public CompositionEntity getCompositionEntity() {
        return compositionEntity;
    }

    public void setCompositionEntity(CompositionEntity compositionEntity) {
        this.compositionEntity = compositionEntity;
    }

    public DiseaseEntity getDiseaseEntity() {
        return diseaseEntity;
    }

    public void setDiseaseEntity(DiseaseEntity diseaseEntity) {
        this.diseaseEntity = diseaseEntity;
    }

    public List<DosageEntity> getDosageEntities() {
        return dosageEntities;
    }

    public void setDosageEntities(List<DosageEntity> dosageEntity) {
        this.dosageEntities = dosageEntity;
    }

    public NeedleEntity getNeedleEntity() {
        return needleEntity;
    }

    public void setNeedleEntity(NeedleEntity needleEntity) {
        this.needleEntity = needleEntity;
    }


    public RouteAdministrationEntity getRouteAdministrationEntity() {
        return routeAdministrationEntity;
    }

    public void setRouteAdministrationEntity(RouteAdministrationEntity routeAdministrationEntity) {
        this.routeAdministrationEntity = routeAdministrationEntity;
    }

    public SideEffectEntity getSideEffectEntity() {
        return sideEffectEntity;
    }

    public void setSideEffectEntity(SideEffectEntity sideEffectEntity) {
        this.sideEffectEntity = sideEffectEntity;
    }

    public ValidityAfterOpenEntity getValidityAfterOpenEntity() {
        return validityAfterOpenEntity;
    }

    public void setValidityAfterOpenEntity(ValidityAfterOpenEntity validityAfterOpenEntity) {
        this.validityAfterOpenEntity = validityAfterOpenEntity;
    }
}
