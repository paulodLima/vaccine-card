package com.vaccine.card.api.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"uuid"})
public class VaccineResponseDTO {

    private String name;
    private String description;
    private String applicationLocation;
    private String basicVaccination;
    private String composition;
    private String disease;
    private List<DosageResponseDTO> dosages;
    private String needle;
    private String routeAdministration;
    private String sideEffect;
    private String validityAfterOpen;
    private String uuid;

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

    public String getApplicationLocation() {
        return applicationLocation;
    }

    public void setApplicationLocation(String applicationLocation) {
        this.applicationLocation = applicationLocation;
    }

    public String getBasicVaccination() {
        return basicVaccination;
    }

    public void setBasicVaccination(String basicVaccination) {
        this.basicVaccination = basicVaccination;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public List<DosageResponseDTO> getDosages() {
        return dosages;
    }

    public void setDosages(List<DosageResponseDTO> dosages) {
        this.dosages = dosages;
    }

    public String getNeedle() {
        return needle;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    public String getRouteAdministration() {
        return routeAdministration;
    }

    public void setRouteAdministration(String routeAdministration) {
        this.routeAdministration = routeAdministration;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getValidityAfterOpen() {
        return validityAfterOpen;
    }

    public void setValidityAfterOpen(String validityAfterOpen) {
        this.validityAfterOpen = validityAfterOpen;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
