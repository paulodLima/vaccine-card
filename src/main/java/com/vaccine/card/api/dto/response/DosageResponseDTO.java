package com.vaccine.card.api.dto.response;

public class DosageResponseDTO extends CommonResponseDTO {

    private Integer recommendedAge;
    private Integer reinforcement;

    public Integer getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(Integer recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public Integer getReinforcement() {
        return reinforcement;
    }

    public void setReinforcement(Integer reinforcement) {
        this.reinforcement = reinforcement;
    }
}
