package com.vaccine.card.api.exception;

public enum MessageErrorImpl implements MessageError {

    MALFORMED_REQUEST_JSON(1),
    JSON_TO_OBJECT_FAIL(2),
    OBJECT_TO_JSON_FAIL(3),
    SERVICE_UNAVAILABLE(4),
    INVALID_DOCUMENT_NUMBER(5),
    DISEASE(6),
    RESOURCE_NOT_FOUND(7),
    RESOURCE_ALREADY_REGISTERED(8),
    COMPOSITION(9),
    RESOURCE(10),
    APPLICATION_LOCATION(11),
    BASIC_VACCINATION(12),
    DOSAGE(13),
    NEEDLE(14),
    RECOMMENDED_AGE(15),
    REINFORCEMENT(16),
    ADMINISTRATION_ROUTE(17),
    SIDE_EFFECT(18),
    VALIDITY_AFTER_OPEN(19),
    VACCINE(20);


    private Integer code;

    MessageErrorImpl(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
