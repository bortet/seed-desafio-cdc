package cv.hexadus.seeddesafiocdc.country;

import cv.hexadus.seeddesafiocdc.validator.ExistId;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class StateRegistrationRequest {
    @Valid
    @NotNull(message = "state registration information is required")
    private final StateRegistrationInformation stateRegistrationInformation;
    @ExistId(domainClass = Country.class, fieldName = "id")
    @NotNull(message = "country id is required")
    private final long countryId;

    public StateRegistrationRequest(StateRegistrationInformation stateRegistrationInformation, long countryId) {
        this.stateRegistrationInformation = stateRegistrationInformation;
        this.countryId = countryId;
    }

    public StateRegistrationInformation getStateRegistrationInformation() {
        return stateRegistrationInformation;
    }

    public long getCountryId() {
        return countryId;
    }

    public State getStateModal(EntityManager entityManager) {
        return new State(stateRegistrationInformation.getName().toLowerCase(),
                stateRegistrationInformation.getCode().toLowerCase(),
                entityManager.find(Country.class, countryId));
    }
}
