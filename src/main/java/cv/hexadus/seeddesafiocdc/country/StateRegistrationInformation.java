package cv.hexadus.seeddesafiocdc.country;

import cv.hexadus.seeddesafiocdc.validator.UniqueValue;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class StateRegistrationInformation {

    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name")
    private final String name;
    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "code")
    private final String code;

    public StateRegistrationInformation(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public State getModal() {
        return new State(this.name.toLowerCase().trim(), this.code.toLowerCase().trim());
    }
}
