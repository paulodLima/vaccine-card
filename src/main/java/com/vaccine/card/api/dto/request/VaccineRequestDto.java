package com.vaccine.card.api.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class VaccineRequestDto {

    @NotBlank
    private String applicationLocationId;
    @NotBlank
    private String basicVaccinationId;
    @NotBlank
    private String compositionId;
    @NotBlank
    private String diseaseId;
    @NotNull
    private List<String> dosageIds;
    @NotBlank
    private String needleId;
    @NotBlank
    private String routeAdministrationId;
    @NotBlank
    private String sideEffectId;
    @NotBlank
    private String validityAfterOpenId;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public String getApplicationLocationId() {
        return applicationLocationId;
    }

    public void setApplicationLocationId(String applicationLocationId) {
        this.applicationLocationId = applicationLocationId;
    }

    public String getBasicVaccinationId() {
        return basicVaccinationId;
    }

    public void setBasicVaccinationId(String basicVaccinationId) {
        this.basicVaccinationId = basicVaccinationId;
    }

    public String getCompositionId() {
        return compositionId;
    }

    public void setCompositionId(String compositionId) {
        this.compositionId = compositionId;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(String diseaseId) {
        this.diseaseId = diseaseId;
    }

    public List<String> getDosageIds() {
        return dosageIds;
    }

    public void setDosageIds(List<String> dosageIds) {
        this.dosageIds = dosageIds;
    }

    public String getNeedleId() {
        return needleId;
    }

    public void setNeedleId(String needleId) {
        this.needleId = needleId;
    }

    public String getRouteAdministrationId() {
        return routeAdministrationId;
    }

    public void setRouteAdministrationId(String routeAdministrationId) {
        this.routeAdministrationId = routeAdministrationId;
    }

    public String getSideEffectId() {
        return sideEffectId;
    }

    public void setSideEffectId(String sideEffectId) {
        this.sideEffectId = sideEffectId;
    }

    public String getValidityAfterOpenId() {
        return validityAfterOpenId;
    }

    public void setValidityAfterOpenId(String validityAfterOpenId) {
        this.validityAfterOpenId = validityAfterOpenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
